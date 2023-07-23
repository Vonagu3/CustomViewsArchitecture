package com.example.customviewsarchitecture.content.data

interface ContentCloudDataSource {

    suspend fun data(): List<NewsCloud>

    class Base(
        private val service: NewsService
    ) : ContentCloudDataSource {

        override suspend fun data(): List<NewsCloud> {
            return service.data().data
        }
    }
}