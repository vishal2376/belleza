package com.vishal2376.belleza.neumorphism

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawOutline
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun NeumorphismCard(
	state: NeumorphismState = rememberNeumorphismState(),
	colors: NeumorphismColors = NeumorphismDefaults.colors(Color.White),
	cornerRadius: Dp = NeumorphismDefaults.cornerRadius,
	elevation: Dp = NeumorphismDefaults.elevation,
	duration: Int = NeumorphismDefaults.duration,
	modifier: Modifier = Modifier,
	content: @Composable BoxScope.() -> Unit
) {
	val animatedElevation by animateDpAsState(
		targetValue = if (state.enabled) elevation else 0.dp,
		animationSpec = tween(duration),
		label = "elevation"
	)

	val blurPx = with(LocalDensity.current) { animatedElevation.toPx() }
	val shape = RoundedCornerShape(cornerRadius)

	Box(
		modifier = modifier
			.clip(shape)
			.padding(8.dp)
			.drawBehind {
				if (blurPx > 0f) {
					val offset = blurPx / 2f
					drawIntoCanvas { canvas ->
						val paint = Paint().apply {
							color = colors.backgroundColor
							isAntiAlias = true
						}

						val outline = shape.createOutline(size, layoutDirection, this)

						paint.asFrameworkPaint()
							.setShadowLayer(blurPx, offset, offset, colors.darkShadowColor.toArgb())
						canvas.drawOutline(outline, paint)

						paint.asFrameworkPaint().setShadowLayer(
							blurPx,
							-offset,
							-offset,
							colors.lightShadowColor.toArgb()
						)
						canvas.drawOutline(outline, paint)

						paint.asFrameworkPaint()
							.setShadowLayer(0f, 0f, 0f, Color.Transparent.toArgb())
					}
				}
			}
			.background(colors.backgroundColor, shape),
		content = content
	)
}
