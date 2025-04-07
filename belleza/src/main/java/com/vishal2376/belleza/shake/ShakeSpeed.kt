package com.vishal2376.belleza.shake

@JvmInline
value class ShakeSpeed(val durationMillis: Int) {
	companion object {
		val FAST = ShakeSpeed(50)
		val NORMAL = ShakeSpeed(100)
		val SLOW = ShakeSpeed(200)
	}
}