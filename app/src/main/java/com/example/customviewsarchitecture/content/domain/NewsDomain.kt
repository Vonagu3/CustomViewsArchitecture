package com.example.customviewsarchitecture.content.domain

import com.example.customviewsarchitecture.content.presentation.NewsUi

interface NewsDomain {

    fun isValid(): Boolean

    fun map(mapper: NewsUiMapper): NewsUi

    class Base(
        private val date: String,
        private val imageUrl: String,
        private val title: String
    ): NewsDomain {

        override fun isValid(): Boolean = true

        override fun map(mapper: NewsUiMapper) = mapper.map("$title $date", imageUrl)

    }

    object Invalid: NewsDomain {
        override fun isValid() = false

        override fun map(mapper: NewsUiMapper) = throw IllegalStateException("can't map invalid")
    }
}