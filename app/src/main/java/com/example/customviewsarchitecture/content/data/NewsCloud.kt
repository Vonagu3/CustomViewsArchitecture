package com.example.customviewsarchitecture.content.data

import com.example.customviewsarchitecture.content.domain.NewsDomain
import com.google.gson.annotations.SerializedName

data class NewsCloud(
    @SerializedName("author")
    private val author: String?,
    @SerializedName("title")
    private val title: String,
    @SerializedName("description")
    private val description: String,
    @SerializedName("content")
    private val content: String,
    @SerializedName("urlToImage")
    private val imageUrl: String?,
    @SerializedName("publishedAt")
    private val date: String
) {
    fun map(): NewsDomain {
        val isValid = !imageUrl.isNullOrEmpty() && imageUrl.startsWith("http")
        return if (isValid) {
            NewsDomain.Base(date, imageUrl!!, title)
        } else {
            NewsDomain.Invalid
        }
    }
}

//data class NewsCloud(
//    @SerializedName("author")
//    private val author: String,
//    @SerializedName("content")
//    private val content: String,
//    @SerializedName("date")
//    private val date: String,
//    @SerializedName("imageUrl")
//    private val imageUrl: String,
//    @SerializedName("readMoreUrl")
//    private val readMoreUrl: String,
//    @SerializedName("time")
//    private val time: String,
//    @SerializedName("title")
//    private val title: String,
//    @SerializedName("url")
//    private val url: String,
//) {
//    fun map() : NewsDomain {
//        val isValid = imageUrl.isNotEmpty() && imageUrl.startsWith("http")
//        return if (isValid) {
//            NewsDomain.Base(date, imageUrl, title)
//        } else {
//            NewsDomain.Invalid
//        }
//    }
//}
