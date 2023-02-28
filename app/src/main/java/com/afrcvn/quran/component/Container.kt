package com.afrcvn.quran.component

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.afrcvn.quran.quran.QuranProvider
import com.afrcvn.quran.quran.sofha.SofhaPages
import com.afrcvn.quran.quran.sura.SuraPages

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Container(content: @Composable () -> Unit, cover: @Composable () -> Unit) {
    var searchText by remember { mutableStateOf("") }
    var isCoverShow by remember { mutableStateOf(false) }

    Box{
        Scaffold(
            topBar = {
                MediumTopAppBar(
                    title = {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(text = "Quran")
                            IconButton(onClick = { }) {
                                Icon(imageVector = Icons.Filled.Search, contentDescription = "icon")
                            }
                        }
                    },
                    navigationIcon = {
                        TextButton(onClick = { isCoverShow = !isCoverShow }) {
                            Text(text = "Settings")
                        }
                    },
                    actions = {
                        IconButton(onClick = { }) {
                            Icon(imageVector = Icons.Filled.Add, contentDescription = "icon")
                        }
                        IconButton(onClick = { }) {
                            Icon(imageVector = Icons.Filled.List, contentDescription = "icon")
                        }
                    },
                )
            },
            content = {innerPadding ->
                LazyColumn(
                    modifier = Modifier
                        .padding(innerPadding)
                ){
                    item { content() }
                }
            },
            modifier = Modifier
                .blur(if (isCoverShow) 30.dp else 0.dp)
                .zIndex(1f)
        )

        Box(
            modifier = Modifier
                .background(color = Color.Transparent)
                .alpha(if (isCoverShow) 1f else 0f)
                .zIndex(if (isCoverShow) 2f else 0f)
        ) {
            cover()
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ContainerPreview() {
    val context = LocalContext.current
    QuranProvider.initialize(context)
    Container(content = {
        Text("Quran")
        Text("Quran")
        Text("Quran")
        Text("Qurannre")
        Text("Qurannre")
        Text("Qurannre")
        Text("Qurannre")
        Text("Qurannre")
        Text("Qurannre")
        Text("Qurannre")
        Text("Qurannre")
        Text("Qurannre")
        Text("Qurannre")
        Text("Qurannre")
        Text("Qurannre")
        Text("Qurannre")
        Text("Qurannre")
        Text("Qurannre")
        Text("Qurannre")
        Text("Qurannre")
        Text("Qurannre")
        Text("Qurannre")
        Text("Qurannre")
        Text("Qurannre")
        Text("Qurannre")
        Text("Qurannre")
        Text("Qurannre")
        Text("Qurannre")
        Text("Qurannre")
        Text("Qurannre")
        Text("Qurannre")
        Text("Qurannre")
        Text("Qurannre")
        Text("Qurannre")
        Text("Qurannre")
        Text("Qurannre")
        Text("Qurannre")
        Text("Qurannre")
    }, cover = {
        SofhaPages()
    })
}