package com.vishal2376.belleza.disintegration

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.launch

@Composable
internal fun ParticlesCanvas(
	particles: List<ParticleAnimated>,
	particleSizePx: Float,
	color: Color
) {
	LaunchedEffect(particles) {
		particles.forEach { particle ->
			launch { particle.animate() }
		}
	}

	Canvas(modifier = Modifier.fillMaxSize()) {
		particles.forEach { particle ->
			val p = particle.progress.value
			val x = particle.origin.x + particle.offsetX * p
			val y = particle.origin.y + particle.offsetY * p
			val alpha = particle.alphaStart * (1f - p)

			drawRect(
				color = color.copy(alpha = alpha),
				topLeft = Offset(x, y),
				size = androidx.compose.ui.geometry.Size(particleSizePx, particleSizePx)
			)
		}
	}
}
