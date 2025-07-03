package com.vishal2376.belleza.shake

/**
 * Default configuration values used for the [ShakeCard] animation.
 *
 * These values simplify usage by providing sensible presets for shake intensity,
 * speed, and direction. You can override them as needed.
 */
object ShakeDefaults {

	/**
	 * The default shake intensity. Determines how far the content moves during the shake.
	 * Defaults to [ShakeIntensity.MEDIUM].
	 */
	val Intensity = ShakeIntensity.MEDIUM

	/**
	 * The default speed of the shake animation.
	 * Controls how quickly the content oscillates. Defaults to [ShakeSpeed.FAST].
	 */
	val Speed = ShakeSpeed.FAST

	/**
	 * The default direction of the shake animation — horizontal by default.
	 */
	val Direction = ShakeDirection.HORIZONTAL
}
