package day.four.secureContainer

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object PasswordTest : Spek({
    describe("decrypt()") {
        it("should return values with equal adjacent digits & digits increasing left to right") {
            val testRange = (223454..223455).toList()

            assertThat(decodePassword(testRange)).isEqualTo(listOf(223455))
        }

        it("should not return values where equal adjacent digits are part of a larger group of equal digits") {
            val testRange = (123444..123445).toList()

            assertThat(decodePassword(testRange)).isEqualTo(listOf(123445))
        }
    }
})

/*
PART 1
------
It is a six-digit number.
The value is within the range given in your puzzle input. -> 356261-846303
Two adjacent digits are the same (like 22 in 122345).
Going from left to right, the digits never decrease; they only ever increase or stay the same (like 111123 or 135679).
Other than the range rule, the following are true:

111111 meets these criteria (double 11, never decreases).
223450 does not meet these criteria (decreasing pair of digits 50).
123789 does not meet these criteria (no double).
How many different passwords within the range given in your puzzle input meet these criteria?


PART 2
------
The two adjacent matching digits are not part of a larger group of matching digits

112233 meets these criteria because the digits never decrease and all repeated digits are exactly two digits long.
123444 no longer meets the criteria (the repeated 44 is part of a larger group of 444).
111122 meets the criteria (even though 1 is repeated more than twice, it still contains a double 22)
*/