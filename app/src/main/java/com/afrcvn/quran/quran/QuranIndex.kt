package com.afrcvn.quran.quran

import androidx.compose.foundation.layout.Box
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.afrcvn.quran.quran.sura.SuraList
import com.afrcvn.quran.ui.theme.QuranTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.afrcvn.quran.quran.aya.Aya
import com.afrcvn.quran.quran.sofha.SofhaList
import com.afrcvn.quran.ui.theme.AccentColor
import com.afrcvn.quran.ui.theme.AccentColorBG
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

data class TabRowItem(
    val title: String,
    val icon: ImageVector,
    val screen: @Composable () -> Unit,
)

@Composable
fun TabScreen(
    text: String,
) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium,
        )
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun QuranIndexView() {
    var state by remember { mutableStateOf(0) }
    val pageState = rememberPagerState(initialPage = 1)
    val titles = listOf("Hizb", "Surah", "Page")
    val coroutineScope = rememberCoroutineScope()


    Column {
        TabRow(selectedTabIndex = pageState.currentPage) {
            titles.forEachIndexed { index, title ->
                Tab(
                    selected = pageState.currentPage == index,
                    onClick = { coroutineScope.launch { pageState.animateScrollToPage(index) } },
                    text = { Text(text = title, maxLines = 1, overflow = TextOverflow.Ellipsis) },
                    selectedContentColor = AccentColor,
                    unselectedContentColor = AccentColor.copy(alpha = 0.7f)
                )
            }
        }

        HorizontalPager(count = titles.count(), state = pageState) {
            when (it) {
                0 -> { Text("HERe") }
                1 -> { SuraList() }
                else -> { SofhaList() }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun QuranIndexViewPreview() {
    QuranTheme {
        QuranProvider.initialize(LocalContext.current)
        QuranIndexView()
    }
}