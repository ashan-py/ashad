package com.example.testhero.fragment

import android.Manifest
import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.os.CountDownTimer
import android.telephony.SmsManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.example.testhero.R

class EmergencyFragment : Fragment() {

    private var timer: CountDownTimer? = null
    private lateinit var guardianPhone: String
    private lateinit var userName: String   // 사용자 이름 변수 추가

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_empty_emergency, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val prefs = requireContext().getSharedPreferences("user_info", 0)
        guardianPhone = prefs.getString("guardianPhone", "") ?: ""
        userName = prefs.getString("name", "") ?: ""    // 이름 불러오기

        if (guardianPhone.isEmpty()) {
            Toast.makeText(requireContext(), "보호자 전화번호가 설정되지 않았습니다.", Toast.LENGTH_SHORT).show()
            parentFragmentManager.popBackStack()
            return
        }

        ActivityCompat.requestPermissions(
            requireActivity(),
            arrayOf(Manifest.permission.SEND_SMS),
            1
        )

        // 1차 다이얼로그 (Y/N 선택)
        val dialogBuilder = AlertDialog.Builder(requireContext())
            .setTitle("위급 상황")
            .setMessage("위급하십니까? (30초 후 자동 전송)")
            .setPositiveButton("Y") { _: DialogInterface, _: Int ->
                sendEmergencyMessage()
                timer?.cancel()
                parentFragmentManager.popBackStack()
            }
            .setNegativeButton("N") { _: DialogInterface, _: Int ->
                timer?.cancel()
                Toast.makeText(requireContext(), "전송이 취소되었습니다.", Toast.LENGTH_SHORT).show()
                parentFragmentManager.popBackStack()
            }

        val dialog = dialogBuilder.create()
        dialog.show()

        val messageView = dialog.findViewById<TextView>(android.R.id.message)

        timer = object : CountDownTimer(30_000, 1_000) {
            override fun onTick(millisUntilFinished: Long) {
                val secondsLeft = millisUntilFinished / 1000
                messageView?.text = "위급하십니까? (${secondsLeft}초 후 자동 전송)"
            }

            override fun onFinish() {
                if (!isAdded) return
                dialog.dismiss()  // 기존 Y/N 다이얼로그 닫기
                sendEmergencyMessage()
                showResultDialog()
            }
        }.start()

        dialog.setCanceledOnTouchOutside(true)
        dialog.setOnCancelListener {
            timer?.cancel()
            parentFragmentManager.popBackStack()
        }
    }

    private fun showResultDialog() {
        if (!isAdded) return

        AlertDialog.Builder(requireContext())
            .setTitle("전송 완료")
            .setMessage("위급 메시지가 자동 전송되었습니다.")
            .setPositiveButton("확인") { _, _ ->
                parentFragmentManager.popBackStack()
            }
            .setCancelable(false)
            .show()
    }

    private fun sendEmergencyMessage() {
        try {
            val sms = SmsManager.getDefault()
            val message = if (userName.isNotBlank()) {
                "${userName}님이 위급버튼을 눌렀습니다. 빠른 확인 부탁드립니다."
            } else {
                "위급버튼을 눌렀습니다. 빠른 확인 부탁드립니다."
            }
            sms.sendTextMessage(
                guardianPhone,
                null,
                message,
                null,
                null
            )
            Toast.makeText(requireContext(), "위급 메시지 전송 완료", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            Toast.makeText(requireContext(), "전송 실패: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        timer?.cancel()
    }
}