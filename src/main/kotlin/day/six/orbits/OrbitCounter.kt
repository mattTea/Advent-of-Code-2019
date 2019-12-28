package day.six.orbits

fun orbitCounter(input: List<String>): Int {

    val orbitees = input.map { it.split(")").first() }
    val orbiters = input.map { it.split(")").last() }
    val orbitersInOrbitees = orbitees.count { orbiters.contains(it) }

    return orbiters.size + orbitersInOrbitees
}