package com.faire.weather.exception

fun Exception.toPresentation() = when (this) {
    is ErrorEntity.Network -> ErrorPresentation.NoInternet
    is ErrorEntity.ErrorDetail -> ErrorPresentation.ErrorDetail(message)
    else -> ErrorPresentation.Generic
}

fun Exception.toDomain() = when (this) {
    is ErrorSource.Network -> ErrorEntity.Network
    is ErrorSource.ErrorDetail -> ErrorEntity.ErrorDetail(message)
    else -> ErrorSource.Generic
}
