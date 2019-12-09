package day.four.secureContainer

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object PasswordTest : Spek({
    describe("decrypt()") {
        it("should return 6-digit values with equal adjacent digits") {
            val testRange = (101010..101011).toList()

            assertThat(decodePassword(testRange)).isEqualTo(listOf(101011))
        }
    }
})

/*

It is a six-digit number.
The value is within the range given in your puzzle input. -> 356261-846303
Two adjacent digits are the same (like 22 in 122345).
Going from left to right, the digits never decrease; they only ever increase or stay the same (like 111123 or 135679).
Other than the range rule, the following are true:

111111 meets these criteria (double 11, never decreases).
223450 does not meet these criteria (decreasing pair of digits 50).
123789 does not meet these criteria (no double).
How many different passwords within the range given in your puzzle input meet these criteria?


*/