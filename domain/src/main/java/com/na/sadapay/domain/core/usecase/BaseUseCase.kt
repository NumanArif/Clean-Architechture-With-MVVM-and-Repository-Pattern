package com.na.sadapay.domain.core.usecase

import android.util.Log
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope

abstract class BaseUseCase<REQUEST, RESPONSE> {
   abstract fun execute(
        coroutineScope: CoroutineScope,
        request: REQUEST,
        onResponse: (RESPONSE) -> Unit,
        onError: (Exception) -> Unit
    )

    protected fun handleException(exception: Exception, onError: (Exception) -> Unit) {
        when (exception) {
            is CancellationException -> Log.w("Cancellation Error:", exception.message.orEmpty())
            else -> onError(exception)
        }
    }
}
