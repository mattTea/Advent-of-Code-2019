package day.one.fuelCalculator

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object RecursiveCalculatorTest : Spek({
    describe("calculateFuelPerModule()") {
        it("should calculate fuel of '2' for mass of '12'") {
            assertThat(recursivelyCalculateFuelPerModule(12)).isEqualTo(2)
        }

        it("should calculate fuel of '96' for mass of '216'") {
            assertThat(recursivelyCalculateFuelPerModule(216)).isEqualTo(96)
        }

        it("should calculate fuel of '966' for a mass of '1969'") {
            assertThat(recursivelyCalculateFuelPerModule(1969)).isEqualTo(966)
        }

        it("should calculate fuel of '50346' for a mass of '100756'") {
            assertThat(recursivelyCalculateFuelPerModule(100756)).isEqualTo(50346)
        }
    }

//    describe("calculateTotalFuel()") {
//        val moduleValues = listOf(12, 1969, 14)
//
//        it("should add together all fuel amounts") {
//            assertThat(recursivelyCalculateTotalFuel(moduleValues)).isEqualTo(658)
//        }
//    }
})