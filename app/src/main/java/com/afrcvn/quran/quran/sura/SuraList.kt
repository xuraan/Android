package com.afrcvn.quran.quran.sura

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.afrcvn.quran.component.RowButton
import com.afrcvn.quran.quran.QuranProvider
import com.afrcvn.quran.ui.theme.QuranTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SuraList(suras: List<Sura> = QuranProvider.suras) {
    val context = LocalContext.current
    LazyColumn(){
        stickyHeader {
            Row (modifier = Modifier
                .padding( horizontal = 5.dp)
                .background(MaterialTheme.colorScheme.background)
                .alpha(0.5f)
            ) {
                Text(text = "Rank", modifier = Modifier.padding(end = 5.dp), fontSize = 12.sp)
                Text(
                    text = "Phonetic",
                    modifier = Modifier
                        .weight(1f)
                ,
                    fontSize = 12.sp
                )
                Text(
                    text = "Translation",
                    fontSize = 12.sp,
                    modifier = Modifier
                        .weight(1f)
                )
                Text(
                    text = "Surah",
                    fontSize = 12.sp,
                    modifier = Modifier
                        .weight(1f)
                    ,
                    textAlign = TextAlign.End
                )
            }
        }

        items(items = suras){ sura ->
            val translation = context.resources.getString(
                context.resources.getIdentifier("s${sura.id}", "string", context.packageName)
            )
            RowButton(id = "${sura.id}", texts = listOf(sura.phonetic, translation, sura.name)) {
                
            }
        }
    }

}

@Preview(showSystemUi = true)
@Composable
fun SuraListPreview() {
    QuranTheme {
        QuranProvider.initialize(LocalContext.current)
        SuraList()
    }
}