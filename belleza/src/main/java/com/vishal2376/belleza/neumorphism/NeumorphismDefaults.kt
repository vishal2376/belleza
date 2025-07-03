package com.vishal2376.belleza.neumorphism

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import androidx.core.graphics.ColorUtils
import kotlin.math.max
import kotlin.math.min

/**
 * Represents the color configuration used for neumorphic effects.
 *
 * Includes the background color and the light and dark shadow colors used
 * to simulate soft, extruded or pressed surfaces in a 3D-like style.
 *
 * @property backgroundColor The base color of the surface.
 * @property lightShadowColor The color used for the top-left light shadow.
 * @property darkShadowColor The color used for the bottom-right dark shadow.
 */
data class NeumorphismColors(
	val backgroundColor: Color,
	val lightShadowColor: Color,
	val darkShadowColor: Color
)

/**
 * Contains default values and helper functions for configuring neumorphic UI components.
 */
object NeumorphismDefaults {

	/**
	 * The default duration (in milliseconds) for animations between neumorphism states.
	 */
	val duration: Int = 500

	/**
	 * The default elevation used to calculate shadow offsets for depth effect.
	 */
	var elevation = 10.dp

	/**
	 * The default corner radius for rounded neumorphic components.
	 */
	var cornerRadius = 16.dp

	/**
	 * Generates [NeumorphismColors] by deriving light and dark shadows from a given background color.
	 *
	 * It adjusts the lightness of the background color using HSL to create realistic shadows:
	 * - Light shadow: 20% lighter than background
	 * - Dark shadow: 20% darker than background
	 *
	 * @param backgroundColor The base background color.
	 * @return A [NeumorphismColors] instance with auto-generated shadow colors.
	 */
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

	/**
	 * Creates a [NeumorphismColors] instance using manually provided colors.
	 *
	 * Use this when you want complete control over the light/dark shadow colors,
	 * instead of relying on automatic HSL adjustments.
	 *
	 * @param backgroundColor The base background color.
	 * @param lightShadowColor The top-left shadow color (lighter).
	 * @param darkShadowColor The bottom-right shadow color (darker).
	 * @return A [NeumorphismColors] instance with the specified colors.
	 */
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