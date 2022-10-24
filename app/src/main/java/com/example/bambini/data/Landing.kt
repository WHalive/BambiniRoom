package com.example.bambini.data

import com.google.gson.annotations.SerializedName

data class Landing(@SerializedName("page") val page: Content)

data class Content(@SerializedName("content") val content: List<ContentType>)

data class Image(@SerializedName("src") val src: String = "")
interface ContentType {
    val name: String

    data class BannerType(
        @SerializedName("name") override val name: String = "",
        @SerializedName("data") val data: BannerData = BannerData(),
    ) : ContentType {
        data class BannerData(
//            @SerializedName("size") var size: String = "",
//            @SerializedName("linkUrl") var linkUrl: String = "",
            @SerializedName("image") var image: Image = Image(),
//            @SerializedName("caption") val caption: Caption = Caption()
        ) {
            data class Caption(
                @SerializedName("heading") val heading: Heading = Heading()
            )

            data class Heading(
                @SerializedName("text") val text: String = ""
            )
        }
    }

    data class FeaturedCategoriesType(
        @SerializedName("name") override val name: String,
        @SerializedName("data") val data: FeaturedCategoriesData
    ) : ContentType {
        data class FeaturedCategoriesData(
            @SerializedName("categories") val categories: List<FeaturedCategoryItem>
        )

        data class FeaturedCategoryItem(
            @SerializedName("title") val title: String,
//            @SerializedName("linkUrl") val linkUrl: String,
            @SerializedName("image") val image: Image = Image(),
        )
    }

    data class QuadroType(
        @SerializedName("name") override val name: String,
        @SerializedName("data") val data: QuadroData,
    ) : ContentType {
        data class QuadroData(
            @SerializedName("title") val title: String,
//            @SerializedName("linkUrl") val linkUrl: String,
            @SerializedName("image") val image: Image = Image(""),
            @SerializedName("categories") val categories: List<QuadroCategoryItem>
        )

        data class QuadroCategoryItem(
            @SerializedName("title") val title: String,
//            @SerializedName("linkUrl") val linkUrl: String,
            @SerializedName("backgroundColor") val backgroundColor: String,
            @SerializedName("image") val image: Image = Image(""),
        )
    }

}