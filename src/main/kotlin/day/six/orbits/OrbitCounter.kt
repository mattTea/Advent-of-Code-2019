package day.six.orbits

typealias ObjectAndOrbitCount = Pair<String, Int>
typealias OrbitMap = Pair<String, String>

fun main() {
    println("Part 1.")
    println(orbitCounter(orbitInput))
}

fun orbitCounter(input: List<String>): Int {
    val orbitObjectsWithOrbitCount = mutableListOf(ObjectAndOrbitCount("Centre of Mass", 0))
    val previouslyMappedInputs = mutableListOf(OrbitMap("", ""))

    // take each orbit description element in input
    input.map {
        val orbitedObject = it.split(")").first()
        val orbitingObject = it.split(")").last()

        // calculate total orbits so far for the orbited object
        val totalOrbitsForOrbitedObject = orbitObjectsWithOrbitCount
            // by filtering the object with orbit count list for just those elements that are the same as the orbited object
            .filter { (key, value) ->
                key == orbitedObject
                // and then adding all the orbit counts for that object together
            }.sumBy { element ->
                element.second
            }

        // check whether any previous inputs had an orbited object the same as the current orbiting object
        val matchingOrbitedObject = previouslyMappedInputs.filter { (key, value) ->
            key == orbitingObject
        }
        // if they did, add totalOrbitsForOrbitedObject to the orbit count of whatever was orbiting that object then
        for (match in matchingOrbitedObject) {
            orbitObjectsWithOrbitCount.add(ObjectAndOrbitCount(match.second, totalOrbitsForOrbitedObject + 1))
        }

        // add this mapped input to previouslyMappedInputs
        previouslyMappedInputs.add(OrbitMap(orbitedObject, orbitingObject))

        // add an element to the list for the orbiting object with an orbit count of total orbits for the object it is orbiting +1
        orbitObjectsWithOrbitCount.add(ObjectAndOrbitCount(orbitingObject, totalOrbitsForOrbitedObject + 1))
        println(orbitObjectsWithOrbitCount)
    }

    return orbitObjectsWithOrbitCount.sumBy { it.second }
}

// look at 17J as an example -> output suggests it only has 1 orbit count, however in the input it can be seen to orbit 5BK, which in turn orbits VQJ, which orbits JX3
// maybe an ordering thing -> need to do some recursion or something to make sure further loops through the list are incorporated