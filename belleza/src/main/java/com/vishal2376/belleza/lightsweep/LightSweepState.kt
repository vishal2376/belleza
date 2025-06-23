package com.vishal2376.belleza.lightsweep

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

class LightSweepState(
	lightSweep: Boolean
) {
	var lightSweep by mutableStateOf(lightSweep)
}

@Composable
fun rememberLightSweepState(
	lightSweep: Boolean = false
): LightSweepState = remember {
	LightSweepState(lightSweep)
}