package com.vishal2376.belleza.presentation.app

import com.vishal2376.belleza.presentation.demo.flip.FlipCardDemo
import com.vishal2376.belleza.presentation.demo.lightsweep.LightSweepDemo
import com.vishal2376.belleza.presentation.demo.reflection.ReflectionCardDemo
import com.vishal2376.belleza.presentation.demo.shake.ShakeCardDemo

object BellezaRegistry {
	val demos: List<BellezaDemo> = listOf(
		ShakeCardDemo,
		LightSweepDemo,
		FlipCardDemo,
		ReflectionCardDemo
	)
}