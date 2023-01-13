package com.faire.weather.exception

sealed class ErrorPresentation {

    object Generic : ErrorPresentation()

    object NoInternet : ErrorPresentation()

    data class ErrorDetail(
        val type: String?
    ) : ErrorPresentation()
}
