package com.example.testhero.fragment

import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.util.TypedValue
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment
import android.widget.GridLayout
import com.example.testhero.R
import kotlin.random.Random

class VisualGameFragment : Fragment() {

    private lateinit var gridLayout: GridLayout
    private lateinit var resultText: TextView
    private lateinit var retryButton: Button
    private lateinit var backToMenuButton: Button
    private lateinit var timerText: TextView
    private lateinit var guideText: TextView

    private var currentStage = 1
    private val maxStage = 4
    private var timer: CountDownTimer? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_visual_game, container, false)

        gridLayout = view.findViewById(R.id.grid_layout)
        resultText = view.findViewById(R.id.text_result)
        retryButton = view.findViewById(R.id.button_retry)
        backToMenuButton = view.findViewById(R.id.button_back_to_menu)
        timerText = view.findViewById(R.id.text_timer)
        guideText = view.findViewById(R.id.text_guide)

        retryButton.setOnClickListener {
            currentStage = 1
            resultText.text = ""
            retryButton.visibility = View.GONE
            backToMenuButton.visibility = View.GONE
            guideText.visibility = View.VISIBLE
            setupStage(currentStage)
        }

        backToMenuButton.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, QuizSelectFragment())
                .commit()
        }

        setupStage(currentStage)
        return view
    }

    private fun setupStage(stage: Int) {
        val size = stage + 2
        val total = size * size
        val differentIndex = Random.nextInt(total)

        gridLayout.removeAllViews()
        gridLayout.rowCount = size
        gridLayout.columnCount = size

        guideText.visibility = View.VISIBLE

        val normalColor = when (stage) {
            1 -> Color.parseColor("#7A4ED9") // 보라
            2 -> Color.parseColor("#FF9800") // 주황
            3 -> Color.parseColor("#4CAF50") // 초록
            4 -> Color.parseColor("#2196F3") // 파랑
            else -> Color.LTGRAY
        }

        val differentColor = when (stage) {
            1 -> Color.parseColor("#8A5EF0")
            2 -> Color.parseColor("#FFB84D")
            3 -> Color.parseColor("#66BB6A")
            4 -> Color.parseColor("#42A5F5")
            else -> Color.DKGRAY
        }

        startTimer(stage)

        for (i in 0 until total) {
            val button = Button(requireContext()).apply {
                layoutParams = GridLayout.LayoutParams().apply {
                    width = 0
                    height = 0
                    columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f)
                    rowSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f)
                    setMargins(8, 8, 8, 8)
                }

                // 배경 색상 설정
                setBackgroundColor(if (i == differentIndex) differentColor else normalColor)

                // 클릭 시 음영 효과 적용 (배경 유지)
                val typedValue = TypedValue()
                requireContext().theme.resolveAttribute(
                    android.R.attr.selectableItemBackground, typedValue, true
                )
                foreground = requireContext().getDrawable(typedValue.resourceId)

                isClickable = true
                isFocusable = true
            }

            button.setOnClickListener {
                stopTimer()

                if (i == differentIndex) {
                    if (currentStage < maxStage) {
                        resultText.text = "✅ 정답입니다!"
                        currentStage++
                        gridLayout.postDelayed({
                            resultText.text = ""
                            setupStage(currentStage)
                        }, 1500)
                    } else {
                        resultText.text = "🎉 모든 단계를 완료했습니다!"
                        retryButton.visibility = View.VISIBLE
                        backToMenuButton.visibility = View.VISIBLE
                    }
                } else {
                    resultText.text = "❌ 틀렸습니다. 다시 도전해보세요!"
                    retryButton.visibility = View.VISIBLE
                    backToMenuButton.visibility = View.VISIBLE
                }
            }

            gridLayout.addView(button)
        }
    }

    private fun startTimer(stage: Int) {
        val seconds = (11 - stage).coerceAtLeast(1)
        timer?.cancel()
        timer = object : CountDownTimer(seconds * 1000L, 1000L) {
            override fun onTick(millisUntilFinished: Long) {
                val remain = millisUntilFinished / 1000
                timerText.text = "남은 시간: ${remain}초"
            }

            override fun onFinish() {
                resultText.text = "⏰ 시간 초과! 다시 도전해보세요!"
                retryButton.visibility = View.VISIBLE
                backToMenuButton.visibility = View.VISIBLE
                timerText.text = "남은 시간: 0초"
            }
        }.start()
    }

    private fun stopTimer() {
        timer?.cancel()
    }
}