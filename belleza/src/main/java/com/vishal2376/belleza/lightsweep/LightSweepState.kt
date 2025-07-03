package com.vishal2376.belleza.lightsweep

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

/**
 * Holds the state for a light sweep animation.
 *
 * This state can be passed to a composable (e.g., `LightSweepCard`) to control
 * whether the light sweep effect should play.
 *
 * @param lightSweep Whether the light sweep effect is active.
 */
class LightSweepState(
	lightSweep: Boolean
) {
	/**
	 * Controls whether the light sweep animation should play.
	 * Set this to `true` to trigger the effect.
	 */
	var lightSweep by mutableStateOf(lightSweep)
}

/**
 * Creates and remembers a [LightSweepState] to control the light sweep animation.
 *
 * This function should be used inside a Composable scope and passed to a component
 * that supports light sweep animation.
 *
 * @param lightSweep The initial value for whether the light sweep is active.
 * @return A remembered [LightSweepState] instance.
 */
@Composable
fun rememberLightSweepState(
	lightSweep: Boolean = false
): LightSweepState = remember {
	LightSweepState(lightSweep)
}
