package com.na.sadapay.domain.core.mapper

abstract class DomainToDataModelMapper<INPUT, OUTPUT> {
    abstract fun mapToData(input: INPUT): OUTPUT
}
