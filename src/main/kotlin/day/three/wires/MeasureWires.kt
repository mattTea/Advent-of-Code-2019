package day.three.wires

import java.security.InvalidParameterException
import kotlin.math.abs

typealias Point = Pair<Int, Int>


fun main() {
    // Part 1
    println("---- Part 1 ----")
    val manhattanCrossPoint = closestManhattanCrossingPoint(firstWireInstructions, secondWireInstructions)
    println("Nearest wire crossing to start point is: $manhattanCrossPoint")

    val manhattan = manhattanCrossPoint.first + manhattanCrossPoint.second
    println("The Manhattan distance of this point is: $manhattan")

    // Part 2
    println("---- Part 2 ----")
    val distanceCrossPoint = closestDistanceCrossingPoint(firstWireInstructions, secondWireInstructions)
    println("Nearest wire crossing point by distance travelled is: ${distanceCrossPoint.first}")
    println("The distance in steps to this point is: ${distanceCrossPoint.second}")
}

fun closestDistanceCrossingPoint(firstWireInstructions: List<String>, secondWireInstructions: List<String>): Pair<Point, Int> {
    val crossingPoints = crossingPoints(firstWireInstructions, secondWireInstructions)

    val firstWire = plotWire(firstWireInstructions).minus(Point(0, 0))
    val secondWire = plotWire(secondWireInstructions).minus(Point(0, 0))
    val pointsAndDistances = mutableListOf<Pair<Point, Int>>()

    for (point in crossingPoints) {
        val distance = (firstWire.indexOf(point) + 1) + (secondWire.indexOf(point) + 1)
        pointsAndDistances.add(Pair(point, distance))
    }

    val pointsSortedByDistance = pointsAndDistances.sortedBy { it.second }
    return pointsSortedByDistance[0]
}

fun closestManhattanCrossingPoint(firstWireInstructions: List<String>, secondWireInstructions: List<String>): Point {
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

    return path
}

private fun Point.plot(end: Point): Point {
    return Point(this.first + end.first, this.second + end.second)
}

// Convert an instruction to a co-ordinate
private fun calculatePoint(instruction: String): Point {
    return when (instruction.first()) {
        'R' -> Point(instruction.drop(1).toInt(), 0) // "R7" -> Point(7, 0)
        'L' -> Point(-instruction.drop(1).toInt(), 0)
        'U' -> Point(0, instruction.drop(1).toInt())
        'D' -> Point(0, -instruction.drop(1).toInt())
        else -> throw InvalidParameterException("Instructions must start with R, L, U or D")
    }
}

// Lists all co-ordinates that are passed on wire's path
private fun capturePath(instructions: List<String>, start: Pair<Int, Int>, end: Pair<Int, Int>): MutableList<Point> {
    val pathPoints = mutableListOf<Point>()

    for (instruction in instructions) {
        when (instruction.first()) {
            'R' -> pathPoints += rightPath(start, end)
            'L' -> pathPoints += leftPath(start, end)
            'U' -> pathPoints += upPath(start, end)
            'D' -> pathPoints += downPath(start, end)
        }
    }

    return pathPoints.distinct().toMutableList()
}

private fun rightPath(start: Pair<Int, Int>, end: Pair<Int, Int>): List<Point> {
    val path = mutableListOf<Point>()

    for (coordinate in (start.first + 1)..end.first) {
        path.add(Point(coordinate, start.second))
    }

    return path.distinct()
}

private fun leftPath(start: Pair<Int, Int>, end: Pair<Int, Int>): List<Point> {
    val path = mutableListOf<Point>()

    for (coordinate in (start.first - 1) downTo end.first) {
        path.add(Point(coordinate, start.second))
    }

    return path.distinct()
}

private fun upPath(start: Pair<Int, Int>, end: Pair<Int, Int>): List<Point> {
    val path = mutableListOf<Point>()

    for (coordinate in (start.second + 1)..end.second) {
        path.add(Point(start.first, coordinate))
    }

    return path.distinct()
}

private fun downPath(start: Pair<Int, Int>, end: Pair<Int, Int>): List<Point> {
    val path = mutableListOf<Point>()

    for (coordinate in (start.second - 1) downTo end.second) {
        path.add(Point(start.first, coordinate))
    }

    return path.distinct()
}

