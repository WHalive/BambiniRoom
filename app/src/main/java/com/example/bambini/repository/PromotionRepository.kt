package com.example.bambini.repository

import androidx.lifecycle.LiveData
import com.example.bambini.dao.PromotionDao
import com.example.bambinifashion.database.PromotionEntity

class PromotionRepository(private val promotionDao: PromotionDao) {
    suspend fun insertItems(promotionEntities: List<PromotionEntity>) =
        promotionDao.insertItems(promotionEntities)

    fun getAllPromotions(): LiveData<List<PromotionEntity>> =
        promotionDao.getAllPromotions()
}