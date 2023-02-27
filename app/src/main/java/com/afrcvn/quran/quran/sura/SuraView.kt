package com.afrcvn.quran.quran.sura

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.afrcvn.quran.R
import com.afrcvn.quran.quran.QuranProvider
import com.afrcvn.quran.quran.aya.AyaView
import com.afrcvn.quran.ui.theme.QuranTheme

@Composable
fun SuraView(sura: Sura) {
//    val scrollState = rememberLazyListState()

//    val lastVisibleItemIndex = scrollState.layoutInfo.visibleItemsInfo.lastOrNull()?.index ?: 0
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent)
    ){
        LazyColumn(modifier = Modifier.padding(top = 45.dp)) {
            if (sura.id != 9) {
                item {
                    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                        Text(
                            text = "بِسْمِ اللَّـهِ الرَّحْمَـٰنِ الرَّحِيمِ",
                            fontFamily = FontFamily(Font(R.font.me_quran)),
                            textAlign = TextAlign.Center,
                            fontSize = 25.sp,
                            lineHeight = 50.sp,
                            modifier = Modifier
                                .fillMaxWidth()
                        )                }
                }
            }
            sura.ayas?.let { ayas ->
                items(ayas) { aya ->
                    AyaView(aya = aya)
                }
            }
        }

        Box(
            modifier = Modifier
                .background(Color.Transparent)
        ) {
            Text(
                text = sura.name,
                fontFamily = FontFamily(Font(R.font.me_quran)),
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,

                )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SuraViewPreview() {
    QuranTheme {
        val context = LocalContext.current
        QuranProvider.initialize(context)
        SuraView(sura = QuranProvider.sura(2))
    }
}