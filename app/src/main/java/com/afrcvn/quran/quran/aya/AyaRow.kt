package com.afrcvn.quran.quran.aya

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import com.afrcvn.quran.Greeting
import com.afrcvn.quran.R
import com.afrcvn.quran.quran.QuranProvider
import com.afrcvn.quran.ui.theme.QuranTheme

@Composable
fun AyaRow(aya: Aya) {
    Column {
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
            Text(
                text = aya.text,
                fontFamily = FontFamily(Font(R.font.me_quran)),
                textAlign = TextAlign.Start
            )
        }

//        Text(text = aya.translation)
    }
}

@Preview(showBackground = true)
@Composable
fun AyaRowPreview() {
    QuranTheme {
        val context = LocalContext.current
        QuranProvider.initialize(context)
       AyaRow(aya = QuranProvider.ayas[290])
    }
}