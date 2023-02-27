package com.afrcvn.quran.quran

import android.content.Context
import com.afrcvn.quran.R
import com.afrcvn.quran.quran.aya.Aya
import com.afrcvn.quran.quran.hizb.Hizb
import com.afrcvn.quran.quran.sofha.Sofha
import com.afrcvn.quran.quran.sura.Sura
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlin.reflect.typeOf

object QuranProvider {
    fun initialize(context: Context) {
        ayas = loadJson(context, R.raw.ayas)
        suras = loadJson(context, R.raw.suras)
    }

    var ayas: List<Aya> = listOf()
    var suras: List<Sura> = listOf()
    var sofhas: List<Sofha> = (1..604).map { Sofha(it) }
    var hizbs: List<Hizb> = (1..60).map { Hizb(it) }

    val ayasBySura: Map<Int, List<Aya>> by lazy { ayas.groupBy { it.suraID } }
    val ayasBySofha: Map<Int, List<Aya>> by lazy { ayas.groupBy { it.sofhaID } }
    val ayasByHizb: Map<Int, List<Aya>> by lazy { ayas.groupBy { it.hizbID } }

    val makiyaSuraIDs: List<Int> = listOf(
        1, 6, 7, 10, 11, 12, 14, 15, 16, 17, 18, 19, 20, 21, 23, 25, 26,
        27, 28, 29, 30, 31, 32, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44,
        45, 46, 50, 51, 52, 53, 54, 56, 67, 68, 69, 70, 71, 72, 73, 74, 75,
        77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93,
        94, 95, 96, 97, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 111,
        112, 113, 114
    )

    val madaniyaSuraIDs: List<Int> = listOf(
        2, 3, 4, 5, 8, 9, 13, 22, 24, 33, 47, 48,
        49, 55, 57, 58, 59, 60, 61, 62, 63, 64, 65,
        66, 76, 98, 99, 110
    )

    fun aya(id: Int): Aya {
        return ayas.get(index = id-1)
    }
    fun sura(id: Int): Sura {
        return suras.get(index = id-1)
    }

    private inline fun <reified T : Any> loadJson(context: Context, resourceId: Int): T {
        val jsonString = context.resources.openRawResource(resourceId).bufferedReader().use { it.readText() }
        val json = Json { ignoreUnknownKeys = true }

        return json.decodeFromString<T>(jsonString)
    }
}