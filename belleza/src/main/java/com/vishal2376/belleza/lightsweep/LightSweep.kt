package com.vishal2376.belleza.lightsweep

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

/**
 * A composable that applies a light sweep animation effect over its content.
 *
 * This effect mimics a glint or light reflection moving across the surface,
 * commonly used for highlighting UI components like cards, buttons, or list items.
 *
 * The sweep is controlled via [LightSweepState], allowing the animation to be triggered externally.
 *
 * ### Usage Example:
 * ```
 * val state = rememberLightSweepState()
 *
 * LightSweep(state = state) {
 *     // Your UI content here
 * }
 *
 * // To trigger the animation
 * state.lightSweep = true
 * ```
 *
 * @param state The [LightSweepState] that controls when the sweep effect is triggered.
 * @param width The width (in pixels) of the sweeping light band. Controls the visual thickness of the sweep.
 * @param color The color of the sweep effect. Typically a semi-transparent or bright color like white.
 * @param duration The duration of the sweep animation. Defaults to [LightSweepDefaults.duration].
 * @param modifier The [Modifier] to be applied to the container of the sweep and content.
 * @param content The composable content over which the light sweep effect will be applied.
 */
@Composable
fun LightSweep(
	state: LightSweepState,
	width: Int = LightSweepDefaults.width,
	color: Color = LightSweepDefaults.color,
	duration: LightSweepDuration = LightSweepDefaults.duration,
	modifier: Modifier = Modifier,
	content: @Composable () -> Unit
) {
	val animatedOffset by animateFloatAsState(
		targetValue = if (state.lightSweep) 1.1f else -1.1f,
		animationSpec = tween(duration.durationMillis),
		label = "lightSweepOffset"
	)

	Box(
		modifier = modifier
			.indication(
				interactionSource = remember { MutableInteractionSource() },
				indication = null
			)
			.drawWithCache {
				val start = Offset(size.width * animatedOffset, size.height * animatedOffset)
				val end = Offset(start.x + width, start.y + width)

				val gradient = Brush.linearGradient(
					colors = listOf(
						Color.Transparent,
						color.copy(alpha = 0.05f),
						color.copy(alpha = 0.25f),
						color.copy(alpha = 0.5f),
						color.copy(alpha = 0.25f),
						color.copy(alpha = 0.05f),
						Color.Transparent
					),
					start = start,
					end = end
				)
				onDrawWithContent {
					drawContent()
					drawRect(
						brush = gradient,
						topLeft = Offset.Zero,
						size = size,
						blendMode = BlendMode.Lighten
					)
				}
			}
	) {
		content()
	}
}
