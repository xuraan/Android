package com.afrcvn.quran.component

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.afrcvn.quran.R
import com.afrcvn.quran.ui.theme.AccentColor
import com.afrcvn.quran.ui.theme.AccentColorBG
import com.google.android.material.internal.ViewUtils.RelativePadding

@Composable
fun ShapeButton(
    modifier: Modifier = Modifier,
    action: () -> Unit,
    tint: Color = AccentColor,
    bgColor: Color = AccentColorBG,
    shape: Shape = CircleShape,
    painter: Painter? = painterResource(R.drawable.ic_launcher_background),
    imageVector: ImageVector? = null,
    padding: PaddingValues = PaddingValues(5.dp),
    margin: PaddingValues = PaddingValues(0.dp),
    alpha: Float = 1f,
    size: Dp = 24.dp
) {
    Box(
        modifier = Modifier
            .padding(margin)
            .alpha(alpha)
            .clip(shape)
            .background(color = bgColor, shape = shape)
            .clickable(onClick = action)
            .padding(padding)
            .then(modifier)
    ) {
        if (imageVector != null){
            Icon(imageVector = imageVector, contentDescription = "", tint = tint, modifier = Modifier.size(size))
        } else if (painter != null) {
                Icon(painter = painter, contentDescription = "", tint = tint,modifier = Modifier.size(size))
        } else {
            Icon(imageVector = Icons.Default.MoreVert, contentDescription = "")
        }
    }
}