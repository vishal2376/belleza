package com.vishal2376.belleza.presentation.demo.glitch

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vishal2376.belleza.glitch.GlitchCard
import com.vishal2376.belleza.glitch.GlitchIntensity
import com.vishal2376.belleza.glitch.GlitchMode
import com.vishal2376.belleza.glitch.rememberGlitchCardState
import kotlin.time.Duration.Companion.milliseconds

@Composable
fun GlitchCardDemoScreen() {
	val scope = rememberCoroutineScope()

	Column(
		modifier = Modifier
			.fillMaxSize()
			.padding(16.dp),
		verticalArrangement = Arrangement.SpaceEvenly,
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		/** High Intensity - Glitch on Tap */
		/** High Intensity - Glitch on Tap */
		val highState = rememberGlitchCardState(
			mode = GlitchMode.ONCE,
			duration = 800.milliseconds,
			intensity = GlitchIntensity.High
		)
		GlitchCard(
			state = highState,
			modifier = Modifier
				.weight(1f)
				.clickable { highState.start(scope) }
				.padding(8.dp)
		) {
			Text(
				text = "HIGH INTENSITY",
				color = Color.White,
				fontSize = 20.sp,
				fontWeight = FontWeight.Bold
			)
		}

		val mediumState = rememberGlitchCardState(
			mode = GlitchMode.ONCE,
			duration = 1000.milliseconds,
			intensity = GlitchIntensity.Medium
		)
		GlitchCard(
			state = mediumState,
			modifier = Modifier
				.weight(1f)
				.clickable { mediumState.start(scope) }
				.padding(16.dp)
		) {
			Text(
				text = "MEDIUM INTENSITY",
				color = Color.White,
				fontSize = 20.sp,
				fontWeight = FontWeight.Bold
			)
		}

		val lowState = rememberGlitchCardState(
			mode = GlitchMode.ONCE,
			duration = 1200.milliseconds,
			intensity = GlitchIntensity.Low
		)
		GlitchCard(
			state = lowState,
			modifier = Modifier
				.weight(1f)
				.clickable { lowState.start(scope) }
				.padding(16.dp)
		) {
			Text(
				text = "LOW INTENSITY",
				color = Color.White,
				fontSize = 20.sp,
				fontWeight = FontWeight.Bold
			)
		}

		val customState = rememberGlitchCardState(
			mode = GlitchMode.ONCE,
			duration = 1500.milliseconds,
			intensity = GlitchIntensity(Triple(11, 5f, 0.3f))
		)
		GlitchCard(
			state = customState,
			modifier = Modifier
				.weight(1f)
				.clickable { customState.start(scope) }
				.padding(16.dp)
		) {
			Text(
				text = "CUSTOM INTENSITY",
				color = Color.White,
				fontSize = 20.sp,
				fontWeight = FontWeight.Bold
			)
		}
	}
}