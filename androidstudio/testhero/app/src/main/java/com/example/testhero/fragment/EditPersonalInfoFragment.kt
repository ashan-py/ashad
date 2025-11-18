package com.example.testhero.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.testhero.databinding.FragmentEditPersonalInfoBinding

class EditPersonalInfoFragment : Fragment() {

    private var _binding: FragmentEditPersonalInfoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEditPersonalInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // ✅ 기존 저장된 개인정보 불러오기
        val prefs = requireContext().getSharedPreferences("user_info", 0)
        binding.editName.setText(prefs.getString("name", ""))
        binding.editPhone.setText(prefs.getString("phone", ""))
        binding.editGuardianName.setText(prefs.getString("guardianName", ""))
        binding.editGuardianPhone.setText(prefs.getString("guardianPhone", ""))
        binding.editNote.setText(prefs.getString("note", ""))

        // ✅ 저장 버튼 클릭
        binding.buttonSave.setOnClickListener {
            with(prefs.edit()) {
                putString("name", binding.editName.text.toString())
                putString("phone", binding.editPhone.text.toString())
                putString("guardianName", binding.editGuardianName.text.toString())
                putString("guardianPhone", binding.editGuardianPhone.text.toString())
                putString("note", binding.editNote.text.toString())
                apply()
            }

            val result = Bundle().apply {
                putString("name", binding.editName.text.toString())
                putString("phone", binding.editPhone.text.toString())
                putString("guardianName", binding.editGuardianName.text.toString())
                putString("guardianPhone", binding.editGuardianPhone.text.toString())
                putString("note", binding.editNote.text.toString())
            }
            parentFragmentManager.setFragmentResult("editResult", result)

            parentFragmentManager.popBackStack()
        }

        // ✅ 돌아가기 버튼 클릭 → 저장 없이 뒤로
        binding.buttonBack.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
