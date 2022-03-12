package com.na.sadapay.domain.core.usecase

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

abstract class ContinuousExecuteUseCase<REQUEST, RESPONSE> : BaseUseCase<REQUEST, RESPONSE>() {
    protected abstract suspend fun executeInBackground(
        request: REQUEST,
        onResponse: (RESPONSE) -> Unit
    )

    final override fun execute(
        coroutineScope: CoroutineScope,
        request: REQUEST,
        onResponse: (RESPONSE) -> Unit,
        onError: (Exception) -> Unit
    ) {
        coroutineScope.launch {
            try {
                withContext(Dispatchers.IO) {
                    executeInBackground(request) { response ->
                        CoroutineScope(Dispatchers.Main).launch { onResponse(response) }
                    }
                }
            } catch (exception: Exception) {
                handleException(exception, onError)
            }
        }
    }
}
