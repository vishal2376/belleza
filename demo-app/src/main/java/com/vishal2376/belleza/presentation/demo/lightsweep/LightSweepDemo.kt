package com.vishal2376.belleza.presentation.demo.lightsweep

import androidx.compose.runtime.Composable
import com.vishal2376.belleza.presentation.app.BellezaDemo
import com.vishal2376.belleza.presentation.components.BellezaScreen

object LightSweepDemo : BellezaDemo {
	override val title: String
		get() = "Light Sweep"
	override val route: String
		get() = "lightsweep"

	@Composable
	override fun Screen(onClickBack: () -> Unit) {
		BellezaScreen(
			title = title,
			showBack = true,
			onClickBack = onClickBack
		) {
			LightSweepDemoScreen()
		}
	}
}