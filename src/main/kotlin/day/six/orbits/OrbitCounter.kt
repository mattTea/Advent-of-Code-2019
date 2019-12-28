package day.six.orbits

fun orbitCounter(input: List<String>): Int {
    val orbiters = input.map { it.split(")").last() }

    return orbiters.size
}