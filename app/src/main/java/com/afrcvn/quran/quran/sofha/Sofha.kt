package com.afrcvn.quran.quran.sofha

import com.afrcvn.quran.quran.QuranProvider

data class Sofha(
    val id: Int
) {
    val ayas = QuranProvider.ayasBySofha[id]
}
