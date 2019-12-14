package day.three.wires

import assertk.assertThat
import assertk.assertions.contains
import assertk.assertions.isEqualTo
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object MeasureWiresTest : Spek({
    describe("plotWire()") {
        it("should plot to a point using R instruction") {
            assertThat(plotWire("R2")).contains(Point(2, 0))
        }

        it("should plot to a point using L instruction") {
            assertThat(plotWire("L3")).contains(Point(-3, 0))
        }

        it("should plot to a point using U instruction") {
            assertThat(plotWire("U4")).contains(Point(0, 4))
        }

        it("should plot to a point using D instruction") {
            assertThat(plotWire("D15")).contains(Point(0, -15))
        }

        it("should record the 2 points that plot passes through") {
            assertThat(plotWire("R2")).isEqualTo(listOf(Point(0, 0), Point(1, 0), Point(2, 0)))
        }
    }
})

/*

1. Add together 2 coordinates
2. Draw line between 2 coordinates
    - Keep track of where started and where ended

    - record every point it goes through

3. Draw line between 3 coordinates
    - Keep track of where been?

*/