package com.example.bambini.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bambinifashion.database.BambiniDatabase
import com.example.bambini.entity.LandingEntity
import com.example.bambini.repository.LandingRepository
import kotlinx.coroutines.launch

class LandingViewModel : ViewModel() {
    private var _landing = MutableLiveData<List<LandingEntity>>()
    val landing: LiveData<List<LandingEntity>> = _landing
    private val bambiniDatabase = BambiniDatabase.getInstance().landingDao()
    val repository = LandingRepository(bambiniDatabase)

    init {
        viewModelScope.launch {
            _landing.value = repository.getAllLandingItems()
            getLandingItems()
        }
    }

    private fun getLandingItems() {
        viewModelScope.launch {
            try {
                repository.loadLandings()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}