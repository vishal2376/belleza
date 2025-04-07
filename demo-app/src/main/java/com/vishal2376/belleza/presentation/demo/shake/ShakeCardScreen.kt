package com.vishal2376.belleza.presentation.demo.shake

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vishal2376.belleza.shake.ShakeCard
import com.vishal2376.belleza.shake.rememberShakeCardState

@Preview
@Composable
fun ShakeCardDemoScreen() {
	val state = rememberShakeCardState()

	ShakeCard(
		state = state,
	) {
		Box(
			modifier = Modifier
				.clip(RoundedCornerShape(12.dp))
				.clickable { state.shake = !state.shake }
				.background(MaterialTheme.colorScheme.primaryContainer),
		) {
			Text("I'm shaking!", Modifier.padding(16.dp))
		}
	}
}