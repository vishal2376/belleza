package com.vishal2376.belleza.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val DarkColors = darkColorScheme(
	primary = lavender,
	background = black,
	onBackground = white,
	primaryContainer = gray,
	onPrimaryContainer = white
)

@Composable
fun BellezaTheme(content: @Composable () -> Unit) {
	MaterialTheme(
		colorScheme = DarkColors,
		content = content
	)
}