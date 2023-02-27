package com.afrcvn.quran.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RankView(
    text: String = "17",
    color: Color = Color.White,
    bgColor: Color = Color.Black
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(40.dp)
            .background(bgColor, shape = CircleShape)
    ) {
        Text(
            text = text,
            color = color,
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(8.dp)
                .widthIn(max = 30.dp),
            maxLines = 1
        )
    }
}

@Preview
@Composable
fun RankViewPreview() {
    Column {
        RankView()
        RankView(
            text = "90",
            color = Color.White,
            bgColor = Color.Black
        )
    }

}