package com.example.testhero

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class QuizResultFragment : Fragment() {

    companion object {
        private const val ARG_YES_COUNT = "yes_count"

        fun newInstance(yesCount: Int): QuizResultFragment {
            val fragment = QuizResultFragment()
            val args = Bundle()
            args.putInt(ARG_YES_COUNT, yesCount)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_quiz_result, container, false)
        val resultTextView = view.findViewById<TextView>(R.id.result_text)

        val yesCount = arguments?.getInt(ARG_YES_COUNT) ?: 0
        val resultText = when {
            yesCount <= 5 -> "운동과 사회생활을 잘 유지하시고 치매 예방 수칙을 지켜 치매를 예방하세요."
            else -> "조금 더 면밀한 검사가 필요합니다. 가까운 보건소나 치매지원센터를 방문하셔서 더 정확한 치매 검진을 받아보세요."

        }

        resultTextView.text = "예 응답 수: $yesCount\n\n$resultText"

        return view
    }
}
