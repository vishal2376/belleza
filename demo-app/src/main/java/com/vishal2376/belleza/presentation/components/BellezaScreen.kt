package com.vishal2376.belleza.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.vishal2376.belleza.ui.theme.BellezaTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BellezaScreen(
	title: String,
	modifier: Modifier = Modifier,
	showBack: Boolean = true,
	onClickBack: () -> Unit = {},
	titleColor: Color = MaterialTheme.colorScheme.onBackground,
	actions: @Composable () -> Unit = {},
	content: @Composable () -> Unit
) {
	BellezaTheme {
		Scaffold(
			modifier = modifier,
			topBar = {
				TopAppBar(
					title = { Text(text = title, color = titleColor) },
					navigationIcon = {
						if (showBack) {
							IconButton(onClick = { onClickBack() }) {
								Icon(
									imageVector = Icons.AutoMirrored.Filled.ArrowBack,
									contentDescription = "Back"
								)
							}
						}
					},
					actions = { actions() },
					colors = TopAppBarDefaults.topAppBarColors(
						containerColor = MaterialTheme.colorScheme.background,
						titleContentColor = MaterialTheme.colorScheme.onBackground
					)
				)
			}
		) { innerPadding ->
			Box(
				modifier = Modifier
					.fillMaxSize()
					.background(MaterialTheme.colorScheme.background)
					.padding(innerPadding),
				contentAlignment = Alignment.Center
			) {
				content()
			}
		}
	}
}