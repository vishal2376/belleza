package com.vishal2376.belleza.disintegration

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

class DisintegrationCardState internal constructor(
	isDisintegrated: Boolean = false
) {
	var isDisintegrated by mutableStateOf(isDisintegrated)
		internal set

	fun start() {
		isDisintegrated = true
	}

	internal fun reset() {
		isDisintegrated = false
	}
}

@Composable
fun rememberDisintegrationCardState(): DisintegrationCardState {
	return remember { DisintegrationCardState() }
}
