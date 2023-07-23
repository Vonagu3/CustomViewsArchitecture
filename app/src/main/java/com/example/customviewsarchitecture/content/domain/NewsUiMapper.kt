package com.example.customviewsarchitecture.content.domain

import com.example.customviewsarchitecture.content.data.LoadingModeCache
import com.example.customviewsarchitecture.content.presentation.NewsUi

interface NewsUiMapper {

    fun map(title: String, imageUrl: String): NewsUi

    class Base(
        private val loadingModeCache: LoadingModeCache.Read
    ) : NewsUiMapper {

        override fun map(title: String, imageUrl: String): NewsUi {
            return NewsUi.Base(title, imageUrl, !loadingModeCache.isWifiOnly())
        }
    }
}