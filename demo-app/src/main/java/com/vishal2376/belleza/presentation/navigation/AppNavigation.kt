package com.vishal2376.belleza.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vishal2376.belleza.presentation.app.BellezaRegistry

@Composable
fun AppNavigation() {
	val navController = rememberNavController()

	NavHost(navController = navController, startDestination = "home") {
		composable("home") {
			HomeScreen(onNavigate = { navController.navigate(it) })
		}
		BellezaRegistry.demos.forEach { demo ->
			composable(demo.route) { demo.Screen(onClickBack = { navController.navigateUp() }) }
		}
	}
}