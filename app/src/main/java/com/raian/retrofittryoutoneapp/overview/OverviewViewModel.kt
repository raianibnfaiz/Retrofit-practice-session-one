package com.raian.retrofittryoutoneapp.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raian.retrofittryoutoneapp.network.MarsApi
import com.raian.retrofittryoutoneapp.network.MarsApiService
import com.raian.retrofittryoutoneapp.network.MarsPhoto
import kotlinx.coroutines.launch

class OverviewViewModel : ViewModel() {
    private val _photos = MutableLiveData<List<MarsPhoto>>()
    val photos: LiveData<List<MarsPhoto>> = _photos
    private val _total = MutableLiveData<String>()
    val total: LiveData<String> = _total
    init {
        getMarsPhotos()
    }
    private fun getMarsPhotos() {
        viewModelScope.launch {
            try {
                val listResult = MarsApi.retrofitService.getPhotos()
                _photos.value = MarsApi.retrofitService.getPhotos()
                _total.value = "Success: ${listResult.size} Mars photos retrieved"
            } catch (e: Exception) {
                _photos.value = listOf()
                _total.value = "Failure: ${e.message} Mars photos retrieved"
            }
        }
    }
}