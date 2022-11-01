package com.example.bambini.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.bambinifashion.database.PromotionEntity

@Dao
interface PromotionDao {
    @Query("SELECT * FROM promotion_table")
    fun getAllPromotions(): LiveData<List<PromotionEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItems(items: List<PromotionEntity>)
}
