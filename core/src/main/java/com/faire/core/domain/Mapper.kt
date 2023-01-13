package com.faire.core.domain

import com.faire.core.utils.Result
import com.faire.core.utils.isSuccess
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

abstract class Mapper<In, Out> {

    fun domainToPresentation(info: Flow<Result<In>>): Flow<Result<Out>> = info.map {
        domainToPresentation(it)
    }

    fun domainToPresentation(info: Result<In>): Result<Out> = when {
        info.isSuccess -> Result.Success(map((info as Result.Success).data!!))
        else -> Result.Error((info as Result.Error).error)
    }

    abstract fun map(info: In): Out
}