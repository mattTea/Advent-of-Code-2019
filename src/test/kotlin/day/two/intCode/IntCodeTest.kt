package day.two.intCode

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object IntCodeTest : Spek({
    describe("intCode()") {
        val input = listOf(99, 1, 2, 3)

        it("should return list when position 0 is 99") {
            assertThat(intCode(input)).isEqualTo(input)
        }
    }
})


/*

An Intcode program is a list of integers separated by commas (like 1,0,0,3,99)

To run one, start by looking at the first integer (called position 0).
Here, you will find an opcode - either 1, 2, or 99.
The opcode indicates what to do

99 means that the program is finished and should immediately halt

1 adds together numbers read from two positions and stores the result in a third position
- The three integers immediately after the opcode tell you these three positions
- the first two indicate the positions from which you should read the input values
- the third indicates the position at which the output should be stored

2 works exactly like 1, except it multiplies the two inputs

Once you're done processing an opcode, move to the next one by stepping forward 4 positions in list

Once you have a working computer, before running the program, replace position 1 with the value 12 and replace position 2 with the value 2.
What value is left at position 0 after the program halts?

Encountering an unknown opcode means something went wrong.

*/