package com.example.testhero.fragment.trackReview

import android.content.Context
import android.util.Log
import com.example.testhero.fragment.trackReview.model.LocationRecord
import com.example.testhero.fragment.trackReview.model.StopInfo
import com.example.testhero.fragment.trackReview.utils.LocationUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.*

class LocationRepository(context: Context) {

    private val dao = LocationDatabase.getInstance(context).locationDao()

    suspend fun saveLocation(record: LocationRecord) {
        Log.d("LocationRepository", "✅ 위치 저장됨: $record")
        dao.insertLocation(record)

        // ✅ 저장 후 오래된 날짜 정리
        pruneOldDates(10)
    }

    suspend fun getLocationsByDate(date: String): List<LocationRecord> {
        val result = dao.getLocationsByDate(date)
        Log.d("LocationRepository", "📆 $date 기준 위치 ${result.size}개 불러옴")
        return result
    }

    suspend fun getRecentDates(limit: Int = 10): List<String> {
        val allDates = dao.getRecentDates(limit * 2) // 여유롭게 가져오기
        val today = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
        val filtered = allDates.filter { it < today }.take(limit)
        Log.d("LocationRepository", "🗂️ 최근 날짜 (오늘 이전 필터링): $filtered")
        return filtered
    }

    suspend fun pruneOldDates(limit: Int = 10) {
        val dates = dao.getRecentDates(limit)
        if (dates.size > limit) {
            val toDelete = dates.drop(limit)
            withContext(Dispatchers.IO) {
                toDelete.forEach { date ->
                    dao.deleteByDate(date)
                    Log.d("LocationRepository", "🗑️ 오래된 날짜 삭제됨: $date")
                }
            }
        }
    }

    suspend fun getStops(date: String): List<StopInfo> {
        val points = getLocationsByDate(date)
        if (points.isEmpty()) return emptyList()

        val result = mutableListOf<StopInfo>()
        var start = points.first()
        var end = start

        for (point in points) {
            val distance = LocationUtils.distanceBetween(
                start.latitude, start.longitude,
                point.latitude, point.longitude
            )
            val timeDiff = LocationUtils.minutesBetween(start.timestamp, point.timestamp)

            if (distance <= 100) {
                end = point
                if (timeDiff >= 2) {//60으로
                    result.add(
                        StopInfo(
                            latitude = start.latitude,
                            longitude = start.longitude,
                            fromTime = start.timestamp,
                            toTime = end.timestamp
                        )
                    )
                    start = point
                }
            } else {
                start = point
            }
        }

        Log.d("LocationRepository", "🛑 정차 지점 ${result.size}개 찾음")
        return result
    }
}