package com.vishal2376.belleza.shake

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

class ShakeCardState(
	shake: Boolean,
	shakeDirection: ShakeDirection
) {
	var shake by mutableStateOf(shake)
	var shakeDirection by mutableStateOf(shakeDirection)
}

@Composable
fun rememberShakeCardState(
	shake: Boolean = false,
	shakeDirection: ShakeDirection = ShakeDefaults.Direction
): ShakeCardState = remember {
	ShakeCardState(shake, shakeDirection)
}