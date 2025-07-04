package com.vishal2376.belleza.glitch

import androidx.compose.ui.graphics.Color
import kotlin.time.Duration.Companion.milliseconds

/**
 * Default configuration values for glitch animation used in [GlitchCard] and [GlitchCardState].
 */
object GlitchDefaults {

	/**
	 * Default duration for glitch animation when using [GlitchMode.ONCE].
	 */
	val duration = 600.milliseconds

	/**
	 * Default list of RGB colors used to create the visual glitch/flicker effect.
	 */
	val colors = listOf(Color.Red, Color.Green, Color.Blue)

	/**
	 * The chance (from 0.0 to 1.0) that a frame will be skipped to simulate random noise.
	 *
	 * A higher value increases the likelihood of frame skipping.
	 */
	const val frameSkipChance: Float = 0.3f

	/**
	 * Default intensity of the glitch effect, which controls the number of overlays,
	 * offset distance, and alpha strength.
	 */
	val intensity = GlitchIntensity.Medium

	/**
	 * Default mode of glitch animation: either [GlitchMode.LOOP] (continuous)
	 * or [GlitchMode.ONCE] (for a specific [duration]).
	 */
	val mode = GlitchMode.LOOP
}
