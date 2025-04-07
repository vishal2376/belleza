package com.vishal2376.belleza.presentation.app

import androidx.compose.runtime.Composable

interface BellezaDemo {
	val title: String
	val route: String

	@Composable
	fun Screen(onClickBack: () -> Unit)
}