package com.example.customviewsarchitecture.content.domain

interface ContentRepository {

    suspend fun data(): List<NewsDomain>
}