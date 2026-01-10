package net.BnpTestApp.domain.utils

interface DateUtils {

    fun convertEpochSecondsToLocalReadableDateString(timeStamp: Long): String

}