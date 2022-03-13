package com.na.sadapay.ui.core

abstract class PresentationToUiModelMapper<INPUT, OUTPUT> {
    abstract fun mapToUi(input: INPUT): OUTPUT
}
