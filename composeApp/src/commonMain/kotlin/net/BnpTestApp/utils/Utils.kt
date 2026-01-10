package net.BnpTestApp.utils

import net.BnpTestApp.domain.utils.DateUtilsImpl

val dateUtilsForUi = DateUtilsImpl()

fun Long.convertToDate(): String {
    return dateUtilsForUi.convertEpochSecondsToLocalReadableDateString(this)
}