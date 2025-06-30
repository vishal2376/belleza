package com.vishal2376.belleza.presentation.demo.disintegration

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.vishal2376.belleza.disintegration.DisintegrationCard
import com.vishal2376.belleza.disintegration.rememberDisintegrationCardState

@Composable
fun DisintegrationCardDemoScreen() {
	val state1 = rememberDisintegrationCardState()
	val state2 = rememberDisintegrationCardState()

	Column(
		modifier = Modifier.fillMaxSize(),
		horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.SpaceEvenly
	) {
		DisintegrationCard(
			modifier = Modifier
				.size(220.dp)
				.clickable {
					state1.start()
				},
			state = state1,
			particleColor = Color.Cyan
		) {
			Box(
				modifier = Modifier
					.fillMaxSize()
					.background(MaterialTheme.colorScheme.primaryContainer),
				contentAlignment = Alignment.Center
			) {
				Text("Explode Me 1", color = Color.White)
			}
		}

		DisintegrationCard(
			modifier = Modifier
				.size(220.dp)
				.clickable {
					state2.start()
				},
			state = state2,
			particleColor = MaterialTheme.colorScheme.primary,
			minFadeDuration = 50,
			particleSize = 3.dp,
			maxDisplacement = 150f,
			maxFadeDuration = 400,
			maxDelayMillis = 500
		) {
			Box(
				modifier = Modifier
					.fillMaxSize()
					.background(MaterialTheme.colorScheme.primaryContainer),
				contentAlignment = Alignment.Center
			) {
				Text("Explode Me 2", color = Color.White)
			}
		}
	}
}