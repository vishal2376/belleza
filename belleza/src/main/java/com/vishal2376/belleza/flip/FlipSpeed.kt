package com.vishal2376.belleza.flip

@JvmInline
value class FlipSpeed(val durationMillis: Int) {
	companion object {
		val FAST = FlipSpeed(400)
		val NORMAL = FlipSpeed(600)
		val SLOW = FlipSpeed(800)
	}
}