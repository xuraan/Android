package com.afrcvn.quran.helper

fun String.isNumeric(): Boolean {
    return this.toIntOrNull() != null
}

fun String.isArabicNumeral(): Boolean {
    return this.matches("[٠-٩]+".toRegex())
}

fun String.isArabic(): Boolean {
    return this.matches("^[.:\" ء-ي]+$".toRegex())
}

fun String.toArabicNumeral(): String {
    val arabicNumerals = listOf("٠", "١", "٢", "٣", "٤", "٥", "٦", "٧", "٨", "٩")
    var result = ""
    for (char in this) {
        val intValue = char.toString().toIntOrNull()
        result += if (intValue != null) arabicNumerals[intValue] else char.toString()
    }
    return result
}