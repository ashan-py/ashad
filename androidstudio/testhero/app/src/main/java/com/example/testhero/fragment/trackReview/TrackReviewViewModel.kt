package com.example.testhero.fragment.trackReview

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.testhero.fragment.trackReview.model.LocationRecord
import kotlinx.coroutines.launch

class TrackReviewViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = LocationRepository(application)

    private val _recentDates = MutableLiveData<List<String>>()
    val recentDates: LiveData<List<String>> get() = _recentDates

    private val _selectedDateLocationData = MutableLiveData<List<LocationRecord>>()
    val selectedDateLocationData: LiveData<List<LocationRecord>> get() = _selectedDateLocationData

    init {
        fetchRecentDates()
    }

    private fun fetchRecentDates() {
        viewModelScope.launch {
            try {
                val dates = repository.getRecentDates()
                Log.d("TrackReviewViewModel", "Recent dates loaded: $dates")
                _recentDates.postValue(dates)
            } catch (e: Exception) {
                Log.e("TrackReviewViewModel", "Error loading recent dates", e)
            }
        }
    }

    fun fetchLocationHistory(date: String) {
        viewModelScope.launch {
            try {
                val data = repository.getLocationsByDate(date)
                Log.d("TrackReviewViewModel", "Loaded ${data.size} records for $date")
                _selectedDateLocationData.postValue(data)
            } catch (e: Exception) {
                Log.e("TrackReviewViewModel", "Error loading location data for $date", e)
            }
        }
    }

    fun saveLocationRecord(record: LocationRecord) {
        viewModelScope.launch {
            try {
                repository.saveLocation(record)
                repository.pruneOldDates() // ✅ 오래된 날짜 자동 삭제
                fetchRecentDates() // 최신 날짜 갱신
                Log.d("TrackReviewViewModel", "Location saved: $record")
            } catch (e: Exception) {
                Log.e("TrackReviewViewModel", "Failed to save location", e)
            }
        }
    }
}