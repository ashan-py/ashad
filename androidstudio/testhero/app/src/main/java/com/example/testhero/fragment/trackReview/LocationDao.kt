package com.example.testhero.fragment.trackReview

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.testhero.fragment.trackReview.model.LocationRecord

@Dao
interface LocationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLocation(record: LocationRecord)

    @Query("SELECT * FROM location_records WHERE date = :date ORDER BY timestamp")
    suspend fun getLocationsByDate(date: String): List<LocationRecord>

    @Query("SELECT DISTINCT date FROM location_records ORDER BY date DESC LIMIT :limit")
    suspend fun getRecentDates(limit: Int): List<String>

    @Query("DELETE FROM location_records WHERE date = :date")
    suspend fun deleteByDate(date: String): Int  // ✅ 수정: 반환값 명시
}