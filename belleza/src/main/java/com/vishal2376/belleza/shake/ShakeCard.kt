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

/**
 * A composable that applies a shake animation to its content, simulating a vibrating or jittering effect.
 *
 * Useful for drawing attention to UI components (e.g., invalid fields, alerts) by giving them a repeated
 * horizontal or vertical shaking motion.
 *
 * The shake effect is driven by the [ShakeCardState], which can be toggled externally.
 * You can control the intensity and speed of the shake using [ShakeIntensity] and [ShakeSpeed].
 *
 * ### Usage Example:
 * ```
 * val shakeState = rememberShakeCardState(shake = true)
 *
 * ShakeCard(state = shakeState) {
 *     Text("Invalid input")
 * }
 * ```
 *
 * @param state The [ShakeCardState] that controls when the shake starts and in what direction.
 *              Use [rememberShakeCardState] to create and remember this state.
 * @param intensity The [ShakeIntensity] of the shake, controlling how far the content moves.
 * @param speed The [ShakeSpeed] that defines how fast the shake animation plays.
 * @param modifier Optional [Modifier] applied to the root container.
 * @param content The content inside the shake card, which will be affected by the shake animation.
 */
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