package com.example.bambini.data

import com.google.gson.annotations.SerializedName

data class Proline(@SerializedName("user") var user: UserProline)

data class UserProline(@SerializedName("proline") var proLine: Center)

data class Center(@SerializedName("center") var center: Items)

data class Items(@SerializedName("items") val items: List<ProlineItem>)

data class ProlineItem(
    @SerializedName("duration") var duration: Long,
    @SerializedName("content") var content: String = "",
    @SerializedName("countdown") var countdown: Map<Any, Any> = mapOf(),
    @SerializedName("highlight") var highlight: ContentHighlight?
)

data class ContentHighlight(
    @SerializedName("periodicity") val periodicity: Long,
    @SerializedName("backgroundColor") val backgroundColor: String,
    @SerializedName("textColor") val textColor: String
)