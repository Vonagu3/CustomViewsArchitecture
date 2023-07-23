package com.example.customviewsarchitecture.content.domain

import java.lang.Exception

interface ContentInteractor {

    suspend fun data(): ContentResult

    class Base(
        private val repository: ContentRepository,
        private val handleError: HandleError<DomainException, String>,
        private val mapper: NewsUiMapper
    ) : ContentInteractor {

        override suspend fun data(): ContentResult =
            try {
                val list = repository.data()
                ContentResult.Success(list.filter { it.isValid() }.map { it.map(mapper) })
            } catch (e: DomainException) {
                ContentResult.Error(handleError.handle(e))
            }
    }
}