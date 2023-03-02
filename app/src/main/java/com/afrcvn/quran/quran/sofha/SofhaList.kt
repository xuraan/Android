package com.afrcvn.quran.quran.sofha

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.sp
import com.afrcvn.quran.R
import com.afrcvn.quran.component.RowButton
import com.afrcvn.quran.quran.QuranProvider
import com.afrcvn.quran.ui.theme.QuranTheme

@Composable
fun SofhaList(sofhas: List<Sofha> = QuranProvider.sofhas) {
    LazyColumn{
        items(items = sofhas){ sofha ->
            val first = sofha.ayas?.first()?.textWithEndAya ?: ""
            val last = sofha.ayas?.last()?.textWithEndAya ?: ""

            RowButton(id = "${sofha.id}", label = {
                CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                    androidx.compose.material3.Text(
                        text = first,
                        fontFamily = FontFamily(Font(R.font.me_quran)),
                        textAlign = TextAlign.Start,
                        fontSize = 18.sp,
                        lineHeight = 50.sp,
                        modifier = Modifier.fillMaxWidth(),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                }
            }, action = {

            })
        }
    }
}

@Preview
@Composable
fun SofhaListPreview() {
    QuranTheme {
        QuranProvider.initialize(LocalContext.current)
        SofhaList()
    }
}