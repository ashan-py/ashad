package com.example.testhero.fragment.trackReview.utils

import android.location.Location
import java.text.SimpleDateFormat
import java.util.*

object LocationUtils {

    /**
     * 두 위치 간의 거리 계산 (단위: meter)
     */
    fun distanceBetween(lat1: Double, lon1: Double, lat2: Double, lon2: Double): Float {
        val result = FloatArray(1)
        Location.distanceBetween(lat1, lon1, lat2, lon2, result)
        return result[0]
    }

    /**
     * HH:mm 형식의 시간 문자열 두 개 사이의 차이를 분 단위로 계산
     */
    fun minutesBetween(startTime: String, endTime: String): Int {
        return try {
            val format = SimpleDateFormat("HH:mm", Locale.getDefault())
            val start = format.parse(startTime)
            val end = format.parse(endTime)

            val diffMillis = end.time - start.time
            (diffMillis / (1000 * 60)).toInt()
        } catch (e: Exception) {
            e.printStackTrace()
            0
        }
    }
}