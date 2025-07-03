package com.vishal2376.belleza.shake

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

/**
 * Holds the state for a [ShakeCard], including whether it is currently shaking
 * and the direction of the shake animation.
 *
 * This state can be toggled externally to trigger or stop the shake effect.
 *
 * @param shake Whether the shake animation is active.
 * @param shakeDirection The direction of the shake — horizontal or vertical.
 */
class ShakeCardState(
	shake: Boolean,
	shakeDirection: ShakeDirection
) {
	/**
	 * Indicates whether the shake animation is currently active.
	 * Set to `true` to start shaking, and `false` to stop.
	 */
	var shake by mutableStateOf(shake)

	/**
	 * The direction in which the card should shake.
	 * See [ShakeDirection.HORIZONTAL] or [ShakeDirection.VERTICAL].
	 */
	var shakeDirection by mutableStateOf(shakeDirection)
}

/**
 * Creates and remembers a [ShakeCardState] instance used to control a [ShakeCard].
 *
 * You can use this state to programmatically start or stop the shake effect,
 * and to set the direction of the shake.
 *
 * @param shake Initial value for whether the shake animation is active. Defaults to `false`.
 * @param shakeDirection Initial shake direction. Defaults to [ShakeDefaults.Direction].
 * @return A remembered instance of [ShakeCardState].
 */
@Composable
fun rememberShakeCardState(
	shake: Boolean = false,
	shakeDirection: ShakeDirection = ShakeDefaults.Direction
): ShakeCardState = remember {
	ShakeCardState(shake, shakeDirection)
}
