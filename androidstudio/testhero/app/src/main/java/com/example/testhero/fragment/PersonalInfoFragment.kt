package com.example.testhero.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.testhero.R
import com.example.testhero.databinding.FragmentPersonalInfoBinding

class PersonalInfoFragment : Fragment() {

    private var _binding: FragmentPersonalInfoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPersonalInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 저장된 값 불러오기
        loadSavedInfo()

        // 편집 버튼 → 편집화면으로 이동
        binding.buttonEdit.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, EditPersonalInfoFragment())
                .addToBackStack(null)
                .commit()
        }

        // 저장된 결과 실시간 반영
        parentFragmentManager.setFragmentResultListener("editResult", viewLifecycleOwner) { _, _ ->
            loadSavedInfo()
        }

        // 돌아가기
        binding.buttonBack.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }

    private fun loadSavedInfo() {
        val prefs = requireContext().getSharedPreferences("user_info", 0)
        binding.textName.text = "이름: ${prefs.getString("name", "없음")}"
        binding.textPhone.text = "전화번호: ${prefs.getString("phone", "없음")}"
        binding.textGuardianName.text = "보호자 이름: ${prefs.getString("guardianName", "없음")}"
        binding.textGuardianPhone.text = "보호자 전화번호: ${prefs.getString("guardianPhone", "없음")}"
        binding.textRemarks.text = "비고: ${prefs.getString("note", "없음")}"
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


