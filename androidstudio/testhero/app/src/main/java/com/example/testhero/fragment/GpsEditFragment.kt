package com.example.testhero.fragment

import android.location.Geocoder
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.testhero.R
import java.util.*

class GpsEditFragment : Fragment() {

    private lateinit var editAddress: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_gps_edit, container, false)

        editAddress = view.findViewById(R.id.edit_address)

        view.findViewById<Button>(R.id.button_save).setOnClickListener {
            val address = editAddress.text.toString()
            if (address.isNotEmpty()) {
                saveAddress(address)
            } else {
                Toast.makeText(requireContext(), "주소를 입력하세요.", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }

    private fun saveAddress(address: String) {
        val geocoder = Geocoder(requireContext(), Locale.getDefault())

        try {
            val addresses = geocoder.getFromLocationName(address, 1)
            if (!addresses.isNullOrEmpty()) {
                val location = addresses[0]
                val latitude = location.latitude
                val longitude = location.longitude

                val sharedPref = requireActivity().getSharedPreferences("GpsInfo", 0)
                with(sharedPref.edit()) {
                    putString("home_address", address)
                    putString("latitude", latitude.toString())
                    putString("longitude", longitude.toString())
                    apply()
                }

                Toast.makeText(requireContext(), "주소가 저장되었습니다.", Toast.LENGTH_SHORT).show()

                // 이전 Fragment(GpsFragment)로 이동
                parentFragmentManager.popBackStack()
            } else {
                Toast.makeText(requireContext(), "유효한 주소가 아닙니다.", Toast.LENGTH_SHORT).show()
            }
        } catch (e: Exception) {
            Toast.makeText(requireContext(), "주소 변환 실패. 인터넷을 확인하세요.", Toast.LENGTH_SHORT).show()
        }
    }
}
