package com.vishal2376.belleza.flip

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

/**
 * A state holder for controlling the flip behavior of a card component.
 *
 * This class keeps track of the current visible side of the card ([FlipSide]) and the
 * flip direction ([FlipDirection]). It provides methods to toggle or set the visible side.
 *
 * Use [rememberFlipCardState] to create and retain this state across recompositions.
 *
 * @param flipSide The initial side of the card that should be visible.
 * @param flipDirection The direction in which the card should flip.
 */
class FlipCardState(
	flipSide: FlipSide,
	flipDirection: FlipDirection
) {
	private var flipSide by mutableStateOf(flipSide)
	private var flipDirection by mutableStateOf(flipDirection)

	/**
	 * The currently visible side of the card.
	 */
	val currentSide: FlipSide
		get() = flipSide

	/**
	 * The direction in which the card should flip.
	 */
	val currentDirection: FlipDirection
		get() = flipDirection

	/**
	 * Flips the card to the opposite side.
	 * If the front is currently visible, flips to back, and vice versa.
	 */
	fun flip() {
		if (flipSide == FlipSide.FRONT) {
			flipToBack()
		} else {
			flipToFront()
		}
	}

	/**
	 * Flips the card to the specified [side], if it's not already showing.
	 *
	 * @param side The target side to flip to.
	 */
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

/**
 * Creates and remembers a [FlipCardState], used to control the flipping behavior of a card.
 *
 * This should be used in a composable scope and passed to a `FlipCard` or equivalent component.
 *
 * @param flipSide The initial visible side of the card. Defaults to [FlipDefaults.side].
 * @param flipDirection The direction the card should flip. Defaults to [FlipDefaults.direction].
 * @return A remembered instance of [FlipCardState].
 */
@Composable
fun rememberFlipCardState(
	flipSide: FlipSide = FlipDefaults.side,
	flipDirection: FlipDirection = FlipDefaults.direction,
): FlipCardState = remember {
	FlipCardState(flipSide, flipDirection)
}
