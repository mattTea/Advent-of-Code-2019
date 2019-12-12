package day.three.wires

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object MeasureWiresTest : Spek({
    describe("plotWire()") {
        it("should plot to a point using R instruction") {
            assertThat(plotWire("R2")).isEqualTo(Point(2, 0))
        }

        it("should plot to a point using L instruction") {
            assertThat(plotWire("L3")).isEqualTo(Point(-3, 0))
        }

        it("should plot to a point using U instruction") {
            assertThat(plotWire("U4")).isEqualTo(Point(0, 4))
        }

        it("should plot to a point using D instruction") {
            assertThat(plotWire("D15")).isEqualTo(Point(0, -15))
        }
    }
})

/*

1. Add together 2 coordinates
2. Draw line between 2 coordinates
    - Keep track of where started and where ended

3. Draw line between 3 coordinates
    - Keep track of where been?

*/