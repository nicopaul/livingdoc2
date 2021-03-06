package org.livingdoc.fixture.converter.time

import java.time.LocalDate
import java.time.format.DateTimeFormatter


open class LocalDateConverter : AbstractTemporalConverter<LocalDate>() {
    override fun defaultFormatter(): DateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE
    override fun doParse(value: String, formatter: DateTimeFormatter): LocalDate = LocalDate.parse(value, formatter)
}
