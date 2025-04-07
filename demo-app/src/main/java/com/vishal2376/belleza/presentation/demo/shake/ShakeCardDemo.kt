package com.vishal2376.belleza.presentation.demo.shake

import androidx.compose.runtime.Composable
import com.vishal2376.belleza.presentation.app.BellezaDemo
import com.vishal2376.belleza.presentation.components.BellezaScreen

object ShakeCardDemo : BellezaDemo {
	override val title: String
		get() = "Shake Card"
	override val route: String
		get() = "shake"

	@Composable
	override fun Screen(onClickBack: () -> Unit) {
		BellezaScreen(
			title = title,
			showBack = true,
			onClickBack = onClickBack
		) {
			ShakeCardDemoScreen()
		}
	}
}