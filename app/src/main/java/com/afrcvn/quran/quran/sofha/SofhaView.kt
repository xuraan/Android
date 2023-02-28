package com.afrcvn.quran.quran.sofha

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.afrcvn.quran.LocalQuranModel
import com.afrcvn.quran.component.LocalHideCoverOverlays
import com.afrcvn.quran.component.LocalShowHideCoverOverlays
import com.afrcvn.quran.quran.QuranProvider
import com.afrcvn.quran.quran.aya.AyaView
import com.afrcvn.quran.ui.theme.QuranTheme

@Composable
fun SofhaView(
    sofha: Sofha
) {
    val context = LocalContext.current
    val hideCoverOverlays = LocalHideCoverOverlays.current
    val showCoverOverlays = LocalShowHideCoverOverlays.current
    val qModel = LocalQuranModel.current

    val resourceId = context.resources.getIdentifier(
        "p${sofha.id}", "drawable", context.packageName
    )
    val painter = painterResource(resourceId)

    Box(modifier = Modifier){
        Image(
            painter = painter,
            contentDescription = "sofha",
            contentScale = if (qModel.pageVIsFit) ContentScale.Fit else ContentScale.FillBounds ,
            modifier = Modifier
                .fillMaxSize()
                .clickable {
                    qModel.pageVIsFit  = !qModel.pageVIsFit
                    if (qModel.pageVIsFit) showCoverOverlays() else hideCoverOverlays()
                }
                .scale(scaleX = if (qModel.pageVIsFit) 1f else 1.1f, scaleY = 1f)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SofhaViewPreview() {
    QuranTheme {
        val context = LocalContext.current
        QuranProvider.initialize(context)
        SofhaView(sofha = QuranProvider.sofha(5))
    }
}