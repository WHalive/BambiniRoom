package com.example.bambini.repository

import androidx.lifecycle.LiveData
import com.example.bambini.dao.PromotionDao
import com.example.bambini.internet.FashionApi
import com.example.bambinifashion.database.PromotionEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PromotionRepository(private val promotionDao: PromotionDao) {
//    suspend fun insertItems(promotionEntities: List<PromotionEntity>) =
//        promotionDao.insertItems(promotionEntities)

    fun getAllPromotions(): LiveData<List<PromotionEntity>> =
        promotionDao.getAllPromotions()

    suspend fun insertItems(){
        withContext(Dispatchers.IO){
            launch {
                try {
                    val promotionEntities = FashionApi.retrofitService.getPromotion()
                    promotionDao.insertItems(promotionEntities)
                }catch (e:Exception){
                    e.printStackTrace()
                }
            }
        }
    }
}