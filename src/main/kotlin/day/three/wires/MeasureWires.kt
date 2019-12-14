package day.three.wires

typealias Point = Pair<Int, Int>

fun plotWire(instruction: String): List<Point> {
    val start = Point(0, 0)
    val end = start.plot(calculatePoint(instruction))

    val path = mutableListOf(Point(0, 0))

    path += capturePath(instruction, start, end)

    return path.distinct()
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

private fun capturePath(instruction: String, start: Pair<Int, Int>, end: Pair<Int, Int>): MutableList<Point> {
    val pathPoints = mutableListOf(Point(0, 0))

    when (instruction.first()) {
        'R' -> pathPoints += rightPath(start, end)
        'L' -> pathPoints += leftPath(start, end)
        'U' -> pathPoints += upPath(start, end)
        'D' -> pathPoints += downPath(start, end)
    }

    return pathPoints
}

private fun rightPath(start: Pair<Int, Int>, end: Pair<Int, Int>): List<Point> {
    val path = mutableListOf(Point(0, 0))

    for (coordinate in start.first..end.first) {
        path.add(Point(coordinate, start.second))
    }

    return path.distinct()
}

private fun leftPath(start: Pair<Int, Int>, end: Pair<Int, Int>): List<Point> {
    val path = mutableListOf(Point(0, 0))

    for (coordinate in start.first downTo end.first) {
        path.add(Point(coordinate, start.second))
    }

    return path.distinct()
}

private fun upPath(start: Pair<Int, Int>, end: Pair<Int, Int>): List<Point> {
    val path = mutableListOf(Point(0, 0))

    for (coordinate in start.second..end.second) {
        path.add(Point(start.first, coordinate))
    }

    return path.distinct()
}

private fun downPath(start: Pair<Int, Int>, end: Pair<Int, Int>): List<Point> {
    val path = mutableListOf(Point(0, 0))

    for (coordinate in start.second downTo end.second) {
        path.add(Point(start.first, coordinate))
    }

    return path.distinct()
}

