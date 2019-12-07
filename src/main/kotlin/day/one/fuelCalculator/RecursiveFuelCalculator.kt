package day.one.fuelCalculator

import kotlin.math.floor

fun recursivelyCalculateFuelPerModule(mass: Int): Int {
    var fuelRequired = floor(mass.toDouble() / 3).toInt() - 2

    if (fuelRequired > 5) {
        fuelRequired += recursivelyCalculateFuelPerModule(fuelRequired)
    } else {
        fuelRequired
    }
    return fuelRequired
}

fun recursivelyCalculateTotalFuel(moduleValues: List<Int>): Int {
    return moduleValues.map {
        recursivelyCalculateFuelPerModule(it)
    }.sum()
}

fun main() {
    println(recursivelyCalculateTotalFuel(modules))
}
