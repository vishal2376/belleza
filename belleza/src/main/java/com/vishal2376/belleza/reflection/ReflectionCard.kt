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

/**
 * A composable that renders content with a soft reflection beneath it.
 *
 * This effect mimics a mirror-like surface or a soft glow by rendering a
 * vertically flipped version of the content, typically with reduced alpha,
 * offset, and scale.
 *
 * Ideal for modern UI designs that want to add subtle visual polish
 * without being too flashy.
 *
 * ### Usage Example:
 * ```
 * ReflectionCard {
 *     Image(painter = painterResource(id = R.drawable.logo), contentDescription = null)
 * }
 * ```
 *
 * @param shape The [Shape] to clip both the original and reflected content. Defaults to [ReflectionDefaults.shape].
 * @param offset The vertical [Dp] offset to apply between the main content and its reflection. Defaults to [ReflectionDefaults.offset].
 * @param alpha The alpha (transparency) value of the reflection. Ranges from 0f (invisible) to 1f (fully opaque). Defaults to [ReflectionDefaults.alpha].
 * @param scale The scale applied to the reflection's size relative to the original content. Defaults to [ReflectionDefaults.scale].
 * @param modifier The [Modifier] to apply to the container wrapping both content and its reflection.
 * @param content The composable content that will be reflected. Typically an image, card, or text.
 */
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