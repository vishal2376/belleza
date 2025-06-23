package com.vishal2376.belleza.presentation.demo.lightsweep

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.vishal2376.belleza.lightsweep.LightSweep
import com.vishal2376.belleza.lightsweep.rememberLightSweepState

@Composable
fun LightSweepDemoScreen() {
	val state = rememberLightSweepState()

	LightSweep(
		state = state,
		modifier = Modifier
			.clip(RoundedCornerShape(12.dp))
			.clickable(
				interactionSource = remember { MutableInteractionSource() },
				indication = null
			) {
				state.lightSweep = !state.lightSweep
			}
	) {
		Box(
			modifier = Modifier
				.size(200.dp)
				.background(MaterialTheme.colorScheme.primaryContainer),
			contentAlignment = Alignment.Center
		) {
			Text("I'm lighting up!", Modifier.padding(16.dp))
		}
	}
}