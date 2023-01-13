package com.faire.weather.exception

sealed class ErrorSource : Exception() {

    object Network : ErrorSource()

    object Generic : ErrorSource()

    object TimeOut : ErrorSource()

    data class ErrorDetail(
        val error: String?
    ) : ErrorSource()
}
