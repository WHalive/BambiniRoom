package com.example.bambinifashion.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONObject
import java.util.Collections

class ItemsTypeConverter{
    private val gson = Gson()
    @TypeConverter
    fun stringToList(data: String?): List<PromotionEntity> {
        if (data == null) {
            return Collections.emptyList()
        }

        val listType = object :TypeToken<List<PromotionEntity>>(){
        }.type

        return gson.fromJson<List<PromotionEntity>>(data, listType)
    }

    @TypeConverter
    fun listToString(someObjects: List<PromotionEntity>): String {
        return gson.toJson(someObjects)
    }
}