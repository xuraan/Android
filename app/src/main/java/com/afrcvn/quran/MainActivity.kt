package com.afrcvn.quran

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import com.afrcvn.quran.quran.QuranProvider
import com.afrcvn.quran.quran.aya.Aya
import com.afrcvn.quran.ui.theme.QuranTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        QuranProvider.initialize(this)
        setContent {
            QuranTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    QuranProvider.ayasBySura[1]?.let { ScrollableList(ayas = it) }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun ScrollableList(ayas: List<Aya>) {
    LazyColumn {
        items(ayas) { aya ->
            // Display each item in the list
            Text(text = aya.text)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    QuranTheme {
        Greeting("Android")
    }
}