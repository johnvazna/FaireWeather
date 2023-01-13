package com.faire.weather.exception

sealed class ErrorEntity : Exception() {

    object Generic : ErrorEntity()

    object Network : ErrorEntity()

    data class ErrorDetail(
        override val message: String?
    ) : ErrorEntity()
}
