package com.vishal2376.belleza.neumorphism

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Stable
class NeumorphismState(
	enabled: Boolean
) {
	var enabled by mutableStateOf(enabled)
}

@Composable
fun rememberNeumorphismState(enabled: Boolean = true): NeumorphismState {
	return remember { NeumorphismState(enabled) }
}
