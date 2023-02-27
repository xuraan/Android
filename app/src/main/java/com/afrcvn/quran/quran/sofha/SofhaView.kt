package com.afrcvn.quran.quran.sofha

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.afrcvn.quran.quran.QuranProvider
import com.afrcvn.quran.quran.aya.AyaView
import com.afrcvn.quran.ui.theme.QuranTheme

@Composable
fun SofhaView(sofha: Sofha) {
    val context = LocalContext.current
    val resourceId = context.resources.getIdentifier(
        "p${sofha.id}", "drawable", context.packageName
    )
    val painter = painterResource(resourceId)

    Image(
        painter = painter,
        contentDescription = "sofha",
        modifier = Modifier.fillMaxSize()
    )
}

@Preview
@Composable
fun SofhaViewPreview() {
    QuranTheme {
        val context = LocalContext.current
        QuranProvider.initialize(context)
        SofhaView(sofha = QuranProvider.sofha(5))
    }
}