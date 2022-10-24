package com.example.bambini.internet

import android.util.Log
import com.example.bambini.data.ContentType
import com.example.bambini.data.Landing
import com.example.bambinifashion.database.PromotionEntity
import com.example.bambini.entity.LandingEntities
import com.example.bambini.entity.LandingEntity
import com.example.bambini.internet.interceptor.ApiKeyInterceptor
import com.example.bambini.internet.interceptor.LocalizationInterceptor
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit

private const val BASE_URL = "https://babydriver-android.bambinimirror.com/m/"

val valueTypeAdapter = RuntimeTypeAdapterFactory.of(ContentType::class.java, "name")
    .registerSubtype(ContentType.QuadroType::class.java, "quadro")
    .registerSubtype(ContentType.BannerType::class.java, "banner")
    .registerSubtype(ContentType.FeaturedCategoriesType::class.java, "featured-categories")
val gson = GsonBuilder()
    .registerTypeAdapterFactory(valueTypeAdapter)
    .create()

val client = with(OkHttpClient.Builder()) {
    readTimeout(15, TimeUnit.SECONDS)
    connectTimeout(15, TimeUnit.SECONDS)
    addInterceptor(ApiKeyInterceptor())
    addInterceptor(LocalizationInterceptor())
    val loggingInterceptor = HttpLoggingInterceptor { Log.d("Networking", it) }
    loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    addInterceptor(loggingInterceptor)
    build()
}


val retrofit: Retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create(gson))
    .baseUrl(BASE_URL)
    .client(client)
    .build()

interface FashionApiService {

    @GET("v1/page:type=landing")
    suspend fun getHomeScreen(): LandingEntities
//
//    @GET("v1/user:proline")
//    suspend fun getPromotion(): Proline

    @GET("v1/user:proline")
    suspend fun getPromotion(): PromotionEntity
}

object FashionApi {
    val retrofitService: FashionApiService by lazy {
        retrofit.create(FashionApiService::class.java)
    }
}