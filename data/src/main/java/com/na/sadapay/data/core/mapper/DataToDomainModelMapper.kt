package com.na.takeaway.data.core.mapper

abstract class DataToDomainModelMapper<INPUT, OUTPUT> {
    abstract fun mapToDomain(input: INPUT): OUTPUT
}
