package day.one.fuelCalculator

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object FuelCalculatorTest : Spek({
    describe("calculateFuelPerModule()") {
        it("should calculate fuel of '2' for mass of '12'") {
            assertThat(calculateFuelPerModule(12)).isEqualTo(2)
        }

        it("should calculate fuel of '654' for a mass of '1969'") {
            assertThat(calculateFuelPerModule(1969)).isEqualTo(654)
        }

        it("should calculate fuel of '33583' for a mass of '100756'") {
            assertThat(calculateFuelPerModule(100756)).isEqualTo(33583)
        }
    }

    describe("calculateTotalFuel()") {
        val moduleValues = listOf(12, 1969, 14)

        it("should add together all fuel amounts") {
            assertThat(calculateTotalFuel(moduleValues)).isEqualTo(658)
        }
    }
})