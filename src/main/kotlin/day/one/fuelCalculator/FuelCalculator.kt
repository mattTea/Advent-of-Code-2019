package day.one.fuelCalculator

import kotlin.math.floor

fun calculateFuelPerModule(mass: Int): Int {
    return floor(mass.toDouble() / 3).toInt() - 2
}

fun calculateTotalFuel(moduleValues: List<Int>): Int {
    return moduleValues.map {
        calculateFuelPerModule(it)
    }.sum()
}

fun main() {
    println(calculateTotalFuel(modules))
}
