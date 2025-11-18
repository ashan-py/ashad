package com.example.testhero.fragment.trackReview.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "location_records")
data class LocationRecord(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val date: String,               // yyyy-MM-dd
    val latitude: Double,
    val longitude: Double,
    val timestamp: String           // HH:mm
)