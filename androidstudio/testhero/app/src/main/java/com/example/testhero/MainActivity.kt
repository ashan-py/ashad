package com.example.testhero

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.testhero.fragment.TabBarFragment
import com.example.testhero.fragment.trackReview.TrackReviewFragment
import com.example.testhero.fragment.trackReview.service.LocationForegroundService
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.example.testhero.fragment.GpsFragment


class MainActivity : AppCompatActivity() {

    // ✅ 권한 요청 런처 정의
    private val locationPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
            val fineGranted = permissions[Manifest.permission.ACCESS_FINE_LOCATION] ?: false
            val bgGranted = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                permissions[Manifest.permission.ACCESS_BACKGROUND_LOCATION] ?: false
            } else true

            if (fineGranted && bgGranted) {
                Toast.makeText(this, "위치 권한이 허용되었습니다", Toast.LENGTH_SHORT).show()
                startLocationForegroundService()
            } else {
                showPermissionDeniedDialog()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ✅ 위치 권한 요청
        requestLocationPermissions()

        // 초기 홈 Fragment 로드
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, TabBarFragment())
            .commit()

        // 네비게이션 바 클릭 처리
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav)
        bottomNav.selectedItemId = R.id.nav_home
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, TabBarFragment())
                        .commit()
                    true
                }
                R.id.nav_gps -> { // GPS Fragment 연결
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, TrackReviewFragment())
                        .commit()
                    true
                }
                R.id.nav_left -> { // QuizAndDiagnosisFragment 연결
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, QuizAndDiagnosisFragment())
                        .commit()
                    true
                }

                else -> false
            }
        }
    }
    // ✅ 권한 요청 함수
    private fun requestLocationPermissions() {
        val permissions = mutableListOf(
            Manifest.permission.ACCESS_FINE_LOCATION
        )

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            permissions.add(Manifest.permission.ACCESS_BACKGROUND_LOCATION)
        }

        locationPermissionLauncher.launch(permissions.toTypedArray())
    }

    // ✅ 설정 이동 유도 다이얼로그
    private fun showPermissionDeniedDialog() {
        AlertDialog.Builder(this)
            .setTitle("권한 필요")
            .setMessage("위치 추적을 위해 권한이 필요합니다.\n앱 설정에서 직접 권한을 허용해주세요.")
            .setPositiveButton("설정으로 이동") { _, _ ->
                val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
                    data = Uri.fromParts("package", packageName, null)
                }
                startActivity(intent)
            }
            .setNegativeButton("취소", null)
            .show()
    }

    // ✅ 위치 추적 Foreground 서비스 시작
    private fun startLocationForegroundService() {
        val intent = Intent(this, LocationForegroundService::class.java)
        ContextCompat.startForegroundService(this, intent)
    }
}
