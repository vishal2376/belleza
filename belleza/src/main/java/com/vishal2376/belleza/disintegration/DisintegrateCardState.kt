package com.vishal2376.belleza.disintegration

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

/**
 * Holds the state for [DisintegrationCard], controlling whether the disintegration animation is triggered.
 *
 * Use [start] to initiate the disintegration effect. Internally, the state will be reset after the
 * animation completes.
 *
 * This state object is remembered using [rememberDisintegrationCardState] and should be passed
 * to the [DisintegrationCard] to control its behavior.
 *
 * @property isDisintegrated Whether the disintegration effect is currently active.
 */
class DisintegrationCardState internal constructor(
	isDisintegrated: Boolean = false
) {
	/**
	 * Whether the disintegration effect has been triggered.
	 * This is set to `true` when [start] is called and reset internally after the animation ends.
	 */
	var isDisintegrated by mutableStateOf(isDisintegrated)
		internal set

	/**
	 * Starts the disintegration animation.
	 * Triggers the effect inside [DisintegrationCard].
	 */
	fun start() {
		isDisintegrated = true
	}

	/**
	 * Resets the state to allow re-triggering the animation.
	 * This is automatically called after the disintegration animation finishes.
	 */
	internal fun reset() {
		isDisintegrated = false
	}
}

/**
 * Creates and remembers a [DisintegrationCardState] to control the disintegration animation
 * inside a [DisintegrationCard].
 *
 * @return A remembered [DisintegrationCardState] instance.
 */
@Composable
fun rememberDisintegrationCardState(): DisintegrationCardState {
	return remember { DisintegrationCardState() }
}
