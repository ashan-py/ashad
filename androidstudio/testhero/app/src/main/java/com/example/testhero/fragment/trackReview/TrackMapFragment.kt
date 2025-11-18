package com.example.testhero.fragment.trackReview

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.testhero.R
import com.example.testhero.databinding.FragmentTrackMapBinding
import com.example.testhero.fragment.trackReview.model.LocationRecord
import com.example.testhero.fragment.trackReview.model.StopInfo
import com.example.testhero.fragment.trackReview.LocationRepository
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.CameraUpdate
import com.naver.maps.map.MapFragment
import com.naver.maps.map.NaverMap
import com.naver.maps.map.LocationTrackingMode
import com.naver.maps.map.overlay.Marker
import com.naver.maps.map.overlay.PolylineOverlay
import com.naver.maps.map.util.FusedLocationSource
import kotlinx.coroutines.launch

class TrackMapFragment : Fragment() {

    private var _binding: FragmentTrackMapBinding? = null
    private val binding get() = _binding!!

    private lateinit var naverMap: NaverMap
    private lateinit var locationSource: FusedLocationSource

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTrackMapBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        locationSource = FusedLocationSource(this, LOCATION_PERMISSION_REQUEST_CODE)

        val mapFragment = childFragmentManager.findFragmentById(R.id.mapView) as? MapFragment
            ?: MapFragment.newInstance().also {
                childFragmentManager.beginTransaction()
                    .replace(R.id.mapView, it)
                    .commitNow()
            }

        mapFragment.getMapAsync { map ->
            naverMap = map

            // ✅ 위치 설정
            naverMap.locationSource = locationSource
            naverMap.locationTrackingMode = LocationTrackingMode.Follow
            naverMap.uiSettings.isLocationButtonEnabled = true // ← 내 위치 버튼 표시

            val selectedDate = arguments?.getString("selectedDate") ?: return@getMapAsync

            lifecycleScope.launch {
                val repo = LocationRepository(requireContext())
                val records = repo.getLocationsByDate(selectedDate)
                val stops = repo.getStops(selectedDate)

                showRouteOnMap(records, stops)
            }
        }
    }

    private fun showRouteOnMap(records: List<LocationRecord>, stops: List<StopInfo>) {
        if (records.isEmpty()) return

        val coords = records.map { LatLng(it.latitude, it.longitude) }

        PolylineOverlay().apply {
            this.coords = coords
            this.color = Color.BLUE
            this.width = 8
            this.map = naverMap
        }

        stops.forEach {
            Marker().apply {
                position = LatLng(it.latitude, it.longitude)
                captionText = "${it.fromTime} ~ ${it.toTime}"
                iconTintColor = Color.RED
                map = naverMap
            }
        }

        naverMap.moveCamera(CameraUpdate.scrollTo(coords.first()))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1000
    }
}