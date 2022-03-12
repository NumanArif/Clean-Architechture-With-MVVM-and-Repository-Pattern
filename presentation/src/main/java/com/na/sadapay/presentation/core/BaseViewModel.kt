package com.na.sadapay.presentation.core

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {
    protected val _useCaseExecutionError by lazy { MutableLiveData<Exception>() }
    val useCaseExecutionError: LiveData<Exception>
        get() = _useCaseExecutionError

    protected val _isDataLoading by lazy { MutableLiveData(false) }
    val isDataLoading: LiveData<Boolean>
        get() = _isDataLoading
}
