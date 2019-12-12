package day.three.wires

typealias Point = Pair<Int, Int>

fun plotWire(instruction: String): Point {
    val start = Point(0, 0)

    return start.plot(calculatePoint(instruction))
}

private fun Point.plot(end: Point): Point {
    return Point(this.first + end.first, this.second + end.second)
}

private fun calculatePoint(instruction: String): Point {
    return when (instruction.first()) {
        'R' -> Point(instruction.drop(1).toInt(), 0)
        'L' -> Point(-instruction.drop(1).toInt(), 0)
        'U' -> Point(0, instruction.drop(1).toInt())
        'D' -> Point(0, -instruction.drop(1).toInt())
        else -> Point(0, 0)
    }
}
