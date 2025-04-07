package com.vishal2376.belleza.presentation.demo.shake

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.vishal2376.belleza.shake.ShakeCard
import com.vishal2376.belleza.shake.rememberShakeCardState

@Composable
fun ShakeCardDemoScreen() {
	val state = rememberShakeCardState()

	ShakeCard(
		state = state,
	) {
		Surface(
			modifier = Modifier.clickable { state.shake = !state.shake },
			color = MaterialTheme.colorScheme.primary
		) {
			Text("I'm shaking!", Modifier.padding(16.dp))
		}
	}
}