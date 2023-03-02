package com.afrcvn.quran

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.afrcvn.quran.ui.theme.AccentColor
import com.afrcvn.quran.ui.theme.AccentColorBG
import com.afrcvn.quran.ui.theme.QuranTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    path: NavHostController,
    content: @Composable () -> Unit,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            MediumTopAppBar(
                title = {
                    Text("The noble quran")
                },
                navigationIcon = {
                    TextButton(onClick = {  },
                        colors = ButtonDefaults.textButtonColors(containerColor = Color.Transparent, contentColor = AccentColor)
                    ) {
                        Text(text = "Settings")
                    }

                },
                actions = {
                    IconButton(onClick = { }) {
                        Icon(imageVector = Icons.Filled.Add, contentDescription = "icon", tint = AccentColor)
                    }
                    IconButton(onClick = { }) {
                        Icon(imageVector = Icons.Filled.List, contentDescription = "icon",  tint = AccentColor)
                    }
                },
            )
        }
    ) { paddingValues ->
        Box {
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
                    .height(60.dp),
                colors = ButtonDefaults.buttonColors(containerColor = AccentColorBG, contentColor = AccentColor)
            ) {
                Text(text = "Search", fontSize = 18.sp)
            }
            Column(modifier = modifier.padding(paddingValues)) {
                Button(
                    onClick = { path.navigate("SearchScreen") },
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                        .height(40.dp)
                    ,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = AccentColorBG,
                        contentColor = AccentColor
                    )
                ) {
                    Text(text = "Search", fontSize = 18.sp)
                }
                content()
            }
        }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun HomeScreenPreview() {
    QuranTheme {
        HomeScreen(path = rememberNavController()) {
            LazyColumn{
                item { Text("home Screen") }
            }
        }
    }
}