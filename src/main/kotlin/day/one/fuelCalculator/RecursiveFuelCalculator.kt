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


/*

a value ->

total fuel required for a module of mass 1969 is 654 + 216 + 70 + 21 + 5 = 966

firstPass = calcPerModule(moduleValue) ->  if (calcPerModule(firstPass) > 0) ->

*/