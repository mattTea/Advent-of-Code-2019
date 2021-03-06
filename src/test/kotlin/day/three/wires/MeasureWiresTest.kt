package day.three.wires

import assertk.assertThat
import assertk.assertions.contains
import assertk.assertions.isEqualTo
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object MeasureWiresTest : Spek({
    describe("plotWire()") {
        it("should plot to a point using R instruction") {
            assertThat(plotWire(listOf("R2"))).contains(Point(2, 0))
        }

        it("should plot to a point using L instruction") {
            assertThat(plotWire(listOf("L3"))).contains(Point(-3, 0))
        }

        it("should plot to a point using U instruction") {
            assertThat(plotWire(listOf("U4"))).contains(Point(0, 4))
        }

        it("should plot to a point using D instruction") {
            assertThat(plotWire(listOf("D15"))).contains(Point(0, -15))
        }

        it("should record the 2 (R) points that plot passes through") {
            assertThat(plotWire(listOf("R2"))).isEqualTo(listOf(Point(0, 0), Point(1, 0), Point(2, 0)))
        }

        it("should record the 2 (L) points that plot passes through") {
            assertThat(plotWire(listOf("L2"))).isEqualTo(listOf(Point(0, 0), Point(-1, 0), Point(-2, 0)))
        }

        it("should record the 2 (U) points that plot passes through") {
            assertThat(plotWire(listOf("U2"))).isEqualTo(listOf(Point(0, 0), Point(0, 1), Point(0, 2)))
        }

        it("should record the 2 (D) points that plot passes through") {
            assertThat(plotWire(listOf("D2"))).isEqualTo(listOf(Point(0, 0), Point(0, -1), Point(0, -2)))
        }

        it("should record points passed through for 2 instructions") {
            assertThat(plotWire(listOf("R1", "U1"))).isEqualTo(listOf(Point(0, 0), Point(1, 0), Point(1, 1)))
        }

        it("should record points passed through for 4 instructions") {
            val instructions = listOf("R2", "U3", "L2", "D1")

            val pathPoints = listOf(
                Point(0, 0),
                Point(1, 0),
                Point(2, 0),
                Point(2, 1),
                Point(2, 2),
                Point(2, 3),
                Point(1, 3),
                Point(0, 3),
                Point(0, 2)
            )

            assertThat(plotWire(instructions)).isEqualTo(pathPoints)
        }

        it("should return point where wires cross") {
            val firstWire = listOf("R1", "U2")
            val secondWire = listOf("U1", "R2")

            assertThat(closestManhattanCrossingPoint(firstWire, secondWire)).isEqualTo(Point(1, 1))
        }

        it("should return closet wire crossing point in manhattan distance") {
            val firstWire = listOf("R8", "U5", "L5", "D3")
            val secondWire = listOf("U7", "R6", "D4", "L4")

            assertThat(closestManhattanCrossingPoint(firstWire, secondWire)).isEqualTo(Point(3, 3))
        }

        it("should return closet wire crossing point in distance travelled") {
            val firstWire = listOf("R8", "U5", "L5", "D3")
            val secondWire = listOf("U7", "R6", "D4", "L4")

            assertThat(closestDistanceCrossingPoint(firstWire, secondWire)).isEqualTo(Pair(Point(6, 5), 30))
        }

        it("should return closest wire crossing point in distance travelled") {
            val firstWire = listOf("R75","D30","R83","U83","L12","D49","R71","U7","L72")
            val secondWire = listOf("U62","R66","U55","R34","D71","R55","D58","R83")

            assertThat(closestDistanceCrossingPoint(firstWire, secondWire).second).isEqualTo(610)
        }

        it("should return closest wire crossing point in distance travelled") {
            val firstWire = listOf("R98","U47","R26","D63","R33","U87","L62","D20","R33","U53","R51")
            val secondWire = listOf("U98","R91","D20","R16","D67","R40","U7","R15","U6","R7")

            assertThat(closestDistanceCrossingPoint(firstWire, secondWire).second).isEqualTo(410)
        }
    }
})
