package com.example.finalapp.ui

import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.finalapp.viewmodel.AppViewModel

@Composable
fun MyNavController(navController: NavHostController, appViewModel: AppViewModel = viewModel()) {
    NavHost(
        navController = navController,
        startDestination = "Home"
    ) {
        composable(route = "Home") {
            MainScreen(uiState = appViewModel.appUIState)
        }
        composable(route = "Info") {
            InfoScreen()
        }
    }
}

@Composable
fun MyBottomNavigation(items: List<TabItem>, navController: NavController) {
    var selectedItem by remember { mutableStateOf(0) }
    BottomNavigation {
        items.forEachIndexed { index, item ->
            BottomNavigationItem(
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    navController.navigate(item.route)
                },
                icon = { Icon(item.icon, contentDescription = null) },
                label = { Text(item.label) }
            )
        }
    }
}