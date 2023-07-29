package com.example.customviewsarchitecture.content.data

import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    @GET("everything")
    suspend fun data(
        @Query("q") category: String,
        @Query("apiKey") apiKey: String = "047162d0e2c14fc98c83d3318e95c281"
    ): NewsResponse
}