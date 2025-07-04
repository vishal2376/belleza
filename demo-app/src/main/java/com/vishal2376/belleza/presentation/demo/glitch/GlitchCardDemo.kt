package com.vishal2376.belleza.presentation.demo.glitch

import androidx.compose.runtime.Composable
import com.vishal2376.belleza.presentation.app.BellezaDemo
import com.vishal2376.belleza.presentation.components.BellezaScreen

object GlitchCardDemo : BellezaDemo {
	override val title: String
		get() = "Glitch Card"
	override val route: String
		get() = "glitchcard"

	@Composable
	override fun Screen(onClickBack: () -> Unit) {
		BellezaScreen(
			title = title,
			onClickBack = onClickBack
		) {
			GlitchCardDemoScreen()
		}
	}
}
