package com.vishal2376.belleza.glitch

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.graphicsLayer
import kotlinx.coroutines.delay
import kotlin.random.Random

/**
 * A composable that displays its content with a glitch effect using RGB splits,
 * jitter, scanlines, and frame skipping.
 *
 * Use [GlitchCardState.start] and [GlitchCardState.stop] to control the effect.
 *
 * @param state State controlling glitch behavior.
 * @param modifier Modifier applied to the outer box.
 * @param content Content to render with glitch effect.
 */
@Composable
fun GlitchCard(
	state: GlitchCardState,
	modifier: Modifier = Modifier,
	content: @Composable () -> Unit
) {
	val random = remember { Random(System.currentTimeMillis()) }
	val frameToggle = remember { mutableStateOf(true) }

	// Frame skipping
	LaunchedEffect(state.isActive) {
		while (state.isActive) {
			frameToggle.value = random.nextFloat() > GlitchDefaults.frameSkipChance
			delay(16L) // ~60 FPS
		}
		frameToggle.value = true
	}

	Box(
		modifier = modifier,
		contentAlignment = Alignment.Center
	) {
		if (frameToggle.value) {
			if (state.isActive) {
				repeat(state.intensity.count) {
					val offsetX = randomOffset(state.intensity.offsetPx, random)
					val offsetY = randomOffset(state.intensity.offsetPx, random)
					val color = GlitchDefaults.colors.random()

					Box(
						modifier = Modifier
							.matchParentSize()
							.graphicsLayer {
								translationX = offsetX
								translationY = offsetY
							},
						contentAlignment = Alignment.Center
					) {
						CompositionLocalProvider(LocalContentColor provides color) {
							Box(
								modifier = Modifier.drawWithContent {
									drawContent()
									drawRect(
										color = color.copy(alpha = state.intensity.alpha),
										blendMode = BlendMode.Screen
									)
								}
							) {
								content()
							}
						}
					}
				}

				// Scanline flicker
				Box(
					modifier = Modifier
						.matchParentSize()
						.drawWithContent {
							drawContent()
							drawScanlines(size)
						}
				)
			}

			// Base layer
			Box(
				modifier = modifier,
				contentAlignment = Alignment.Center
			) {
				content()
			}
		}
	}
}

private fun randomOffset(max: Float, random: Random): Float {
	return random.nextFloat() * max * if (random.nextBoolean()) 1 else -1
}

private fun DrawScope.drawScanlines(size: Size) {
	val color = Color.Black.copy(alpha = 0.06f)
	val spacing = 5f
	val height = 1f
	var y = 0f
	while (y < size.height) {
		drawRect(
			color = color,
			topLeft = Offset(0f, y),
			size = Size(size.width, height)
		)
		y += spacing
	}
}
