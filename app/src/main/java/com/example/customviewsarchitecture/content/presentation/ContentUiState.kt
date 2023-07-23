package com.example.customviewsarchitecture.content.presentation

import android.widget.RadioButton

interface ContentUiState {

    fun showChoice(wifiOnlyRadioButton: RadioButton, alsoMobileRadioButton: RadioButton) = Unit

    fun showNews(showNews: ShowNews) = Unit

    class Initial(private val wifiOnlyChosen: Boolean): ContentUiState {
        override fun showChoice(
            wifiOnlyRadioButton: RadioButton,
            alsoMobileRadioButton: RadioButton
        ) {
            wifiOnlyRadioButton.isChecked = wifiOnlyChosen
            alsoMobileRadioButton.isChecked = !wifiOnlyChosen
        }
    }

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