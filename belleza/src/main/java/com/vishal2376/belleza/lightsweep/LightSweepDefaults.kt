package com.vishal2376.belleza.lightsweep

import androidx.compose.ui.graphics.Color

/**
 * Default values used for configuring the light sweep animation.
 *
 * These values provide reasonable presets for duration, sweep color,
 * and sweep width, and can be overridden when customizing the animation.
 */
object LightSweepDefaults {

	/**
	 * The default duration configuration for the light sweep animation.
	 * Typically represented as an enum or value class, e.g., [LightSweepDuration.NORMAL].
	 */
	val duration = LightSweepDuration.NORMAL

	/**
	 * The default color of the light sweep effect.
	 * Pure white is commonly used to simulate a light glint.
	 */
	val color = Color(0xFFFFFFFF)

	/**
	 * The default width (in pixels) of the sweeping light band.
	 * Controls how thick the sweep appears across the surface.
	 */
	val width = 400
}