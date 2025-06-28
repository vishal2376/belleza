package com.vishal2376.belleza.presentation.demo.neumorphism

import androidx.compose.runtime.Composable
import com.vishal2376.belleza.neumorphism.NeumorphismCard
import com.vishal2376.belleza.presentation.app.BellezaDemo
import com.vishal2376.belleza.presentation.components.BellezaScreen

object NeumorphismDemo : BellezaDemo {
	override val title: String
		get() = "Neumorphism"
	override val route: String
		get() = "neumorphism"

	@Composable
	override fun Screen(onClickBack: () -> Unit) {
		BellezaScreen(
			title = title,
			onClickBack = onClickBack
		) {
			NeumorphismDemoScreen()
		}
	}

}
