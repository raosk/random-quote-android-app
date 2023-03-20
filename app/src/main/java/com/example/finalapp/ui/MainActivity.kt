package com.example.finalapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.finalapp.R
import com.example.finalapp.ui.theme.FinalAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FinalAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BasicLayout()
                }
            }
        }
    }
}

@Composable
fun BasicLayout() {
    val navController = rememberNavController()
    val items = listOf(
        TabItem(stringResource(R.string.home), Icons.Filled.Home, "Home"),
        TabItem(stringResource(R.string.info), Icons.Filled.Info, "Info"),
    )
    Scaffold(
        topBar = { TopAppBar {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = stringResource(R.string.app_title), style = MaterialTheme.typography.h1)
            }
        }
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
            ) { MyNavController(navController = navController) }
        },
        bottomBar = { MyBottomNavigation(items, navController) }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FinalAppTheme {
        BasicLayout()
    }
}