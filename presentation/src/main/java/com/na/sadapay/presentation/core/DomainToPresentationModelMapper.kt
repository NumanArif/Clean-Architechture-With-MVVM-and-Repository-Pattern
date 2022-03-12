package com.na.takeaway.presentation.core

abstract class DomainToPresentationModelMapper<INPUT, OUTPUT> {
    abstract fun mapToPresentation(input: INPUT): OUTPUT
}
