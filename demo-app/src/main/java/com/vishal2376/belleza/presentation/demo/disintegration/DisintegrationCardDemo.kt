package com.vishal2376.belleza.presentation.demo.disintegration

import androidx.compose.runtime.Composable
import com.vishal2376.belleza.presentation.app.BellezaDemo
import com.vishal2376.belleza.presentation.components.BellezaScreen

object DisintegrationCardDemo : BellezaDemo {
	override val title: String
		get() = "Disintegration Card"
	override val route: String
		get() = "disintegration"

	@Composable
	override fun Screen(onClickBack: () -> Unit) {
		BellezaScreen(
			title = title,
			onClickBack = onClickBack
		) {
			DisintegrationCardDemoScreen()
		}
	}
}
