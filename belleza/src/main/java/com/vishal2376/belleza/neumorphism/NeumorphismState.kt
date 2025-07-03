package com.vishal2376.belleza.neumorphism

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

/**
 * Holds the state for a neumorphic UI component, controlling whether
 * the component should appear pressed/flat or raised.
 *
 * This state can be toggled dynamically to animate between active and inactive visual states.
 *
 * @param enabled Whether the neumorphic elevation is enabled. If false, the component appears pressed.
 */
@Stable
class NeumorphismState(
	enabled: Boolean
) {
	/**
	 * Whether the neumorphic elevation is enabled.
	 * When `true`, the component appears raised with shadows.
	 * When `false`, the component appears pressed or flat.
	 */
	var enabled by mutableStateOf(enabled)
}

/**
 * Remembers and returns a [NeumorphismState] to control a neumorphic component's state.
 *
 * This state can be toggled (e.g., via user interaction) to change the visual appearance
 * of the component — typically animating between raised and pressed styles.
 *
 * @param enabled The initial enabled state of the neumorphic effect. Defaults to `true`.
 * @return A remembered [NeumorphismState] instance.
 */
@Composable
fun rememberNeumorphismState(enabled: Boolean = true): NeumorphismState {
	return remember { NeumorphismState(enabled) }
}
