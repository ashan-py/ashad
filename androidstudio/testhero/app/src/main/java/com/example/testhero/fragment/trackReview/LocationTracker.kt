package com.example.testhero.fragment.trackReview

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import android.os.Looper
import com.example.testhero.fragment.trackReview.model.LocationRecord
import com.google.android.gms.location.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class LocationTracker(
    private val context: Context,
    private val viewModel: TrackReviewViewModel
) {

    private val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)
    private val locationRequest = LocationRequest.Builder(
        Priority.PRIORITY_HIGH_ACCURACY,
        5 * 60 * 1000 // 5분
    ).apply {
        setMinUpdateIntervalMillis(2 * 60 * 1000) // 최소 2분
    }.build()

    private val locationCallback = object : LocationCallback() {
        override fun onLocationResult(result: LocationResult) {
            super.onLocationResult(result)
            for (location in result.locations) {
                saveLocation(location)
            }
        }
    }

    @SuppressLint("MissingPermission")
    fun startLocationUpdates() {
        fusedLocationClient.requestLocationUpdates(
            locationRequest,
            locationCallback,
            Looper.getMainLooper()
        )
    }

    fun stopLocationUpdates() {
        fusedLocationClient.removeLocationUpdates(locationCallback)
    }

    private fun saveLocation(location: Location) {
        val now = Date()
        val date = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(now) // ⬅ 원래대로
        val time = SimpleDateFormat("HH:mm", Locale.getDefault()).format(now)

        val record = LocationRecord(
            date = date,
            latitude = location.latitude,
            longitude = location.longitude,
            timestamp = time
        )

        CoroutineScope(Dispatchers.IO).launch {
            viewModel.saveLocationRecord(record)
        }
    }
}