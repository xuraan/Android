package com.afrcvn.quran.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.afrcvn.quran.ui.theme.QuranTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.Icon


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SheetButton(
    content: @Composable () -> Unit,
    label: @Composable (() -> Unit)? = null,
    title: String? = null,
    sheetHeight: Int = 700

) {
    val sheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val coroutineScope = rememberCoroutineScope()

    Box(modifier = Modifier.clickable{
        coroutineScope.launch {
            sheetState.show()
        }
    }){
        if (title != null) {
            Text(text = title)
        } else if (label != null) {
            label()
        }
    }

    ModalBottomSheetLayout(
        sheetState = sheetState,
        sheetContent = {
            Column(
                Modifier
                    .fillMaxWidth()
                    .height(sheetHeight.dp)
            ) {
                content()
            }
       } ,
        content = { },
        sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp, bottomEnd = 0.dp, bottomStart = 0.dp),
        sheetContentColor = MaterialTheme.colors.onSurface,
        sheetElevation = 8.dp,
        sheetBackgroundColor = Color.White
    )
}

@Preview(showBackground = true)
@Preview
@Composable
fun SheetButtonPreview() {
    QuranTheme {
        Row {
            SheetButton(
                title = "Show Sheet",
                sheetHeight = 750,
                content = {
                    // This is the content that will be displayed inside the sheet
                    Text(text = "Hello, Sheet!")
                    Text(text = "Hello, Sheet!")
                    Text(text = "Hello, Sheet!")
                    Text(text = "Hello, Sheet!")
                }
            )

            SheetButton(
                sheetHeight = 750,
                content = {
                    // This is the content that will be displayed inside the sheet
                    Text(text = "Hello, Sheet!")
                    Text(text = "Hello, Sheet!")
                    Text(text = "Hello, Sheet!")
                    Text(text = "Hello, Sheet!")
                },
                label = {
                    Icon(imageVector = Icons.Default.Settings, contentDescription = "Gear Icon")
                }
            )
        }
    }
}