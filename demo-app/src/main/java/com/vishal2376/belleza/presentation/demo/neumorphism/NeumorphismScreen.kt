package com.vishal2376.belleza.presentation.demo.neumorphism

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.vishal2376.belleza.neumorphism.NeumorphismCard
import com.vishal2376.belleza.neumorphism.NeumorphismDefaults
import com.vishal2376.belleza.neumorphism.rememberNeumorphismState
import com.vishal2376.belleza.ui.theme.black
import com.vishal2376.belleza.ui.theme.white

@Composable
fun NeumorphismDemoScreen() {

	val state1 = rememberNeumorphismState()
	val state2 = rememberNeumorphismState()

	val lightBgColor = Color(0xFFE3E3E3)
	val darkBgColor = Color(0xFF2A2A2A)

	Column(
		modifier = Modifier.fillMaxSize(),
		verticalArrangement = Arrangement.SpaceEvenly,
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		Box(
			modifier = Modifier
				.fillMaxWidth()
				.weight(0.5f)
				.background(darkBgColor)
				.padding(32.dp),
			contentAlignment = Alignment.Center
		) {
			NeumorphismCard(
				state = state2,
				colors = NeumorphismDefaults.colors(backgroundColor = darkBgColor),
				modifier = Modifier.clickable(
					interactionSource = remember { MutableInteractionSource() },
					indication = null
				) {
					state2.enabled = !state2.enabled
				}
			) {
				Text(
					"Dark Theme",
					modifier = Modifier
						.padding(24.dp),
					color = Color.White
				)
			}
		}

		Box(
			modifier = Modifier
				.fillMaxWidth()
				.weight(0.5f)
				.background(lightBgColor)
				.padding(32.dp),
			contentAlignment = Alignment.Center
		) {
			NeumorphismCard(
				state = state1,
				colors = NeumorphismDefaults.colors(backgroundColor = lightBgColor),
				modifier = Modifier.clickable(
					interactionSource = remember { MutableInteractionSource() },
					indication = null
				) {
					state1.enabled = !state1.enabled
				}
			) {
				Text(
					"Light Theme",
					modifier = Modifier
						.padding(24.dp),
					color = Color.DarkGray
				)
			}
		}
	}
}