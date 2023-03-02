package com.afrcvn.quran.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.afrcvn.quran.R
import com.afrcvn.quran.helper.isArabic
import com.afrcvn.quran.ui.theme.QuranTheme

@Composable
fun RowButton(
    id: String,
    texts: List<String>? = null,
    label: (@Composable ()-> Unit)? = null,
    action: () -> Unit
) {
    Row(
        modifier = Modifier
            .clickable(onClick = action)
            .padding(5.dp)
        ,
        verticalAlignment = Alignment.CenterVertically
    ){
        RankView(modifier = Modifier.padding(end = 5.dp), text = id)
        if (texts != null) {
            for (text in texts) {
                val isArabic = text.isArabic()
                Text(
                    text = text,
                    modifier = Modifier
                        .weight(1f)
                        .alpha(if (text.isArabic()) 1f else 0.5f),
                    textAlign = if (text.isArabic()) TextAlign.End else TextAlign.Start,
                    softWrap = true,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    fontFamily = FontFamily(Font(R.font.me_quran)),
                    fontSize = (if (isArabic) 22 else 17).sp,
                )
            }
        } else if (label != null) {
            label()
        }
    }
}

@Preview
@Composable
fun RowButtonPreview() {
    QuranTheme {
        Column {
            RowButton(id = "70", texts = listOf("Al baqara", "The crow", "البقرة")) {

            }
            RowButton(id = "90", label = { Text("Label") }) {

            }
            RowButton(id = "90") {

            }
        }
    }
}