package com.vishal2376.belleza.presentation.demo.shake

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.vishal2376.belleza.presentation.app.BellezaDemo
import com.vishal2376.belleza.shake.ShakeCard
import com.vishal2376.belleza.shake.ShakeIntensity
import com.vishal2376.belleza.shake.rememberShakeCardState

object ShakeCardDemo : BellezaDemo {
	override val title: String
		get() = "Shake Card"
	override val route: String
		get() = "shake"

	@Composable
	override fun Screen() {
		val state = rememberShakeCardState(shake = true)

		Column(
			modifier = Modifier.fillMaxSize(),
			verticalArrangement = Arrangement.Center,
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			ShakeCard(state = state, intensity = ShakeIntensity.HIGH) {
				Text("I'm shaking ✨")
			}
		}
	}
}