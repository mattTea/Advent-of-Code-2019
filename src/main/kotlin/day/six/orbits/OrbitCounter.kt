package day.six.orbits

fun orbitCounter(input: List<String>): Int {
    val orbit = listOf(Pair(input[0].split(")").first(), input[0].split(")").last()))

    return orbit.size
}