package com.example.testhero.fragment

import android.content.SharedPreferences
import android.os.*
import android.util.Log
import android.view.*
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.testhero.R
import java.util.*

class MedicationFragment : Fragment() {

    private lateinit var buttons: List<Button>
    private lateinit var buttonStates: MutableList<Boolean>
    private lateinit var prefs: SharedPreferences

    private val handler = Handler(Looper.getMainLooper())
    private var resetRunnable: Runnable? = null

    // 원하는 초기화 시간 설정 (예: 자정 기준 초기화)
    private val resetHour = 0
    private val resetMinute = 0
    private val resetSecond = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_medication, container, false)
        prefs = requireContext().getSharedPreferences("medication_prefs", 0)

        // 복용 상태 버튼 리스트 초기화
        buttons = listOf(
            view.findViewById(R.id.button1),
            view.findViewById(R.id.button2),
            view.findViewById(R.id.button3),
            view.findViewById(R.id.button4),
            view.findViewById(R.id.button5),
            view.findViewById(R.id.button6)
        )

        // 버튼 상태 불러오기
        buttonStates = MutableList(buttons.size) { index ->
            prefs.getBoolean("button$index", false)
        }

        buttons.forEachIndexed { index, button ->
            setButtonState(button, buttonStates[index])
            button.setOnClickListener {
                buttonStates[index] = !buttonStates[index]
                setButtonState(button, buttonStates[index])
                prefs.edit().putBoolean("button$index", buttonStates[index]).apply()
            }
        }

        // 뒤로가기 버튼 설정
        view.findViewById<Button>(R.id.button_back).setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        // 수동 초기화 검사
        manualResetIfNeeded()

        // 자동 초기화 예약
        scheduleReset()

        return view
    }

    private fun setButtonState(button: Button, isChecked: Boolean) {
        if (isChecked) {
            button.text = "✓"
            button.setBackgroundResource(R.drawable.circle_button_checked)
        } else {
            button.text = "X"
            button.setBackgroundResource(R.drawable.circle_button)
        }
    }

    private fun manualResetIfNeeded() {
        val now = Calendar.getInstance(TimeZone.getTimeZone("Asia/Seoul"))
        val lastResetTime = prefs.getLong("last_reset_time", 0)

        val resetTimeToday = Calendar.getInstance(TimeZone.getTimeZone("Asia/Seoul")).apply {
            set(Calendar.HOUR_OF_DAY, resetHour)
            set(Calendar.MINUTE, resetMinute)
            set(Calendar.SECOND, resetSecond)
            set(Calendar.MILLISECOND, 0)
            if (now.before(this)) add(Calendar.DATE, -1)
        }

        if (lastResetTime < resetTimeToday.timeInMillis) {
            Log.d("MedicationFragment", "수동 초기화 실행됨")
            resetButtons()
            prefs.edit().putLong("last_reset_time", System.currentTimeMillis()).apply()
        } else {
            Log.d("MedicationFragment", "수동 초기화 불필요")
        }
    }

    private fun resetButtons() {
        val editor = prefs.edit()
        for (i in buttonStates.indices) {
            buttonStates[i] = false
            editor.putBoolean("button$i", false)
        }
        editor.apply()

        buttons.forEach { setButtonState(it, false) }
    }

    private fun scheduleReset() {
        resetRunnable?.let { handler.removeCallbacks(it) }

        val now = Calendar.getInstance(TimeZone.getTimeZone("Asia/Seoul"))
        val nextResetTime = Calendar.getInstance(TimeZone.getTimeZone("Asia/Seoul")).apply {
            set(Calendar.HOUR_OF_DAY, resetHour)
            set(Calendar.MINUTE, resetMinute)
            set(Calendar.SECOND, resetSecond)
            set(Calendar.MILLISECOND, 0)

            if (before(now)) add(Calendar.DATE, 1)
        }

        val delayMillis = nextResetTime.timeInMillis - now.timeInMillis
        Log.d("MedicationFragment", "다음 초기화 예약 시간: ${nextResetTime.time} (딜레이: $delayMillis ms)")

        resetRunnable = Runnable {
            Log.d("MedicationFragment", "예약된 초기화 실행")
            resetButtons()
            prefs.edit().putLong("last_reset_time", System.currentTimeMillis()).apply()
            scheduleReset() // 다음 예약
        }

        handler.postDelayed(resetRunnable!!, delayMillis)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        resetRunnable?.let { handler.removeCallbacks(it) }
    }
}
