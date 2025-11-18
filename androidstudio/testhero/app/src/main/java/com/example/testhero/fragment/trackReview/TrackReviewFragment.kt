package com.example.testhero.fragment.trackReview

import android.os.Bundle
import android.util.Log
import com.example.testhero.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testhero.databinding.FragmentTrackReviewBinding

class TrackReviewFragment : Fragment() {

    private var _binding: FragmentTrackReviewBinding? = null
    private val binding get() = _binding!!

    private val viewModel: TrackReviewViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTrackReviewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = DayButtonAdapter { selectedDate ->
            viewModel.fetchLocationHistory(selectedDate)

            viewModel.selectedDateLocationData.observe(viewLifecycleOwner) { data ->
                if (data.isNotEmpty()) {
                    Log.d("TrackReviewFragment", "📍 $selectedDate 위치 ${data.size}개 있음 → 지도 진입")

                    val fragment = TrackMapFragment().apply {
                        arguments = Bundle().apply {
                            putString("selectedDate", selectedDate)
                        }
                    }

                    parentFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, fragment)
                        .addToBackStack(null)
                        .commit()
                } else {
                    Log.w("TrackReviewFragment", "❗ $selectedDate 위치 데이터 없음 → 지도 이동 취소")
                }
            }
        }

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            this.adapter = adapter
        }

        viewModel.recentDates.observe(viewLifecycleOwner) { dates ->
            Log.d("TrackReviewFragment", "📅 날짜 목록 수신: $dates")
            adapter.submitList(dates)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}