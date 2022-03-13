package com.na.sadapay.presentation.usecasetestutil

import com.na.sadapay.domain.core.usecase.BaseUseCase
import org.mockito.BDDMockito.doAnswer
import org.mockito.Mockito.mock
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever

inline fun <reified REQUEST, RESULT> BaseUseCase<REQUEST, RESULT>.givenNoArgumentUnSuccessfulUseCaseExecution(
    exception: Exception
) {
    doAnswer { invocationOnMock ->
        (invocationOnMock.arguments[3] as (Exception) -> Unit)(exception)
        mock(this::class.java)
    }.whenever(this).execute(
        coroutineScope = any(),
        request = any(),
        onResponse = any(),
        onError = any()
    )
}

inline fun <reified REQUEST, RESULT> BaseUseCase<REQUEST, RESULT>.givenNoArgumentSuccessfulUseCaseExecution(
    result: RESULT
) {
    doAnswer { invocationOnMock ->
        (invocationOnMock.arguments[2] as (RESULT) -> Unit)(result)
        mock(this::class.java)
    }.whenever(this).execute(
        coroutineScope = any(),
        request = any(),
        onResponse = any(),
        onError = any()
    )
}
