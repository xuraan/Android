package com.afrcvn.quran.quran.sura

import com.afrcvn.quran.R
import com.afrcvn.quran.quran.QuranProvider
import kotlinx.serialization.Serializable

@Serializable
data class Sura(
    val id: Int,
    val name: String,
    val phonetic: String
) {
    val ayas = QuranProvider.ayasBySura[id]
}
