package com.afrcvn.quran.quran.sofha

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.afrcvn.quran.quran.QuranProvider
import com.afrcvn.quran.quran.sura.SuraView
import com.afrcvn.quran.ui.theme.QuranTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun SofhaPages() {
    val pageCount = 604
    val startIndex = Int.MAX_VALUE / 2
    val pagerState = rememberPagerState(initialPage = startIndex)
    HorizontalPager(count = Int.MAX_VALUE, state = pagerState) { index ->
        val page = (index - startIndex).floorMod(pageCount)
        SofhaView(sofha = QuranProvider.sofha(pageCount-page))
    }
}

private fun Int.floorMod(other: Int): Int = when (other) {
    0 -> this
    else -> this - floorDiv(other) * other
}



@Preview(showBackground = true)
@Composable
fun SofhaPagesPreview() {
    QuranTheme {
        val context = LocalContext.current
        QuranProvider.initialize(context)
        SofhaPages()
    }
}