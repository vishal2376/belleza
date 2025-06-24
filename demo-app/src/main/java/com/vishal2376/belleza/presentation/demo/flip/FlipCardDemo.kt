package com.vishal2376.belleza.presentation.demo.flip

import androidx.compose.runtime.Composable
import com.vishal2376.belleza.presentation.app.BellezaDemo
import com.vishal2376.belleza.presentation.components.BellezaScreen

object FlipCardDemo : BellezaDemo {
	override val title: String
		get() = "Flip Card"
	override val route: String
		get() = "flipcard"

	@Composable
	override fun Screen(onClickBack: () -> Unit) {
		BellezaScreen(
			title = title,
			showBack = true,
			onClickBack = onClickBack
		) {
			FlipCardDemoScreen()
		}
	}
}