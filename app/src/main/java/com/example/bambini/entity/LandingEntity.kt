package com.example.bambini.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

data class LandingEntities(val data: List<LandingEntity>)

data class Image(
    val src: String = ""
)

sealed interface LandingEntity

@Entity(tableName = "banner_table")
data class BannerEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    @Embedded val image: Image
) : LandingEntity

@Entity(tableName = "featured_category_table")
data class FeaturedCategoryEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val title: String,
    @Embedded val image: Image
)

data class FeaturedCategories(val featuredCategories: List<FeaturedCategoryEntity>) : LandingEntity

@Entity(tableName = "quadro_table")
data class QuadroEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val title: String,
    @Embedded val image: Image
)

@Entity(tableName = "quadro_item_table")
data class QuadroItemEntity(
    @PrimaryKey(autoGenerate = true)
    val quadroItemId: Long = 0L,
    val title: String,
    val backgroundColor: String,
    @Embedded val image: Image
)

data class QuadroWithCategories(
    @Embedded val quadro: QuadroEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "quadroItemId"
    )
    val quadroItems: List<QuadroItemEntity>
) : LandingEntity