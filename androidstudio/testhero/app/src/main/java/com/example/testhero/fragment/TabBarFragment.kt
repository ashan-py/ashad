package com.example.testhero.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.testhero.databinding.FragmentTabBarBinding
import com.example.testhero.R

import com.example.testhero.fragment.MedicationFragment


class TabBarFragment : Fragment() {

    private var _binding: FragmentTabBarBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTabBarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnEmergency.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, EmergencyFragment())
                .addToBackStack(null)
                .commit()
        }

        binding.btnPersonal.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, PersonalInfoFragment())
                .addToBackStack(null)
                .commit()
        }

        binding.btnGps.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, GpsFragment())
                .addToBackStack(null)
                .commit()
        }


        binding.btnMedicine.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, MedicationFragment())
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
