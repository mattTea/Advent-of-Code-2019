package day.ten.asteroidDetector

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object AsteroidDetectorTest : Spek({
    describe("findBestDetectorLocation()") {
        it("should return 1, 1") {
            val asteroidField = listOf( ".", "#", ".",
                                                    ".", "#", ".",
                                                    ".", "#", ".")

            assertThat(findBestDetectorLocation(asteroidField, 3)).isEqualTo(Pair(1, 1))
        }

        it("should return 2, 2") {
            val asteroidField = listOf( ".", ".", "#", ".", ".",
                                                    ".", ".", "#", ".", ".",
                                                    ".", ".", "#", ".", ".",
                                                    ".", ".", "#", ".", ".",
                                                    ".", ".", "#", ".", ".")

            assertThat(findBestDetectorLocation(asteroidField, 3)).isEqualTo(Pair(1, 1))
        }

        it("should return 1, 0") {
            val asteroidField = listOf( "#", "#", "#",
                                                    ".", ".", ".",
                                                    ".", ".", ".")

            assertThat(findBestDetectorLocation(asteroidField, 3)).isEqualTo(Pair(1, 0))
        }
    }
})

// input is 25 x 25