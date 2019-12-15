package day.three.wires

import kotlin.math.abs

typealias Point = Pair<Int, Int>

// Part 1
fun main() {
    val crossPoint = closestCrossingPoint(firstWireInstructions, secondWireInstructions)
    println("Nearest wire crossing to start point is: $crossPoint")

    val manhattan = crossPoint.first + crossPoint.second
    println("The Manhattan distance of this point is: $manhattan")
}

// Part 2


fun closestCrossingPoint(firstWireInstructions: List<String>, secondWireInstructions: List<String>): Point {
    val crossingPoints = crossingPoints(firstWireInstructions, secondWireInstructions)

    val measures = crossingPoints.mapIndexed { index, point ->
        Pair(abs(point.first) + abs(point.second), index)
    }.sortedBy { it.first }

    return crossingPoints[measures[0].second]
}

fun crossingPoints(firstWireInstructions: List<String>, secondWireInstructions: List<String>): List<Point> {
    val firstWire = plotWire(firstWireInstructions).minus(Point(0, 0))
    val secondWire = plotWire(secondWireInstructions).minus(Point(0, 0))

    return firstWire.intersect(secondWire).toList()
}

fun plotWire(instructions: List<String>): List<Point> {
    var start = Point(0, 0)
    lateinit var end: Point

    val path = mutableListOf(Point(0, 0))

    for (instruction in instructions) {
        end = start.plot(calculatePoint(instruction))
        path += capturePath(instructions, start, end)
        start = end
    }

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

private fun capturePath(instructions: List<String>, start: Pair<Int, Int>, end: Pair<Int, Int>): MutableList<Point> {
    val pathPoints = mutableListOf(Point(0, 0))

    for (instruction in instructions) {
        when (instruction.first()) {
            'R' -> pathPoints += rightPath(start, end)
            'L' -> pathPoints += leftPath(start, end)
            'U' -> pathPoints += upPath(start, end)
            'D' -> pathPoints += downPath(start, end)
        }
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

