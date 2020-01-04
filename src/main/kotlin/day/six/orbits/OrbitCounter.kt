package day.six.orbits

typealias ObjectAndOrbitCount = Pair<String, Int>

fun main() {
    println("Part 1.")
    println(orbitCounter(orbitInput))
}

fun orbitCounter(input: List<String>): Int {
    val orbitObjectsWithOrbitCount = mutableListOf(ObjectAndOrbitCount("Centre of Mass", 0))

    input.map {
        val orbitedObject = it.split(")").first()
        val orbitingObject = it.split(")").last()

        val totalOrbitsForOrbitedObject = orbitObjectsWithOrbitCount
            .filter { (key, value) ->
                key == orbitedObject
            }.sumBy { element ->
                element.second
            }

        orbitObjectsWithOrbitCount.add(ObjectAndOrbitCount(orbitingObject, totalOrbitsForOrbitedObject + 1))
    }

    return orbitObjectsWithOrbitCount.sumBy { it.second }
}
