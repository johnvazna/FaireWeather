package com.faire.core.domain

import com.faire.core.utils.Result
import com.faire.weather.exception.ErrorEntity
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

abstract class SuspendUseCase<in Params, out Results, Type>(
    private val coroutineDispatcher: CoroutineDispatcher,
    private val mapper: Mapper<Type, Results>
) {

    suspend operator fun invoke(parameters: Params): Result<Results> {
        return try {
            withContext(coroutineDispatcher) {
                mapper.domainToPresentation(execute(parameters))
            }
        } catch (e: Exception) {
            Result.Error(ErrorEntity.Generic)
        }
    }

    @Throws(RuntimeException::class)
    protected abstract suspend fun execute(parameters: Params): Result<Type>
}

suspend operator fun <Results, Type> SuspendUseCase<Unit, Results, Type>.invoke(): Result<Results> =
    this(Unit)
