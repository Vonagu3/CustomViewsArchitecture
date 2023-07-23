package com.example.customviewsarchitecture.content.domain

import com.example.customviewsarchitecture.content.presentation.ContentCommunication
import com.example.customviewsarchitecture.content.presentation.ContentUiState
import com.example.customviewsarchitecture.content.presentation.NewsUi

interface ContentResult {

    fun map(communication: ContentCommunication)

    class Success(private val news: List<NewsUi>): ContentResult {
        override fun map(communication: ContentCommunication) {
            communication.map(ContentUiState.Success(news))
        }
    }

    class Error(private val message: String): ContentResult {
        override fun map(communication: ContentCommunication) {
            communication.map(ContentUiState.Error(message))
        }
    }
}