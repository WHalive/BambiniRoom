package com.example.bambini.repository

import android.util.Log
import com.example.bambini.dao.LandingDao
import com.example.bambini.internet.FashionApi
import com.example.bambini.entity.LandingEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LandingRepository(private val landingDao: LandingDao) {

    suspend fun getAllLandingItems(): List<LandingEntity> {
        return landingDao.getLandingData()
    }

    suspend fun loadLandings() {
        withContext(Dispatchers.IO) {
            launch {
                try {
                    val landingEntities = FashionApi.retrofitService.getHomeScreen()
                    landingDao.loadLandingData(landingEntities)
                    Log.d("loading data", "loadLandings: ${FashionApi.retrofitService.getHomeScreen()}")
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }
}