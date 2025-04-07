package com.vishal2376.belleza

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import com.vishal2376.belleza.presentation.navigation.AppNavigation
import com.vishal2376.belleza.ui.theme.BellezaTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
			BellezaTheme {
				Box(
					modifier = Modifier
						.fillMaxSize()
						.background(MaterialTheme.colorScheme.background)
				) {
					AppNavigation()
				}
			}
		}
	}
}