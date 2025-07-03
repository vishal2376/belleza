package com.vishal2376.belleza.flip

/**
 * Default values used by the [FlipCard] composable for flip animations.
 *
 * These values are used when custom values are not explicitly provided.
 * They help simplify usage by offering reasonable defaults for side, direction, speed,
 * and camera distance.
 */
object FlipDefaults {

	/**
	 * The default visible side of the card. Defaults to showing the front side.
	 */
	val side = FlipSide.FRONT

	/**
	 * The default speed of the flip animation. Uses [FlipSpeed.NORMAL].
	 */
	val speed = FlipSpeed.NORMAL

	/**
	 * The default camera distance for the 3D flip effect.
	 * Affects the depth and realism of the rotation perspective.
	 */
	val cameraDistance = FlipCameraDistance.NORMAL

	/**
	 * The default flip direction of the card — horizontal (left/right).
	 */
	val direction = FlipDirection.HORIZONTAL
}