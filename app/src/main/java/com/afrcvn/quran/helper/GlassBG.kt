package com.afrcvn.quran.helper

import android.graphics.fonts.Font
import android.graphics.fonts.FontFamily
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Modifier.glassBackground(
//    font: Font = Font(FontFamily.Default, FontWeight.Bold, 24.sp),
    color: Color = MaterialTheme.colorScheme.primary,
    size: Dp = 12.dp,
    shape: Shape = CircleShape
): Modifier = composed {
    this.then(
        Modifier
            .padding(size)
            .background(
                shape = shape,
                color = Color.Transparent,
//                content = {
//                    Box(
//                        modifier = Modifier
//                            .fillMaxSize()
//                            .shadow(
//                                elevation = 5.dp,
//                                shape = shape,
//                                clip = false
//                            )
//                    )
//                }
            )
            .padding(-1.dp)
            .clip(shape)
            .then(
                Modifier
//                    .font(font)
                    .padding(size)
                    .background(color = color)
                    .padding(size)
            )
    )
}
