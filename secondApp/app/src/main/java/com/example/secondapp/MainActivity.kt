package com.example.secondapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // activity_main.xml을 화면으로 사용

        // 버튼 클릭 시 화면 이동
        findViewById<Button>(R.id.btn_info).setOnClickListener {
            startActivity(Intent(this, InfoActivity::class.java))
        }

        findViewById<Button>(R.id.btn_medicine).setOnClickListener {
            startActivity(Intent(this, MedicineActivity::class.java))
        }

        findViewById<Button>(R.id.btn_homeroute).setOnClickListener {
            startActivity(Intent(this, HomeRouteActivity::class.java))
        }

        findViewById<Button>(R.id.btn_emergency).setOnClickListener {
            startActivity(Intent(this, EmergencyActivity::class.java))
        }

        // 탭바 메뉴 클릭 시 화면 이동
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_history -> {
                    startActivity(Intent(this, HistoryActivity::class.java))
                    true
                }
                R.id.nav_home -> true // 현재 화면
                R.id.nav_settings -> {
                    startActivity(Intent(this, SettingsActivity::class.java))
                    true
                }
                else -> false
            }
        }
    }
}