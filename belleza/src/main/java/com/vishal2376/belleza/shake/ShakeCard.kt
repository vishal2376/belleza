package com.vishal2376.belleza.shake

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun ShakeCard(
	state: ShakeCardState,
	intensity: ShakeIntensity = ShakeDefaults.Intensity,
	speed: ShakeSpeed = ShakeDefaults.Speed,
	modifier: Modifier = Modifier,
	content: @Composable () -> Unit
) {
	val coroutineScope = rememberCoroutineScope()
	val offsetAnim = remember { Animatable(0f) }

	LaunchedEffect(state.shake, intensity, speed) {
		if (state.shake) {
			launch {
				offsetAnim.animateTo(
					targetValue = intensity.offset,
					animationSpec = infiniteRepeatable(
						animation = tween(speed.durationMillis, easing = LinearEasing),
						repeatMode = RepeatMode.Reverse
					)
				)
			}
		} else {
			// Snap back to original position smoothly
			offsetAnim.animateTo(
				targetValue = 0f,
				animationSpec = tween(durationMillis = 150)
			)
		}
	}

	val shakeModifier = when (state.shakeDirection) {
		ShakeDirection.HORIZONTAL -> Modifier.offset(x = offsetAnim.value.dp)
		ShakeDirection.VERTICAL -> Modifier.offset(y = offsetAnim.value.dp)
	}

	Box(
		modifier = modifier.then(shakeModifier)
	) {
		content()
	}
}