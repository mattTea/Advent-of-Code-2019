package day.three.wires

typealias Point = Pair<Int, Int>

//fun plotWire(start: Point, end: Point): Point {
//    return start.plot(end)
//}

fun plotWire(instruction: String): Point {
    val start = Point(0, 0)

    return start.plot(calculatePoint(instruction))
}

private fun Point.plot(end: Point): Point {
    return Point(this.first + end.first, this.second + end.second)
}

private fun calculatePoint(instruction: String): Point {
    return if (instruction.first() == 'R') {
        Point(0, instruction.drop(1).toInt())
    } else {
        Point(0, 0)
    }
}
