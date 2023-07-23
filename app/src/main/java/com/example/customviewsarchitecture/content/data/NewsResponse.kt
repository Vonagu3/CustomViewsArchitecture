package com.example.customviewsarchitecture.content.data

import com.google.gson.annotations.SerializedName

//data class NewsResponse(
//    @SerializedName("category")
//    val category: String,
//    @SerializedName("data")
//    val data: List<NewsCloud>
//)
data class NewsResponse(
    @SerializedName("status")
    val status: String,
    @SerializedName("articles")
    val data: List<NewsCloud>
)
