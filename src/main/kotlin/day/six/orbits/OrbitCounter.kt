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

        if (totalOrbitsForOrbitedObject == 0) {
            orbitObjectsWithOrbitCount.add(ObjectAndOrbitCount(orbitingObject, 1))
        } else {
            orbitObjectsWithOrbitCount.add(ObjectAndOrbitCount(orbitingObject, totalOrbitsForOrbitedObject + 1))
        }
    }

    return orbitObjectsWithOrbitCount.sumBy { it.second }
}


// --------------------------------------------------------------------------------
// This solution passes tests, but is so inefficient it does not run for full input

fun orbitCounterOld(input: List<String>): Int {
    val orbitObjectsWithOrbitCount = mutableListOf(ObjectAndOrbitCount("Centre of Mass", 0))

    var counter = 1

    for (orbitMap in input) {
        val orbitedObject = orbitMap.split(")").first()
        val orbitingObject = orbitMap.split(")").last()

        val iterator = orbitObjectsWithOrbitCount.listIterator()

        // while there is another orbitObjectWithOrbitCount in the list
        while (iterator.hasNext()) {
            val objectWithOrbitCount = iterator.next()

            // check if the element in the list has a first part (a String) that is the same as the first part of the orbitMap String
            if (objectWithOrbitCount.first == orbitedObject) {
                // if so, add a new ObjectAndOrbitCount element to the list
                iterator.add(ObjectAndOrbitCount(orbitingObject, objectWithOrbitCount.second + 1))
                // instead of adding a new element can we just update the existing?
            } else {
                // otherwise also add a new ObjectAndOrbitCount, but with an orbitCount of 1
                iterator.add(ObjectAndOrbitCount(orbitingObject, 1))
            }
//            println(orbitObjectsWithOrbitCount)
        }

        counter += 1
        println("Next orbitMap $counter")
    }

    return orbitObjectsWithOrbitCount
        .sortedByDescending { it.second }
        .distinctBy { it.first }
        .sumBy { it.second }
}