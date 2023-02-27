package com.afrcvn.quran.quran.aya

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.afrcvn.quran.R
import com.afrcvn.quran.quran.QuranProvider
import com.afrcvn.quran.ui.theme.QuranTheme

@Composable
fun AyaView(aya: Aya) {
    val context =  LocalContext.current
    val translation = context.resources.getString(
        context.resources.getIdentifier("a${aya.id}", "string", context.packageName)
    )
    Column (modifier = Modifier.padding(5.dp)) {
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
            Text(
                text = aya.textWithEndAya,
                fontFamily = FontFamily(Font(R.font.me_quran)),
                textAlign = TextAlign.Start,
                fontSize = 25.sp,
                lineHeight = 50.sp,
                modifier = Modifier.fillMaxWidth()
            )
        }

        Text(
            text = translation,
            modifier = Modifier.alpha(0.5f).fillMaxWidth(),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AyaViewPreview() {
    QuranTheme {
        val context = LocalContext.current
        QuranProvider.initialize(context)
        AyaView(aya = QuranProvider.aya(292))
    }
}