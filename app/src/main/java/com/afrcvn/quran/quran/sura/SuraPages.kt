package com.afrcvn.quran.quran.sura

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.afrcvn.quran.LocalQuranModel
import com.afrcvn.quran.quran.QuranProvider
import com.afrcvn.quran.ui.theme.QuranTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun SuraPages(modifier: Modifier = Modifier) {
    val qModel = LocalQuranModel.current
    val pageCount = 114
    HorizontalPager(count = Int.MAX_VALUE, state = qModel.pagerState, modifier = modifier) { index ->
        val page = (index - Int.MAX_VALUE/2).floorMod(pageCount)
        SuraView(sura = QuranProvider.sura(pageCount-page))
    }
}

private fun Int.floorMod(other: Int): Int = when (other) {
    0 -> this
    else -> this - floorDiv(other) * other
}

@Preview(showBackground = true)
@Composable
fun SuraPagesPreview() {
    QuranTheme {
        val context = LocalContext.current
        QuranProvider.initialize(context)
        SuraPages()
    }
}