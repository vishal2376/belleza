package com.vishal2376.belleza.glitch

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration

/**
 * Holds state and behavior of the glitch animation.
 */
class GlitchCardState internal constructor(
	val mode: GlitchMode,
	val duration: Duration,
	val intensity: GlitchIntensity
) {
	internal var isActive by mutableStateOf(false)
		private set

	private var glitchJob: Job? = null

	/**
	 * Starts the glitch animation.
	 * - If [mode] is [GlitchMode.ONCE], it auto stops after [duration].
	 * - If [mode] is [GlitchMode.LOOP], it runs until [stop()] is called.
	 */
	fun start(scope: CoroutineScope) {
		stop()

		if (mode == GlitchMode.ONCE) {
			glitchJob = scope.launch {
				this@GlitchCardState.isActive = true
				delay(duration)
				this@GlitchCardState.isActive = false
			}
		} else {
			isActive = true
		}
	}

	/**
	 * Stops the glitch animation.
	 */
	fun stop() {
		glitchJob?.cancel()
		isActive = false
	}
}

/**
 * Remembers and creates a [GlitchCardState].
 *
 * @param mode Animation behavior: [GlitchMode.ONCE] or [GlitchMode.LOOP]
 * @param duration Used only for [GlitchMode.ONCE]
 * @param intensity Glitch visual strength
 */
@Composable
fun rememberGlitchCardState(
	mode: GlitchMode = GlitchDefaults.mode,
	duration: Duration = GlitchDefaults.duration,
	intensity: GlitchIntensity = GlitchDefaults.intensity
): GlitchCardState = remember {
	GlitchCardState(mode, duration, intensity)
}
