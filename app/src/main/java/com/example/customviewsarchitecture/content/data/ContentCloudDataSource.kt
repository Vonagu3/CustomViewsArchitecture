package com.example.customviewsarchitecture.content.data

import com.example.customviewsarchitecture.category.data.ChosenCategory

interface ContentCloudDataSource {

    suspend fun data(): List<NewsCloud>

    class Base(
        private val service: NewsService,
        private val chosenCategory: ChosenCategory.Read
    ) : ContentCloudDataSource {

        override suspend fun data(): List<NewsCloud> {
            return service.data(chosenCategory.chosenCategory()).data
        }
    }
}