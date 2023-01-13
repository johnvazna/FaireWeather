package com.faire.weather.network

import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

object OkHttpHelper {

    private const val TIMEOUT = 79L

    fun getOkHttpBuilder() = OkHttpClient.Builder().apply {
        readTimeout(TIMEOUT, TimeUnit.SECONDS)
        writeTimeout(TIMEOUT, TimeUnit.SECONDS)
        connectTimeout(TIMEOUT, TimeUnit.SECONDS)
    }
}
