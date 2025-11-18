package com.example.testhero.fragment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.testhero.R
import kotlin.random.Random

class FocusGameFragment : Fragment() {

    private lateinit var gridLayout: GridLayout
    private lateinit var scoreText: TextView
    private lateinit var timerText: TextView
    private lateinit var resultText: TextView
    private lateinit var retryButton: Button
    private lateinit var backButton: Button

    private var score = 0
    private var timeLeft = 30
    private var targetIndex = -1
    private var isGameActive = false
    private var isTimerStarted = false // ✅ 추가

    private val handler = Handler(Looper.getMainLooper())
    private var timerRunnable: Runnable? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_focus_game, container, false)

        gridLayout = view.findViewById(R.id.grid_layout)
        scoreText = view.findViewById(R.id.text_score)
        timerText = view.findViewById(R.id.text_timer)
        resultText = view.findViewById(R.id.text_result)
        retryButton = view.findViewById(R.id.button_retry)
        backButton = view.findViewById(R.id.button_back)

        retryButton.setOnClickListener {
            score = 0
            timeLeft = 30
            isTimerStarted = false // ✅ 재시작 시 초기화
            resultText.visibility = View.GONE
            retryButton.visibility = View.GONE
            backButton.visibility = View.GONE
            startGame()
        }

        backButton.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, TabBarFragment())
                .commit()
        }

        startGame()
        return view
    }

    private fun startGame() {
        isGameActive = true
        updateScore()
        generateGrid()
        timerText.text = "⏱ 시간: ${timeLeft}초" // 시작 전 타이머 텍스트 초기화
    }

    private fun updateScore() {
        scoreText.text = "점수: $score"
    }

    private fun startTimer() {
        timerRunnable = object : Runnable {
            override fun run() {
                timeLeft--
                if (timeLeft >= 0) {
                    timerText.text = "⏱ 시간: ${timeLeft}초"
                    handler.postDelayed(this, 1000)
                } else {
                    endGame()
                }
            }
        }
        handler.postDelayed(timerRunnable!!, 1000)
    }

    private fun stopTimer() {
        timerRunnable?.let { handler.removeCallbacks(it) }
    }

    private fun endGame() {
        isGameActive = false
        stopTimer()
        resultText.text = "📅 시간 종료! 총 점수: $score"
        resultText.visibility = View.VISIBLE
        retryButton.visibility = View.VISIBLE
        backButton.visibility = View.VISIBLE
    }

    private fun generateGrid() {
        gridLayout.removeAllViews()
        val rowCount = 3
        val columnCount = 3
        gridLayout.rowCount = rowCount
        gridLayout.columnCount = columnCount

        val total = rowCount * columnCount
        targetIndex = Random.nextInt(total)

        for (i in 0 until total) {
            val button = Button(requireContext())
            button.layoutParams = GridLayout.LayoutParams().apply {
                width = 0
                height = 0
                rowSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f)
                columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f)
                setMargins(8, 8, 8, 8)
            }
            button.text = if (i == targetIndex) "O" else "X"
            button.textSize = 24f // ✅ 글자 크기 키움

            button.setOnClickListener {
                if (!isGameActive) return@setOnClickListener
                if (!isTimerStarted) {
                    isTimerStarted = true
                    startTimer()
                }
                if (i == targetIndex) {
                    score++
                    updateScore()
                    generateGrid()
                } else {
                    generateGrid()
                }
            }
            gridLayout.addView(button)
        }
    }
}