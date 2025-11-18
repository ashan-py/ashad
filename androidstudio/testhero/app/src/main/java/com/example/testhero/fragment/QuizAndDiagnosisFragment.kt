package com.example.testhero

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.testhero.fragment.QuizSelectFragment

class QuizAndDiagnosisFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_self_diagnosis_menu, container, false)

        val selfTestButton: Button = view.findViewById(R.id.button_self_test)
        val preventionQuizButton: Button = view.findViewById(R.id.button_prevention_quiz)

        selfTestButton.setOnClickListener {
            // 자가진단 퀴즈 Fragment로 이동
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, QuizFragment())
                .addToBackStack(null)
                .commit()
        }

        preventionQuizButton.setOnClickListener {
            // 예방 퀴즈 선택 Fragment로 이동
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, QuizSelectFragment())
                .addToBackStack(null)
                .commit()
        }

        return view
    }
}
