package com.afrcvn.quran

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.afrcvn.quran.component.Container
import com.afrcvn.quran.quran.QuranProvider
import com.afrcvn.quran.quran.QuranView
import com.afrcvn.quran.quran.QuranViewModel
import com.afrcvn.quran.ui.theme.QuranTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalPagerApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        QuranProvider.initialize(this)
        setContent {
            val pagerState = rememberPagerState(initialPage = Int.MAX_VALUE/2)
            val qModel by remember { mutableStateOf(QuranViewModel(pagerState)) }
            QuranTheme {
                // A surface container using the 'background' color from the theme
                CompositionLocalProvider(LocalQuranModel provides qModel) {
                    Container(cover = { QuranView()}) {
                    }
                }
            }
        }
    }
}
val LocalQuranModel = compositionLocalOf<QuranViewModel> { error("No user found!") }

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val context = LocalContext.current
    QuranProvider.initialize(context)
    QuranTheme {
        Container(cover = { QuranView() }) {
            Text(text = "")
        }
    }
}