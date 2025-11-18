package com.example.testhero.fragment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.testhero.R
import kotlin.random.Random

class MemoryGameFragment : Fragment() {

    private lateinit var numberTextView: TextView
    private lateinit var inputEditText: EditText
    private lateinit var submitButton: Button
    private lateinit var resultTextView: TextView
    private lateinit var retryButton: Button
    private lateinit var backToMenuButton: Button

    private var answer: List<Int> = emptyList()
    private var currentStage = 1
    private val maxStage = 4

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_memory_game, container, false)

        numberTextView = view.findViewById(R.id.text_numbers)
        inputEditText = view.findViewById(R.id.edit_input)
        submitButton = view.findViewById(R.id.button_submit)
        resultTextView = view.findViewById(R.id.text_result)
        retryButton = view.findViewById(R.id.button_retry)
        backToMenuButton = view.findViewById(R.id.button_back_to_menu)

        startStage(currentStage)

        submitButton.setOnClickListener {
            val userInput = inputEditText.text.toString().trim()
            val userNumbers = userInput.split(" ").mapNotNull { it.toIntOrNull() }

            if (userNumbers == answer) {
                if (currentStage < maxStage) {
                    currentStage++
                    resultTextView.text = "정답입니다! 다음 단계로 넘어갑니다."
                    Handler(Looper.getMainLooper()).postDelayed({
                        startStage(currentStage)
                    }, 1500)
                } else {
                    resultTextView.text = "🎉 모든 단계를 완료했습니다!"
                    showEndButtons()
                }
            } else {
                resultTextView.text = "틀렸습니다. 정답은 ${answer.joinToString(" ")}"
                showEndButtons()
            }
        }

        retryButton.setOnClickListener {
            currentStage = 1
            startStage(currentStage)
            hideEndButtons()
        }

        backToMenuButton.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, QuizSelectFragment())
                .commit()
        }

        return view
    }

    private fun startStage(stage: Int) {
        val count = when (stage) {
            1 -> 3
            2 -> 4
            3 -> 5
            4 -> 6
            else -> 3
        }

        val displayTime = when (stage) {
            1 -> 2000L
            2 -> 1800L
            3 -> 1500L
            4 -> 1000L
            else -> 2000L
        }

        inputEditText.text.clear()
        resultTextView.text = ""
        answer = List(count) { Random.nextInt(1, 10) }

        numberTextView.text = "Stage $stage: ${answer.joinToString(" ")}"

        Handler(Looper.getMainLooper()).postDelayed({
            numberTextView.text = "숫자를 기억하고 입력하세요!"
        }, displayTime)
    }

    private fun showEndButtons() {
        retryButton.visibility = View.VISIBLE
        backToMenuButton.visibility = View.VISIBLE
        submitButton.isEnabled = false
    }

    private fun hideEndButtons() {
        retryButton.visibility = View.GONE
        backToMenuButton.visibility = View.GONE
        submitButton.isEnabled = true
    }
}