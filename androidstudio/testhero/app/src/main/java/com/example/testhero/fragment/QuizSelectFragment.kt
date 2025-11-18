package com.example.testhero.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.testhero.R
import com.example.testhero.fragment.MemoryGameFragment
import com.example.testhero.fragment.ReactionGameFragment
import com.example.testhero.fragment.VisualGameFragment

class QuizSelectFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_quiz_select, container, false)

        // 🔹 기억력 테스트
        view.findViewById<Button>(R.id.button_game1).setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, MemoryGameFragment())
                .addToBackStack(null)
                .commit()
        }

        // 🔹 반응력 테스트
        view.findViewById<Button>(R.id.button_game2).setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ReactionGameFragment())
                .addToBackStack(null)
                .commit()
        }

        // 🔹 시각력 테스트
        view.findViewById<Button>(R.id.button_game3).setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, VisualGameFragment())
                .addToBackStack(null)
                .commit()
        }

        // 🔹 집중력 테스트
        view.findViewById<Button>(R.id.button_game4).setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FocusGameFragment())
                .addToBackStack(null)
                .commit()
        }

        return view
    }
}