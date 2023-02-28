package com.afrcvn.quran.quran

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.afrcvn.quran.LocalQuranModel
import com.afrcvn.quran.quran.sofha.SofhaPages
import com.afrcvn.quran.quran.sura.SuraPages
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

@Composable
fun QuranView() {
    val qModel = LocalQuranModel.current
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Transparent)
//        .clickable { qModel.tab = if (qModel.tab == QuranViewModel.Tab.SURA) QuranViewModel.Tab.SOFHA else QuranViewModel.Tab.SURA  }
    ) {
        if (qModel.tab == QuranViewModel.Tab.SURA) {
            SuraPages()
        } else {
            SofhaPages()
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun QuranViewPreview() {
    val context = LocalContext.current
    QuranProvider.initialize(context)
    val pagerState = rememberPagerState(initialPage = Int.MAX_VALUE/2)
    var qModel by remember { mutableStateOf(QuranViewModel(pagerState)) }
    CompositionLocalProvider(LocalQuranModel provides qModel) {
        QuranView()
    }
}