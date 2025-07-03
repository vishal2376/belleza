package com.vishal2376.belleza.lightsweep

@JvmInline
value class LightSweepDuration(val durationMillis: Int) {
	companion object {
		val FAST = LightSweepDuration(800)
		val NORMAL = LightSweepDuration(1000)
		val SLOW = LightSweepDuration(1200)
	}
}