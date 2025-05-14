package com.example.secondapp

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class EditPersonalInfoActivity : AppCompatActivity() {

    private lateinit var editName: EditText
    private lateinit var editPhone: EditText
    private lateinit var editGuardianName: EditText
    private lateinit var editGuardianPhone: EditText
    private lateinit var editRemarks: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_personal_info)

        // 🔹 EditText 연결
        editName = findViewById(R.id.edit_name)
        editPhone = findViewById(R.id.edit_phone)
        editGuardianName = findViewById(R.id.edit_guardian_name)
        editGuardianPhone = findViewById(R.id.edit_guardian_phone)
        editRemarks = findViewById(R.id.edit_remarks)

        // 🔹 SharedPreferences에서 기존 값 불러오기
        val sharedPref = getSharedPreferences("PersonalInfo", Context.MODE_PRIVATE)
        editName.setText(sharedPref.getString("name", ""))
        editPhone.setText(sharedPref.getString("phone", ""))
        editGuardianName.setText(sharedPref.getString("guardian_name", ""))
        editGuardianPhone.setText(sharedPref.getString("guardian_phone", ""))
        editRemarks.setText(sharedPref.getString("remarks", ""))

        // 🔹 저장 버튼 클릭 시 SharedPreferences에 저장
        findViewById<Button>(R.id.button_save).setOnClickListener {
            val editor = sharedPref.edit()
            editor.putString("name", editName.text.toString())
            editor.putString("phone", editPhone.text.toString())
            editor.putString("guardian_name", editGuardianName.text.toString())
            editor.putString("guardian_phone", editGuardianPhone.text.toString())
            editor.putString("remarks", editRemarks.text.toString())
            editor.apply()

            Toast.makeText(this, "저장되었습니다.", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}
