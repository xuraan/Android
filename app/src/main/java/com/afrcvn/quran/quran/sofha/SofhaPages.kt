package com.afrcvn.quran.quran.sofha

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.afrcvn.quran.LocalQuranModel
import com.afrcvn.quran.quran.QuranProvider
import com.afrcvn.quran.quran.sura.SuraView
import com.afrcvn.quran.ui.theme.QuranTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun SofhaPages(modifier: Modifier = Modifier) {
    val qModel = LocalQuranModel.current
    val pageCount = 604
    val startIndex = Int.MAX_VALUE / 2
    HorizontalPager(count = Int.MAX_VALUE, state = qModel.pagerState, modifier = modifier) { index ->
        val page = (index - startIndex).floorMod(pageCount)
        SofhaView(sofha = QuranProvider.sofha(pageCount-page))
    }
}

private fun Int.floorMod(other: Int): Int = when (other) {
    0 -> this
    else -> this - floorDiv(other) * other
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SofhaPagesPreview() {
    QuranTheme {
        val context = LocalContext.current
        QuranProvider.initialize(context)

        SofhaPages()
    }
}