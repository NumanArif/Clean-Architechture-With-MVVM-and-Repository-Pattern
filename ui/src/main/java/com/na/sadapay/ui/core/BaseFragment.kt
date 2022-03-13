package com.na.sadapay.ui.core

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.na.sadapay.presentation.core.BaseViewModel

abstract class BaseFragment : Fragment() {

    abstract val viewModel: BaseViewModel
    abstract val layoutResource: Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(layoutResource, container, false)

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeUseCaseExecutionError()
        observeDataLoading()
    }

    open fun onDataLoading(isDataLoading: Boolean) = Unit

    @CallSuper
    open fun onUseCaseError(exception: Exception) {
        Log.e("UseCase execution error", exception.message.orEmpty())
    }

    private fun observeDataLoading() {
        viewModel.isDataLoading.observe(viewLifecycleOwner) { isDataLoading ->
            onDataLoading(isDataLoading ?: false)
        }
    }

    private fun observeUseCaseExecutionError() {
        viewModel.useCaseExecutionError.observe(viewLifecycleOwner) { exception ->
            exception?.let { onUseCaseError(it) }
        }
    }
}
