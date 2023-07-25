package com.example.customviewsarchitecture.content.presentation

import android.widget.RadioButton

interface ContentUiState {

    fun showNews(showNews: ShowNews) = Unit

    class Success(private val news: List<NewsUi>): ContentUiState {
        override fun showNews(showNews: ShowNews) {
            showNews.show(news)
        }
    }

    class Error(private val message: String): ContentUiState {
        override fun showNews(showNews: ShowNews) {
            showNews.show(listOf(NewsUi.Error(message)))
        }
    }
}