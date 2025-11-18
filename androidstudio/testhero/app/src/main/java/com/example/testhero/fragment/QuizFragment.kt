package com.example.testhero

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment

class QuizFragment : Fragment() {

    private val questions = listOf(
        "자신의 기억력에 문제가 있다고 느낀 적이 있다.",
        "10년 전과 비교해 기억력이 나빠졌다고 생각한다.",
        "같은 또래 사람들과 비교했을 때 기억력이 더 나쁘다고 느낀다.",
        "기억력 문제로 인해 일상생활에 불편을 겪고 있다.",
        "최근에 있었던 일을 기억하기 어렵다고 느낄 때가 있다.",
        "며칠 전에 나눈 대화 내용을 기억하기 어려운 경우가 있다.",
        "며칠 전에 했던 약속이 잘 기억나지 않을 때가 있다.",
        "가까운 사람의 이름이 쉽게 떠오르지 않는 경우가 있다.",
        "물건을 둔 위치를 자주 기억하지 못해 헤맸던 적이 있다.",
        "이전에 비해 물건을 자주 잃어버리는 편이다.",
        "집 근처에서도 길을 잃거나 헤맨 적이 있다.",
        "가게에서 몇 가지 물건을 사려고 할 때 물건 이름이 잘 기억나지 않는다.",
        "가스불이나 전기불을 껐는지 기억하지 못하는 경우가 있다.",
        "자주 사용하는 전화번호(본인 또는 자녀 등)가 떠오르지 않는 경우가 있다."
    )

    private var currentIndex = 0
    private val answers = MutableList<Boolean?>(questions.size) { null }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_quiz, container, false)

        val questionNumber = view.findViewById<TextView>(R.id.question_number)
        val questionText = view.findViewById<TextView>(R.id.question_text)
        val radioGroup = view.findViewById<RadioGroup>(R.id.answer_group)
        val nextButton = view.findViewById<Button>(R.id.button_next)
        val backButton = view.findViewById<Button>(R.id.button_back)

        fun updateQuestion() {
            questionNumber.text = "${currentIndex + 1}/${questions.size}"
            questionText.text = questions[currentIndex]
            radioGroup.clearCheck()

            // 이전 답이 있으면 복원
            when (answers[currentIndex]) {
                true -> radioGroup.check(R.id.radio_yes)
                false -> radioGroup.check(R.id.radio_no)
                null -> {} // 아무것도 안 함
            }

            // 버튼 텍스트 및 가시성
            nextButton.text = if (currentIndex == questions.lastIndex) "결과 확인" else "다음"
            backButton.visibility = if (currentIndex == 0) View.INVISIBLE else View.VISIBLE
        }

        updateQuestion()

        nextButton.setOnClickListener {
            val selected = when (radioGroup.checkedRadioButtonId) {
                R.id.radio_yes -> true
                R.id.radio_no -> false
                else -> null
            }

            if (selected == null) {
                Toast.makeText(context, "응답을 선택해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            answers[currentIndex] = selected

            if (currentIndex == questions.lastIndex) {
                val yesCount = answers.count { it == true }
                val resultFragment = QuizResultFragment.newInstance(yesCount)
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, resultFragment)
                    .commit()
            } else {
                currentIndex++
                updateQuestion()
            }
        }

        backButton.setOnClickListener {
            if (currentIndex > 0) {
                currentIndex--
                updateQuestion()
            }
        }

        return view
    }
}