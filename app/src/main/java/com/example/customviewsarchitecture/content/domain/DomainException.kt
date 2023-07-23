package com.example.customviewsarchitecture.content.domain

import com.example.customviewsarchitecture.R
import com.example.customviewsarchitecture.core.ManageResource

abstract class DomainException(private val id: Int): Exception() {
    fun handle(manageResource: ManageResource) = manageResource.string(id)
}

object NoConnectionException: DomainException(R.string.no_connection_exception)

object ServiceUnavailableException: DomainException(R.string.service_unavailable_exception)