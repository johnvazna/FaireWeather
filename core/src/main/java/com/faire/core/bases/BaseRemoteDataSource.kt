package com.faire.core.bases

import com.faire.core.utils.Result
import com.faire.weather.exception.ErrorApi
import com.faire.weather.exception.ErrorHandler
import com.faire.weather.exception.ErrorSource
import com.faire.weather.exception.toDomain
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import okhttp3.ResponseBody
import retrofit2.HttpException

abstract class BaseRemoteDataSource : ErrorHandler {

    protected suspend fun <Out> getResult(
        call: suspend () -> Out
    ): Result<Out> = try {
        Result.Success(call())
    } catch (e: Exception) {
        Result.Error(error = getError(e).toDomain())
    }

    override suspend fun getError(throwable: Throwable): ErrorSource = when (throwable) {
        is HttpException -> getErrorFromBody(throwable.response()?.errorBody())
        else -> ErrorSource.Generic
    }

    private fun getErrorFromBody(errorBody: ResponseBody?): ErrorSource {
        return errorBody?.let {
            try {
                val errorApi = Gson().fromJson(it.string(), ErrorApi::class.java)

                errorApi.let {
                    ErrorSource.ErrorDetail(
                        errorApi.error
                    )
                }

            } catch (jsonException: JsonSyntaxException) {
                //log(jsonException.message.toString())
                ErrorSource.Generic
            }
        } ?: ErrorSource.Generic
    }
}
