package com.vishal2376.belleza.presentation.demo.reflection

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
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
import com.vishal2376.belleza.reflection.ReflectionCard
import com.vishal2376.belleza.ui.theme.lavender

@Composable
fun ReflectionCardDemoScreen() {

	Row(
		modifier = Modifier
			.fillMaxSize(),
		verticalAlignment = Alignment.CenterVertically,
		horizontalArrangement = Arrangement.SpaceEvenly
	) {
		ReflectionCard {
			Box(
				modifier = Modifier
					.size(150.dp)
					.clip(RoundedCornerShape(20.dp))
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
					text = "Reflection!",
					style = MaterialTheme.typography.titleMedium.copy(
						color = Color.White,
						fontWeight = FontWeight.Bold
					),
					modifier = Modifier.padding(20.dp)
				)
			}
		}
		ReflectionCard() {
			Box(
				modifier = Modifier
					.size(150.dp)
					.clip(RoundedCornerShape(20.dp))
					.background(
						brush = Brush.linearGradient(
							colors = listOf(Color(0xFF00C9FF), Color(0xFF92FE9D)),
							start = Offset(0f, 0f),
							end = Offset(400f, 400f)
						)
					),
				contentAlignment = Alignment.Center
			) {
				Text(
					text = "Reflection!",
					style = MaterialTheme.typography.titleMedium.copy(
						color = Color.Black,
						fontWeight = FontWeight.Bold
					),
					modifier = Modifier.padding(20.dp)
				)
			}
		}
	}
}
