package com.vishal2376.belleza.presentation.demo.reflection

import androidx.compose.runtime.Composable
import com.vishal2376.belleza.presentation.app.BellezaDemo
import com.vishal2376.belleza.presentation.components.BellezaScreen

object ReflectionCardDemo : BellezaDemo {
	override val title: String
		get() = "Reflection Card"
	override val route: String
		get() = "reflectioncard"

	@Composable
	override fun Screen(onClickBack: () -> Unit) {
		BellezaScreen(
			title = title,
			showBack = true,
			onClickBack = onClickBack
		) {
			ReflectionCardDemoScreen()
		}
	}
}