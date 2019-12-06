package day.one

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object FuelCalculatorTest : Spek({
    describe("fuelCalculator()") {
        it("should calculate fuel of '2' for mass of '12'") {
            assertThat(fuelCalculator(12)).isEqualTo(2)
        }

        it("should calculate fuel of '654' for a mass of '1969'") {
            assertThat(fuelCalculator(1969)).isEqualTo(654)
        }

        it("should calculate fuel of '33583' for a mass of '100756'") {
            assertThat(fuelCalculator(100756)).isEqualTo(33583)
        }
    }
})