package com.example.testhero.fragment.trackReview.service

import android.app.*
import android.content.Context
import android.content.Intent
import android.location.Location
import android.os.Build
import android.os.IBinder
import android.os.Looper
import android.util.Log
import androidx.core.app.NotificationCompat
import com.example.testhero.R
import com.example.testhero.fragment.trackReview.model.LocationRecord
import com.example.testhero.fragment.trackReview.LocationRepository
import com.google.android.gms.location.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class LocationForegroundService : Service() {

    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var locationRequest: LocationRequest
    private var lastSavedLocation: Location? = null

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        locationRequest = LocationRequest.Builder(
            Priority.PRIORITY_HIGH_ACCURACY,
            30 * 1000L // 30초주기로 받아라
        ).apply {
            setMinUpdateIntervalMillis(10 * 1000L) // 최소 10초
            setMinUpdateDistanceMeters(20f) //20미터 이상 움직였을 때만 위치 업데이트
        }.build()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("위치 추적 중")
            .setContentText("앱이 백그라운드에서도 위치를 저장하고 있어요.")
            .setSmallIcon(android.R.drawable.ic_menu_mylocation)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .build()

        startForeground(NOTIFICATION_ID, notification)
        startLocationUpdates()
        return START_STICKY
    }

    @android.annotation.SuppressLint("MissingPermission")
    private fun startLocationUpdates() {
        fusedLocationClient.requestLocationUpdates(
            locationRequest,
            object : LocationCallback() {
                override fun onLocationResult(result: LocationResult) {
//                    super.onLocationResult(result)
                    for (location in result.locations) {
                        if (shouldSave(location)) {
                            saveLocation(location)
                            lastSavedLocation = location
                        }
                    }
                }
            },
            Looper.getMainLooper()
        )
    }

    private fun shouldSave(newLocation: Location): Boolean {
        val last = lastSavedLocation ?: return true
        val distance = last.distanceTo(newLocation)
        return distance >= 20
    }

    private fun saveLocation(location: Location) {
        val now = Date()
        val date = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(now) // ⬅ 하루 기준
        val time = SimpleDateFormat("HH:mm", Locale.getDefault()).format(now)

        val record = LocationRecord(
            date = date,
            latitude = location.latitude,
            longitude = location.longitude,
            timestamp = time
        )

        CoroutineScope(Dispatchers.IO).launch {
            LocationRepository(applicationContext).saveLocation(record)
            Log.d("LocationService", "✅ 저장됨: $record")
        }
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                "Location Tracking",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }
    }

    override fun onBind(intent: Intent?): IBinder? = null

    companion object {
        const val CHANNEL_ID = "location_tracking_channel"
        const val NOTIFICATION_ID = 1001
    }
}