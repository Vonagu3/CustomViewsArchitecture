package com.example.customviewsarchitecture.content.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface MakeNewsService {

    fun service(): NewsService

    class Base(
        private val url: String = "https://newsapi.org/v2/"
    ) : MakeNewsService {

        override fun service(): NewsService {
            val loggingInterceptor = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
            val okHttpClient = OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()
            return Retrofit.Builder().baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
                .create(NewsService::class.java)
        }
    }
}