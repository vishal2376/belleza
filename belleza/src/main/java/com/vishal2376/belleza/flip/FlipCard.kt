package com.vishal2376.belleza.flip

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.snap
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.zIndex

@Composable
fun FlipCard(
	state: FlipCardState,
	speed: FlipSpeed = FlipDefaults.speed,
	cameraDirection: FlipCameraDistance = FlipDefaults.cameraDistance,
	frontSideContent: @Composable () -> Unit,
	backSideContent: @Composable () -> Unit,
	modifier: Modifier = Modifier
) {
	val transition = updateTransition(
		targetState = state.currentSide, label = "Flip Transition"
	)

	// Front Rotation
	val frontRotation by transition.animateFloat(
		transitionSpec = {
			when {
				FlipSide.FRONT isTransitioningTo FlipSide.BACK -> {
					keyframes {
						durationMillis = speed.durationMillis
						0f at 0
						90f at speed.durationMillis / 2
						90f at speed.durationMillis
					}
				}

				FlipSide.BACK isTransitioningTo FlipSide.FRONT -> {
					keyframes {
						durationMillis = speed.durationMillis
						90f at 0
						90f at speed.durationMillis / 2
						0f at speed.durationMillis
					}
				}

				else -> snap()
			}
		}, label = "Front Rotation"
	) { currentSide ->
		when (currentSide) {
			FlipSide.FRONT -> 0f
			FlipSide.BACK -> 180f
		}
	}

	// Back Rotation
	val backRotation by transition.animateFloat(
		transitionSpec = {
			when {
				FlipSide.FRONT isTransitioningTo FlipSide.BACK -> {
					keyframes {
						durationMillis = speed.durationMillis
						(-90f) at 0
						(-90f) at speed.durationMillis / 2
						0f at speed.durationMillis
					}
				}

				FlipSide.BACK isTransitioningTo FlipSide.FRONT -> {
					keyframes {
						durationMillis = speed.durationMillis
						0f at 0
						(-90f) at speed.durationMillis / 2
						(-90f) at speed.durationMillis
					}
				}

				else -> snap()
			}
		}, label = "Back Rotation"
	) { currentSide ->
		when (currentSide) {
			FlipSide.FRONT -> 180f
			FlipSide.BACK -> 0f
		}
	}

	// Front Opacity
	val frontOpacity by transition.animateFloat(
		transitionSpec = {
			when {
				FlipSide.FRONT isTransitioningTo FlipSide.BACK -> {
					keyframes {
						durationMillis = speed.durationMillis
						1f at 0
						1f at (speed.durationMillis / 2) - 1
						0f at speed.durationMillis / 2
						0f at speed.durationMillis
					}
				}

				FlipSide.BACK isTransitioningTo FlipSide.FRONT -> {
					keyframes {
						durationMillis = speed.durationMillis
						0f at 0
						0f at (speed.durationMillis / 2) - 1
						1f at speed.durationMillis / 2
						1f at speed.durationMillis
					}
				}

				else -> snap()
			}
		}, label = "Front Opacity"
	) { currentSide ->
		when (currentSide) {
			FlipSide.FRONT -> 1f
			FlipSide.BACK -> 0f
		}
	}

	// Back Opacity
	val backOpacity by transition.animateFloat(
		transitionSpec = {
			when {
				FlipSide.FRONT isTransitioningTo FlipSide.BACK -> {
					keyframes {
						durationMillis = speed.durationMillis
						0f at 0
						0f at (speed.durationMillis / 2) - 1
						1f at speed.durationMillis / 2
						1f at speed.durationMillis
					}
				}

				FlipSide.BACK isTransitioningTo FlipSide.FRONT -> {
					keyframes {
						durationMillis = speed.durationMillis
						1f at 0
						1f at (speed.durationMillis / 2) - 1
						0f at speed.durationMillis / 2
						0f at speed.durationMillis
					}
				}

				else -> snap()
			}
		}, label = "Back Opacity"
	) { currentSide ->
		when (currentSide) {
			FlipSide.FRONT -> 0f
			FlipSide.BACK -> 1f
		}
	}


	Box(
		modifier = modifier.clickable(
			onClick = { },
			interactionSource = remember { MutableInteractionSource() },
			indication = null
		),
	) {

		Box(
			modifier = Modifier
				.graphicsLayer {
					this.cameraDistance = cameraDirection.distance
					when (state.currentDirection) {
						FlipDirection.HORIZONTAL -> rotationY = backRotation
						FlipDirection.VERTICAL -> rotationX = backRotation
					}
				}
				.alpha(backOpacity)
				.zIndex(1f - backRotation)) {
			backSideContent()
		}

		Box(
			modifier = Modifier
				.graphicsLayer {
					this.cameraDistance = cameraDirection.distance
					when (state.currentDirection) {
						FlipDirection.HORIZONTAL -> rotationY = frontRotation
						FlipDirection.VERTICAL -> rotationX = frontRotation
					}
				}
				.alpha(frontOpacity)
				.zIndex(1f - frontRotation)) {
			frontSideContent()
		}
	}
}