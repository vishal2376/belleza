package com.vishal2376.belleza.reflection

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Default configuration values for reflection-based animations or UI components.
 *
 * These values define how a reflection or shine effect should appear on the component,
 * such as offset, transparency, scale, and shape. These defaults are useful for
 * consistent styling and can be overridden for customization.
 */
object ReflectionDefaults {

	/**
	 * The vertical offset (in dp) applied to the reflection element relative to the main content.
	 */
	val offset: Dp = 4.dp

	/**
	 * The alpha (transparency level) of the reflection effect.
	 * Range is from `0f` (completely transparent) to `1f` (fully opaque).
	 */
	val alpha: Float = 0.7f

	/**
	 * The scale factor applied to the reflection content.
	 * `1f` means the reflection is the same size as the original content.
	 */
	val scale: Float = 1f

	/**
	 * The shape used to clip or mask the reflection.
	 * This defines the visual boundary of the reflection area.
	 */
	val shape: Shape = RoundedCornerShape(8.dp)
}