package com.example.bambinifashion.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.bambini.dao.LandingDao
import com.example.bambini.dao.PromotionDao
import com.example.bambini.entity.BannerEntity
import com.example.bambini.entity.FeaturedCategoryEntity
import com.example.bambini.entity.QuadroEntity
import com.example.bambini.entity.QuadroItemEntity

@Database(
    entities = [
        PromotionEntity::class,
        BannerEntity::class,
        FeaturedCategoryEntity::class,
        QuadroEntity::class,
        QuadroItemEntity::class
    ],
    version = 1
)

abstract class BambiniDatabase : RoomDatabase() {
    abstract fun promotionDao(): PromotionDao
    abstract fun landingDao(): LandingDao

    companion object {
        private var INSTANCE: BambiniDatabase? = null

        fun createInstance(context: Context) {
            if (INSTANCE != null) return

            synchronized(this) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    BambiniDatabase::class.java,
                    "bambini_database"
                ).build()
            }
        }

        fun getInstance(): BambiniDatabase {
            return INSTANCE!!
        }
    }
}