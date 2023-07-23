package com.example.customviewsarchitecture.content.data

import com.example.customviewsarchitecture.content.domain.ContentRepository
import com.example.customviewsarchitecture.content.domain.DomainException
import com.example.customviewsarchitecture.content.domain.HandleError
import com.example.customviewsarchitecture.content.domain.NewsDomain

class BaseContentRepository(
    private val cloudDataSource: ContentCloudDataSource,
    private val handleError: HandleError<Exception, DomainException>
) : ContentRepository {

    override suspend fun data(): List<NewsDomain> {
        try {
            return cloudDataSource.data().map { it.map() }
        } catch (e: Exception) {
            throw handleError.handle(e)
        }
    }
}