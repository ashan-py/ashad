package com.example.testhero.fragment.trackReview

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.testhero.fragment.trackReview.model.LocationRecord

@Database(entities = [LocationRecord::class], version = 1)
abstract class LocationDatabase : RoomDatabase() {
    abstract fun locationDao(): LocationDao

    companion object {
        @Volatile private var INSTANCE: LocationDatabase? = null

        fun getInstance(context: Context): LocationDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    LocationDatabase::class.java,
                    "location_db"
                )
                    .fallbackToDestructiveMigration() // ✅ 이거 꼭 추가
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}