package com.example.finalapp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.finalapp.R
import com.example.finalapp.model.ModelDataClass
import com.example.finalapp.viewmodel.AppUIState

@Composable
fun MainScreen(uiState: AppUIState) {
    when (uiState) {
        is AppUIState.Loading -> LoadingScreen()
        is AppUIState.Success -> QuoteList(uiState.quotes)
        is AppUIState.Error -> ErrorScreen()
    }
}

@Composable
fun LoadingScreen() {
    Text("Loading...")
}

@Composable
fun ErrorScreen() {
    Text("Error retrieving data from API.")
}

@Composable
fun QuoteList(quotes: List<ModelDataClass>) {
    LazyColumn (
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ){
        item {
            Text(
                text = quotes[0].content,
                modifier = Modifier
                    .padding(top = 13.dp, bottom = 6.dp, start = 6.dp, end = 6.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
            )
        }
        item {
            Text(
                text = "~" + quotes[0].author,
                modifier = Modifier
                    .padding(top = 4.dp, bottom = 4.dp, end = 4.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Right,
                fontStyle = FontStyle.Italic
            )
        }
    }
}

@Composable
fun InfoScreen() {
    Column {
        Text(
            text= stringResource(R.string.info_text),
            modifier = Modifier.padding(top = 15.dp, bottom = 6.dp, start = 15.dp, end = 15.dp)
        )
        Text(
            text= stringResource(R.string.info_text_2),
            modifier = Modifier.padding(top = 15.dp, bottom = 6.dp, start = 15.dp, end = 15.dp)
        )
        Text(
            text= stringResource(R.string.info_text_3),
            modifier = Modifier.padding(top = 15.dp, bottom = 6.dp, start = 15.dp, end = 15.dp)
        )
    }
}
