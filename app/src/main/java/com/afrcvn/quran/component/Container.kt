package com.afrcvn.quran.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.afrcvn.quran.LocalQuranModel
import com.afrcvn.quran.R
import com.afrcvn.quran.quran.QuranProvider
import com.afrcvn.quran.quran.QuranView
import com.afrcvn.quran.quran.QuranViewModel
import com.afrcvn.quran.ui.theme.AccentColor
import com.afrcvn.quran.ui.theme.AccentColorBG
import com.afrcvn.quran.ui.theme.StarColor
import com.afrcvn.quran.ui.theme.StarColorBG
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

val LocalShowCover = compositionLocalOf<()->Unit> { error("No user found!") }
val LocalHideCover = compositionLocalOf<()->Unit> { error("No user found!") }
val LocalHideCoverOverlays = compositionLocalOf<()->Unit> { error("No user found!") }
val LocalShowHideCoverOverlays = compositionLocalOf<()->Unit> { error("No user found!") }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Container(
    cover: @Composable () -> Unit,
    content: @Composable () -> Unit
) {
    var searchText by remember { mutableStateOf("") }
    var isCoverShow by remember { mutableStateOf(false) }
    var isShowCoverOverlays by remember { mutableStateOf(true) }
    var showCover = { isCoverShow = true  }
    var hideCover = { isCoverShow = false  }
    fun hideCoverOverlays(){ isShowCoverOverlays = false  }
    fun showCoverOverlays(){ isShowCoverOverlays = true  }
    val context = LocalContext.current
    CompositionLocalProvider(
        LocalShowCover provides { showCover() },
        LocalHideCover provides { hideCover()},
        LocalShowHideCoverOverlays provides { showCoverOverlays() },
        LocalHideCoverOverlays provides { hideCoverOverlays()}
    ) {
        Box{
            Box(
                modifier = Modifier
                    .zIndex(1f)
                    .blur(if (isCoverShow) 30.dp else 0.dp)

            ){
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
                                }
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
                    },
                    content = {innerPadding ->
                        LazyColumn(
                            modifier = Modifier
                                .padding(innerPadding)
                                .fillMaxSize()
                        ){
                            item {

                                Button(
                                    onClick = { /*TODO*/ },
                                    modifier = Modifier
                                        .padding(horizontal = 16.dp)
                                        .fillMaxWidth()
                                        .height(60.dp)
                                    ,
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = AccentColorBG,
                                        contentColor = AccentColor
                                    )
                                ) {
                                    Text(text = "Search", fontSize = 18.sp)
                                }
                            }
                            item {
                                content()
                            }
                        }
                    }
                )

                Box(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .zIndex(1f)

                ) {
                    ShapeButton(
                        action = showCover,
                        painter = painterResource(R.drawable.book),
                        alpha = if (isShowCoverOverlays) 1f else 0f,
                        size = 32.dp,
                        margin = PaddingValues(15.dp),
                    )
                }

                Box(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .zIndex(1f)
                ) {
                    ShapeButton(
                        action = showCover,
                        imageVector = Icons.Filled.Star,
                        alpha = if (isShowCoverOverlays) 1f else 0f,
                        size = 32.dp,
                        margin = PaddingValues(15.dp),
                        tint = StarColor,
                        bgColor = StarColorBG
                    )
                }
            }

            Box(
                modifier = Modifier
                    .background(color = Color.Transparent)
                    .alpha(if (isCoverShow) 1f else 0f)
                    .zIndex(if (isCoverShow) 2f else 0f)
            ) {
                cover()
                ShapeButton(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                    ,
                    action = hideCover,
                    imageVector = Icons.Filled.Close,
                    margin = PaddingValues(15.dp),
                    alpha = if (isShowCoverOverlays) 1f else 0f
                )
            }
        }
    }
}


@OptIn(ExperimentalPagerApi::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ContainerPreview() {
    val context = LocalContext.current
    QuranProvider.initialize(context)
    val pagerState = rememberPagerState(initialPage = Int.MAX_VALUE/2)
    var qModel by remember { mutableStateOf(QuranViewModel(pagerState)) }
    CompositionLocalProvider(LocalQuranModel provides qModel) {
        Container(content = {

        }, cover = {
            QuranView()
        })
    }
}

