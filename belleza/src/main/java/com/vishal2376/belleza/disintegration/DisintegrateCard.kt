package com.vishal2376.belleza.disintegration

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import kotlinx.coroutines.delay
import kotlin.random.Random

@Composable
fun DisintegrationCard(
	modifier: Modifier = Modifier,
	state: DisintegrationCardState = rememberDisintegrationCardState(),
	particleSize: Dp = DisintegrationDefaults.particleSize,
	particleColor: Color = DisintegrationDefaults.particleColor,
	minFadeDuration: Int = DisintegrationDefaults.minFadeDurationMillis,
	maxFadeDuration: Int = DisintegrationDefaults.maxFadeDurationMillis,
	maxDelayMillis: Int = DisintegrationDefaults.maxStartDelayMillis,
	maxDisplacement: Float = DisintegrationDefaults.maxDisplacement,
	content: @Composable () -> Unit
) {
	val density = LocalDensity.current
	var cardSize by remember { mutableStateOf(IntSize.Zero) }
	var showParticles by remember { mutableStateOf(false) }

	// Trigger and auto-cleanup
	LaunchedEffect(state.isDisintegrated) {
		if (state.isDisintegrated) {
			showParticles = true
			delay((maxFadeDuration + maxDelayMillis + 200).toLong())
			showParticles = false
			state.reset()
		}
	}

	Box(
		modifier = modifier.onSizeChanged { cardSize = it }
	) {
		if (!state.isDisintegrated) {
			content()
		}

		if (showParticles) {
			val particleSizePx = with(density) { particleSize.toPx() }
			val rows = (cardSize.height / particleSizePx).toInt()
			val cols = (cardSize.width / particleSizePx).toInt()

			val particles = remember(cardSize) {
				List(rows * cols) { i ->
					val x = (i % cols) * particleSizePx
					val y = (i / cols) * particleSizePx
					val offsetX = Random.nextFloat() * maxDisplacement - maxDisplacement / 2
					val offsetY = Random.nextFloat() * maxDisplacement - maxDisplacement / 2
					val alpha = Random.nextFloat().coerceIn(0.3f, 1f)
					val delay = Random.nextInt(0, maxDelayMillis)
					val duration = Random.nextInt(minFadeDuration, maxFadeDuration)
					ParticleAnimated(
						origin = Offset(x, y),
						offsetX = offsetX,
						offsetY = offsetY,
						alphaStart = alpha,
						delayMillis = delay,
						durationMillis = duration
					)
				}
			}

			ParticlesCanvas(
				particles = particles,
				particleSizePx = particleSizePx,
				color = particleColor
			)
		}
	}
}
