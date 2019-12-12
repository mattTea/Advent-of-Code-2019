package day.three.wires

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object MeasureWiresTest : Spek({
    describe("track co-ordinates") {
        it("should add together 2 points on a grid") {
            val startingPoint = Point(0, 0)
            val finishingPoint = Point(2, 0)

            assertThat(plotWire(startingPoint, finishingPoint)).isEqualTo(Point(2, 0))
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