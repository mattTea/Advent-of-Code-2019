package day.three.wires

typealias Point = Pair<Int, Int>

fun plotWire(start: Point, end: Point): Point {
    return start.plus(end)
}

private fun Point.plus(end: Point): Point {
    return Point(this.first + end.first, this.second + end.second)
}
