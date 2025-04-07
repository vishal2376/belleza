package com.vishal2376.belleza.presentation.common

import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.ui.Modifier
import com.vishal2376.belleza.ui.theme.BellezaTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BellezaScreen(
	title: String,
	modifier: Modifier = Modifier,
	showBack: Boolean = false,
	onBackClick: () -> Unit = {},
	actions: @Composable () -> Unit = {},
	content: @Composable (PaddingValues) -> Unit
) {
	BellezaTheme {
		Scaffold(
			modifier = modifier,
			topBar = {
				TopAppBar(
					title = { Text(title) },
					navigationIcon = {
						if (showBack) {
							IconButton(onClick = { onBackClick() }) {
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
			},
			content = content
		)
	}
}