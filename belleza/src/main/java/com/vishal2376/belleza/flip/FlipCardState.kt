package com.vishal2376.belleza.flip

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

class FlipCardState(
	flipSide: FlipSide,
	flipDirection: FlipDirection
) {
	private var flipSide by mutableStateOf(flipSide)
	private var flipDirection by mutableStateOf(flipDirection)

	val currentSide: FlipSide
		get() = flipSide

	val currentDirection: FlipDirection
		get() = flipDirection

	fun flip() {
		if (flipSide == FlipSide.FRONT) {
			flipToBack()
		} else {
			flipToFront()
		}
	}

	fun flipTo(side: FlipSide) {
		if (flipSide != side) {
			flipSide = side
		}
	}

	private fun flipToFront() {
		flipSide = FlipSide.FRONT
	}

	private fun flipToBack() {
		flipSide = FlipSide.BACK
	}
}

@Composable
fun rememberFlipCardState(
	flipSide: FlipSide = FlipDefaults.side,
	flipDirection: FlipDirection = FlipDefaults.direction,
): FlipCardState = remember {
	FlipCardState(flipSide, flipDirection)
}