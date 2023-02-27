package com.afrcvn.quran.quran.aya

import android.content.Context
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.afrcvn.quran.helper.toArabicNumeral
import com.afrcvn.quran.R
import com.afrcvn.quran.quran.QuranProvider
import com.afrcvn.quran.quran.sura.Sura
import kotlinx.serialization.Serializable

@Serializable
data class Aya(
    val id: Int,
    val number: Int,
    val text: String,
    val simple: String,
    val suraID: Int,
    val sofhaID: Int,
    val hizbID: Int
) {

    val translation: Int = R.string.a292
    val textWithEndAya: String = "${text}\uFD3F${number.toString().toArabicNumeral()}\uFD3E"
    val sura: Sura
        get() = QuranProvider.suras[suraID-1]
}
