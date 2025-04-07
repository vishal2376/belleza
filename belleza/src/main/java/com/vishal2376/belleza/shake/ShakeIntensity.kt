package com.vishal2376.belleza.shake

@JvmInline
value class ShakeIntensity(val offset: Float) {
	companion object {
		val LOW = ShakeIntensity(2f)
		val MEDIUM = ShakeIntensity(6f)
		val HIGH = ShakeIntensity(12f)
	}
}