package day.one

import kotlin.math.floor

fun fuelCalculator(mass: Int): Int {
    return floor(mass.toDouble() / 3).toInt() - 2
}