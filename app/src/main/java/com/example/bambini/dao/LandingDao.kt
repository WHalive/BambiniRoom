package com.example.bambini.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.bambini.entity.*

@Dao
interface LandingDao {

    suspend fun getLandingData(): List<LandingEntity> {
        return getBanner() + getQuadroItems() + FeaturedCategories(getFeaturedCategories())
    }

    suspend fun loadLandingData(data: LandingEntities) {
        data.data.forEach { landingItem ->
            when (landingItem) {
                is BannerEntity -> insertBanner(landingItem)
                is QuadroWithCategories -> {
                    insertQuadro(landingItem.quadro)
                }
                is FeaturedCategories -> landingItem.featuredCategories.forEach {
                    insertFeaturedCategory(
                        it
                    )
                }
            }
        }
    }

    @Insert(onConflict = REPLACE)
    suspend fun insertBanner(banner: BannerEntity)

    @Insert(onConflict = REPLACE)
    suspend fun insertQuadro(quadro: QuadroEntity): Long

    @Insert(onConflict = REPLACE)
    suspend fun insertQuadroCategories(quadroCategories: List<QuadroEntity>)

    @Insert(onConflict = REPLACE)
    suspend fun insertFeaturedCategory(featuredCategory: FeaturedCategoryEntity)

    @Query("SELECT * FROM banner_table")
    suspend fun getBanner(): List<BannerEntity>

    @Query("SELECT * FROM featured_category_table")
    suspend fun getFeaturedCategories(): List<FeaturedCategoryEntity>

    @Query("SELECT * FROM quadro_table")
    suspend fun getQuadroItems(): List<QuadroWithCategories>


}

