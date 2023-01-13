package com.faire.weather.exception

interface ErrorHandler {
    suspend fun getError(throwable: Throwable): ErrorSource
}
