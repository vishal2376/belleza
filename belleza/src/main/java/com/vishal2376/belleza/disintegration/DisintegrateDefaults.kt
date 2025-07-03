package com.vishal2376.belleza.disintegration

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * Default values used by [DisintegrationCard] for particle animation parameters.
 *
 * These values can be overridden when calling [DisintegrationCard] to customize
 * the appearance and behavior of the disintegration effect.
 */
object DisintegrationDefaults {

	/**
	 * The default size of each particle in the disintegration effect.
	 * Smaller values create a denser grid of particles.
	 */
	val particleSize = 4.dp

	/**
	 * The default color used for the disintegration particles.
	 */
	val particleColor = Color.White

	/**
	 * The maximum offset distance (in pixels) a particle can move from its original position.
	 * Controls the spread of the disintegration.
	 */
	const val maxDisplacement = 60f

	/**
	 * The minimum duration (in milliseconds) a particle will take to fade out.
	 * Each particle is assigned a random fade duration between this and [maxFadeDurationMillis].
	 */
	const val minFadeDurationMillis = 400

	/**
	 * The maximum duration (in milliseconds) a particle will take to fade out.
	 */
	const val maxFadeDurationMillis = 1000

	/**
	 * The maximum delay (in milliseconds) before a particle begins its animation.
	 * Adds randomness to the timing of each particle's appearance.
	 */
	const val maxStartDelayMillis = 300
}