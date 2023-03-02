package com.afrcvn.quran

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.afrcvn.quran.ui.theme.QuranTheme

@Composable
fun SearchScreen(path: NavHostController) {

}

@Preview
@Composable
fun SearchViewPreview() {
    QuranTheme {
        SearchScreen(path = rememberNavController())
    }
}