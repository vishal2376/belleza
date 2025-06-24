package com.vishal2376.belleza.flip

@JvmInline
value class FlipCameraDistance(val distance: Float) {
	companion object {
		val FAR = FlipCameraDistance(20f)
		val NORMAL = FlipCameraDistance(15f)
		val NEAR = FlipCameraDistance(10f)
	}
}