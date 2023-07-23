package com.example.customviewsarchitecture.content.domain

import com.example.customviewsarchitecture.core.ManageResource
import java.net.UnknownHostException

interface HandleError<E : Exception, T : Any> {

    fun handle(error: E): T

    class Domain(
        private val manageResource: ManageResource
    ) : HandleError<DomainException, String> {
        override fun handle(error: DomainException) = error.handle(manageResource)
    }

    class Data : HandleError<Exception, DomainException> {
        override fun handle(error: Exception): DomainException {
            return if (error is java.net.ConnectException || error is UnknownHostException)
                NoConnectionException
            else
                ServiceUnavailableException
        }
    }
}