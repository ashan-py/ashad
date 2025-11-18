package com.example.testhero.fragment

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.testhero.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class GpsFragment : Fragment(), OnMapReadyCallback {

    private lateinit var googleMap: GoogleMap
    private lateinit var textAddress: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_gps, container, false)

        textAddress = view.findViewById(R.id.text_address)

        // 편집 버튼 클릭 → GpsEditFragment로 이동
        view.findViewById<Button>(R.id.button_edit).setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, GpsEditFragment())
                .addToBackStack(null)
                .commit()
        }

        // SupportMapFragment 사용
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        return view
    }

    override fun onMapReady(map: GoogleMap) {
        googleMap = map
        enableMyLocation()
        loadHomeLocation()
    }

    private fun enableMyLocation() {
        val context = requireContext()
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION)
            == PackageManager.PERMISSION_GRANTED) {
            googleMap.isMyLocationEnabled = true
        } else {
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                1001
            )
        }
    }

    private fun loadHomeLocation() {
        val sharedPref = requireActivity().getSharedPreferences("GpsInfo", 0)
        val latitude = sharedPref.getString("latitude", "37.5665")?.toDouble() ?: 37.5665
        val longitude = sharedPref.getString("longitude", "126.9780")?.toDouble() ?: 126.9780
        val address = sharedPref.getString("home_address", "저장된 주소가 없습니다.")

        textAddress.text = address
        val location = LatLng(latitude, longitude)

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 16f))
        googleMap.addMarker(MarkerOptions().position(location).title("저장된 위치"))
    }
}
