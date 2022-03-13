package com.na.sadapay.data.core.mapper

abstract class ApiToDataModelMapper<INPUT, OUTPUT> {
    abstract fun mapToData(input: INPUT): OUTPUT
}
