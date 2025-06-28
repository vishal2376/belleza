package com.vishal2376.belleza.neumorphism

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import androidx.core.graphics.ColorUtils
import kotlin.math.max
import kotlin.math.min

data class NeumorphismColors(
	val backgroundColor: Color,
	val lightShadowColor: Color,
	val darkShadowColor: Color
)

object NeumorphismDefaults {

	val duration: Int = 500
	var elevation = 10.dp
	var cornerRadius = 16.dp

	fun colors(backgroundColor: Color): NeumorphismColors {
		val hsl = FloatArray(3)
		val intColor = backgroundColor.toArgb()
		ColorUtils.colorToHSL(intColor, hsl)

		val lightHsl = hsl.copyOf()
		lightHsl[2] = min(1f, hsl[2] + 0.2f)
		val lightColor = Color(ColorUtils.HSLToColor(lightHsl))

		val darkHsl = hsl.copyOf()
		darkHsl[2] = max(0f, hsl[2] - 0.2f)
		val darkColor = Color(ColorUtils.HSLToColor(darkHsl))

		return NeumorphismColors(
			backgroundColor = backgroundColor,
			lightShadowColor = lightColor,
			darkShadowColor = darkColor
		)
	}

	fun colors(
		backgroundColor: Color,
		lightShadowColor: Color,
		darkShadowColor: Color
	): NeumorphismColors {
		return NeumorphismColors(
			backgroundColor = backgroundColor,
			lightShadowColor = lightShadowColor,
			darkShadowColor = darkShadowColor
		)
	}
}