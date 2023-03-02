package com.afrcvn.quran

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.afrcvn.quran.ui.theme.QuranTheme

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    path: NavHostController = rememberNavController(),
    startDestination: String = "HomeScreen"
) {
    NavHost( modifier = modifier, navController = path, startDestination = startDestination ) {
        composable("HomeScreen") {
            HomeScreen(path = path) {
                LazyColumn{
                    item { Text("home Screen") }
                }
            }
        }
        composable("SettingsScreen") { SettingsScreen(path = path) }
        composable("SearchScreen") { SearchScreen(path = path) }
    }
}

@Composable
fun SettingsScreen(path: NavHostController) {
    TODO("Not yet implemented")
}


@Preview(showSystemUi = true)
@Composable
fun MainScreenPreview() {
    QuranTheme {
        MainScreen()
    }
}