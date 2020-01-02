package day.six.orbits

typealias ObjectAndOrbitCount = Pair<String, Int>

fun orbitCounter(input: List<String>): Int {
//    val orbitees = input.map { it.split(")").first() }
//    val orbiters = input.map { it.split(")").last() }
//    val orbitersInOrbitees = orbitees.count { orbiters.contains(it) }
//
//    return orbiters.size + orbitersInOrbitees

    val objectsWithOrbitCount = mutableListOf(ObjectAndOrbitCount("Centre of Mass", 0))

    for (item in input) {
        val orbitee = item.split(")").first()
        val orbiter = item.split(")").last()

        val iterator = objectsWithOrbitCount.listIterator()

        while (iterator.hasNext()) {
            val objectInOrbit = iterator.next()

            if (objectInOrbit.first == orbitee) {
                iterator.add(ObjectAndOrbitCount(orbiter, objectInOrbit.second + 1))
            } else {
                iterator.add(ObjectAndOrbitCount(orbiter, 1))
            }
        }
    }

    return objectsWithOrbitCount
        .sortedByDescending { it.second }
        .distinctBy { it.first }
        .sumBy { it.second }
}
