package com.vishal2376.belleza.reflection

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.Dp

@Composable
fun ReflectionCard(
	shape: Shape = ReflectionDefaults.shape,
	offset: Dp = ReflectionDefaults.offset,
	alpha: Float = ReflectionDefaults.alpha,
	scale: Float = ReflectionDefaults.scale,
	modifier: Modifier = Modifier,
	content: @Composable () -> Unit,
) {
	Column(
		modifier = modifier,
		verticalArrangement = Arrangement.Center,
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		Box(
			modifier = Modifier
				.clip(shape)
		) {
			content()
		}

		Box(
			modifier = Modifier
				.offset(y = offset)
				.scale(1f, -scale)
				.graphicsLayer {
					this.alpha = alpha
				}
				.clip(shape)
				.drawWithContent {
					drawContent()
					drawRect(
						brush = Brush.verticalGradient(
							listOf(
								Color.Transparent,
								Color.Transparent,
								Color.White
							)
						),
						blendMode = BlendMode.DstIn
					)
				}
		) {
			content()
		}
	}
}