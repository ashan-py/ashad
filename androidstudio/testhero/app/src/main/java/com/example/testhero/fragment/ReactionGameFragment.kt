package com.example.testhero.fragment

import android.os.*
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.testhero.R
import kotlin.random.Random

class ReactionGameFragment : Fragment() {

    private lateinit var instructionText: TextView
    private lateinit var reactionLayout: FrameLayout
    private lateinit var resultText: TextView
    private lateinit var retryButton: Button
    private lateinit var backToMenuButton: Button

    private var canTap = false
    private var startTime = 0L
    private val delayHandler = Handler(Looper.getMainLooper())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_reaction_game, container, false)

        instructionText = view.findViewById(R.id.text_instruction)
        reactionLayout = view.findViewById(R.id.reaction_layout)
        resultText = view.findViewById(R.id.text_result)
        retryButton = view.findViewById(R.id.button_retry)
        backToMenuButton = view.findViewById(R.id.button_back_to_menu)

        startGame()

        reactionLayout.setOnClickListener {
            if (!canTap) {
                delayHandler.removeCallbacksAndMessages(null)
                instructionText.text = "❌ 너무 빨리 눌렀어요!"
                showEndButtons()
            } else {
                val reactionTime = System.currentTimeMillis() - startTime
                val comment = when {
                    reactionTime <= 300 -> "🥇 상위 5% 수준입니다. 반사 신경이 번개 같아요! ⚡"
                    reactionTime <= 500 -> "🥈 상위 20% 수준입니다. 훌륭한 집중력이에요! 👏"
                    reactionTime <= 700 -> "🥉 상위 50% 수준입니다. 안정적인 반응 속도입니다 👍"
                    else -> "⏳ 하위 50%... 더 집중해서 다시 도전해봐요! 💪"
                }

                instructionText.text = "반응 속도: ${reactionTime}ms\n$comment"
                showEndButtons()
            }
            canTap = false
        }

        retryButton.setOnClickListener {
            hideEndButtons()
            startGame()
        }

        backToMenuButton.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, QuizSelectFragment())
                .commit()
        }

        return view
    }

    private fun startGame() {
        instructionText.text = "준비하세요..."
        resultText.text = ""
        canTap = false

        val randomDelay = Random.nextLong(2000, 5000) // 2~5초 사이
        delayHandler.postDelayed({
            instructionText.text = "💥 지금 터치하세요!"
            startTime = System.currentTimeMillis()
            canTap = true
        }, randomDelay)
    }

    private fun showEndButtons() {
        retryButton.visibility = View.VISIBLE
        backToMenuButton.visibility = View.VISIBLE
    }

    private fun hideEndButtons() {
        retryButton.visibility = View.GONE
        backToMenuButton.visibility = View.GONE
    }
}