package com.example.secondapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

class InfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_info)

        // 🔹 뒤로가기 버튼 설정
        val backButton = findViewById<Button>(R.id.button_back)
        backButton.setOnClickListener {
            finish()
        }

        // 🔹 편집 버튼 설정
        val editButton = findViewById<Button>(R.id.button_edit)
        editButton.setOnClickListener {
            startActivity(Intent(this, EditPersonalInfoActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        val sharedPref = getSharedPreferences("PersonalInfo", MODE_PRIVATE)

        // 🔹 데이터 불러오기
        findViewById<TextView>(R.id.text_name).text = "이름: " + sharedPref.getString("name", "없음")
        findViewById<TextView>(R.id.text_phone).text = "전화번호: " + sharedPref.getString("phone", "없음")
        findViewById<TextView>(R.id.text_guardian_name).text = "보호자 이름: " + sharedPref.getString("guardian_name", "없음")
        findViewById<TextView>(R.id.text_guardian_phone).text = "보호자 전화번호: " + sharedPref.getString("guardian_phone", "없음")
        findViewById<TextView>(R.id.text_remarks).text = "비고: " + sharedPref.getString("remarks", "없음")
    }
}
