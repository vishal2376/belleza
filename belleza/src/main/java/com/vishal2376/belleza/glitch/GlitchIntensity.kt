package com.vishal2376.belleza.glitch

import com.vishal2376.belleza.glitch.GlitchIntensity.Companion.High
import com.vishal2376.belleza.glitch.GlitchIntensity.Companion.Low
import com.vishal2376.belleza.glitch.GlitchIntensity.Companion.Medium

/**
 * Represents the strength of the glitch effect in terms of:
 * - number of overlay flickers
 * - pixel offset
 * - RGB layer alpha
 *
 * You can use [Low], [Medium], [High] or create your own.
 */
@JvmInline
value class GlitchIntensity(
	val value: Triple<Int, Float, Float> // count, offsetPx, alpha
) {
	val count: Int get() = value.first
	val offsetPx: Float get() = value.second
	val alpha: Float get() = value.third

	companion object {
		val Low = GlitchIntensity(Triple(2, 2f, 0.08f))
		val Medium = GlitchIntensity(Triple(4, 4f, 0.12f))
		val High = GlitchIntensity(Triple(6, 6f, 0.2f))
	}
}
