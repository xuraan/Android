package com.afrcvn.quran.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.afrcvn.quran.ui.theme.QuranTheme

@Composable
fun CustomButton(
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(onClick = { /*TODO*/ }) {
        Box(
            modifier = Modifier
                .padding(5.dp)
                .clip(CircleShape)
                .background(color = Color.Green)
                
        ){
            title()
        }
    }

}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun CustomButtonPreview() {
    QuranTheme {
        CustomButton(
            title = {
                Icon(imageVector = Icons.Default.Settings, contentDescription = "Gear Icon")

            }
        )
    }
}