package com.afrcvn.quran.quran

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState

class QuranViewModel @OptIn(ExperimentalPagerApi::class) constructor(pagerState: PagerState) : ViewModel() {
    @OptIn(ExperimentalPagerApi::class)
    var pagerState: PagerState = pagerState
        private set
    var tab by mutableStateOf(Tab.SOFHA)
    var pageVIsFit by mutableStateOf(true)

    enum class Tab {
        SURA,
        SOFHA;
    }
}