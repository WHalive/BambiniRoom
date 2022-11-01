package com.example.bambinifashion.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bambini.repository.PromotionRepository
import com.example.bambinifashion.database.BambiniDatabase
import com.example.bambinifashion.database.PromotionEntity
import kotlinx.coroutines.launch

class PromotionViewModel : ViewModel() {

    private val repository: PromotionRepository
    private val _promotionEntity = MutableLiveData<List<PromotionEntity>>()
    var promotionEntity: LiveData<List<PromotionEntity>> = _promotionEntity

    init {
        val bambiniDataBase = BambiniDatabase.getInstance().promotionDao()
        repository = PromotionRepository(bambiniDataBase)
        promotionEntity = repository.getAllPromotions()

        getAllPromotionItems()
    }

    private fun getAllPromotionItems() {
        viewModelScope.launch {
            try {
                repository.insertItems()
                Log.d("HomeViewModel", "getAllItems: ${_promotionEntity.value}")
            } catch (e: Exception) {
                Log.e("BambiniViewModel", e.message.orEmpty())
            }
        }
    }
}