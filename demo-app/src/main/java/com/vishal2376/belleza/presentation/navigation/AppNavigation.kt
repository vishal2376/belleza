package com.vishal2376.belleza.presentation.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vishal2376.belleza.presentation.app.BellezaRegistry

@Composable
fun AppNavigation() {
	val navController = rememberNavController()

	NavHost(
		navController = navController,
		startDestination = "home",
		enterTransition = {
			slideIntoContainer(
				AnimatedContentTransitionScope.SlideDirection.Left,
				animationSpec = tween(500)
			)
		},
		exitTransition = {
			slideOutOfContainer(
				AnimatedContentTransitionScope.SlideDirection.Left,
				animationSpec = tween(500)
			)
		},
		popEnterTransition = {
			slideIntoContainer(
				AnimatedContentTransitionScope.SlideDirection.Right,
				animationSpec = tween(500)
			)
		},
		popExitTransition = {
			slideOutOfContainer(
				AnimatedContentTransitionScope.SlideDirection.Right,
				animationSpec = tween(500)
			)
		}
	) {
		composable("home") {
			HomeScreen(onNavigate = { navController.navigate(it) })
		}
		BellezaRegistry.demos.forEach { demo ->
			composable(demo.route) { demo.Screen(onClickBack = { navController.navigateUp() }) }
		}
	}
}