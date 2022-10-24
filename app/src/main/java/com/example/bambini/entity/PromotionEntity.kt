package com.example.bambinifashion.database

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "promotion_table")
data class PromotionEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val duration: Long,
    val content: String,
    @Embedded val highlight: ContentHighlight?
)

//@Entity(tableName = "content_table")
data class ContentHighlight(
//    @PrimaryKey(autoGenerate = true)
//    val id: Long = 0L,
//    @Ignore val periodicity: Long,
    val backgroundColor: String,
    val textColor: String
)