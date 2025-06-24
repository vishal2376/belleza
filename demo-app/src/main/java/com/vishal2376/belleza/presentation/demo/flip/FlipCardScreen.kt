package com.vishal2376.belleza.presentation.demo.flip

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.vishal2376.belleza.flip.FlipCard
import com.vishal2376.belleza.flip.FlipDirection
import com.vishal2376.belleza.flip.FlipSpeed
import com.vishal2376.belleza.flip.rememberFlipCardState
import com.vishal2376.belleza.ui.theme.lavender

@Composable
fun FlipCardDemoScreen() {
	val state1 = rememberFlipCardState()
	val state2 = rememberFlipCardState(flipDirection = FlipDirection.VERTICAL)

	Column(
		modifier = Modifier
			.fillMaxSize(),
		horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.SpaceEvenly
	) {
		FlipCard(
			state = state1,
			frontSideContent = { FrontSideCard(state1::flip) },
			backSideContent = { BackSideCard(state1::flip) }
		)

		FlipCard(
			state = state2,
			speed = FlipSpeed.SLOW,
			frontSideContent = { FrontSideCard(state2::flip) },
			backSideContent = { BackSideCard(state2::flip) }
		)
	}
}

@Composable
fun FrontSideCard(flip: () -> Unit) {
	Box(
		modifier = Modifier
			.size(220.dp)
			.clip(RoundedCornerShape(20.dp))
			.clickable { flip() }

			.background(MaterialTheme.colorScheme.primaryContainer),
		contentAlignment = Alignment.Center
	) {
		Text(
			text = "Tap to Reveal",
			style = MaterialTheme.typography.titleMedium.copy(
				color = Color.White,
				fontWeight = FontWeight.Bold
			),
			modifier = Modifier.padding(20.dp)
		)
	}
}

@Composable
fun BackSideCard(flip: () -> Unit) {
	Box(
		modifier = Modifier
			.size(220.dp)
			.clip(RoundedCornerShape(20.dp))
			.clickable { flip() }
			.background(
				brush = Brush.linearGradient(
					colors = listOf(lavender, Color(0xFFDE5D83)),
					start = Offset(0f, 0f),
					end = Offset(400f, 400f)
				)
			),
		contentAlignment = Alignment.Center
	) {
		Text(
			text = "Surprise!",
			style = MaterialTheme.typography.titleMedium.copy(
				color = Color.White,
				fontWeight = FontWeight.Bold
			),
			modifier = Modifier.padding(20.dp)
		)
	}
}