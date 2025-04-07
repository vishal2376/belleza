package com.vishal2376.belleza.presentation.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vishal2376.belleza.presentation.app.BellezaRegistry
import com.vishal2376.belleza.presentation.components.BellezaScreen
import com.vishal2376.belleza.ui.theme.BellezaTheme

@Composable
fun HomeScreen(onNavigate: (String) -> Unit) {
	BellezaScreen(
		title = "🌸 Belleza (Demo App)",
		titleColor = MaterialTheme.colorScheme.primary,
		showBack = false,
	) {
		BellezaRegistry.demos.forEach { demo ->
			Button(
				onClick = { onNavigate(demo.route) },
				colors = ButtonDefaults.buttonColors(
					containerColor = MaterialTheme.colorScheme.primaryContainer,
					contentColor = MaterialTheme.colorScheme.onPrimaryContainer
				),
				shape = RoundedCornerShape(16.dp),
				modifier = Modifier
					.fillMaxWidth(.7f)
					.background(
						MaterialTheme.colorScheme.primaryContainer,
						RoundedCornerShape(16.dp)
					)
					.border(1.dp, MaterialTheme.colorScheme.primary, RoundedCornerShape(16.dp))
			) {
				Text(demo.title, color = MaterialTheme.colorScheme.onBackground)
			}
		}
	}
}

@Preview
@Composable
private fun HomeScreenPreview() {
	BellezaTheme {
		HomeScreen(onNavigate = {})
	}
}