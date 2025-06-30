package com.vishal2376.belleza.disintegration

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.ui.geometry.Offset
import kotlinx.coroutines.delay

data class ParticleAnimated(
	val origin: Offset,
	val offsetX: Float,
	val offsetY: Float,
	val alphaStart: Float,
	val delayMillis: Int,
	val durationMillis: Int
) {
	val progress = Animatable(0f)

	suspend fun animate() {
		delay(delayMillis.toLong())
		progress.animateTo(
			targetValue = 1f,
			animationSpec = tween(durationMillis, easing = LinearEasing)
		)
	}
}
