package com.na.sadapay.domain.core.usecase

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

abstract class BackgroundExecuteUseCase<REQUEST, RESPONSE> : BaseUseCase<REQUEST, RESPONSE>() {
    protected abstract fun executeInBackground(request: REQUEST): RESPONSE

    final override fun execute(
        coroutineScope: CoroutineScope,
        request: REQUEST,
        onResponse: (RESPONSE) -> Unit,
        onError: (Exception) -> Unit
    ) {
        coroutineScope.launch {
            try {
                val response = withContext(Dispatchers.IO) { executeInBackground(request) }
                onResponse(response)
            } catch (exception: Exception) {
                handleException(exception, onError)
            }
        }
    }
}
