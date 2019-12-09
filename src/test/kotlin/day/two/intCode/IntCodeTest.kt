package day.two.intCode

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isInstanceOf
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

/*
PART 1
------
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

object IntCodeTest : Spek({
    describe("intCode()") {

        it("should return list when opCode is 99") {
            val input = listOf(99, 1, 2, 3)

            assertThat(intCode(input, 0)).isEqualTo(input)
        }

        it("should add values at 2 positions and replace in 3rd position when opCode is 1") {
            val input = listOf(1, 3, 1, 2)

            assertThat(intCode(input, 0)).isEqualTo(listOf(1, 3, 5, 2))
        }

        it("should multiply values at 2 positions and replace in 3rd position when opCode is 2") {
            val input = listOf(2, 3, 1, 2)

            assertThat(intCode(input, 0)).isEqualTo(listOf(2, 3, 6, 2))
        }
    }

    describe("runIntCodeProgram()") {
        it("should move 4 positions to calculate the next opCode") {
            val input = listOf(1, 3, 1, 2, 1, 3, 1, 6, 99)

            assertThat(runIntCodeProgram(input)).isEqualTo(listOf(1, 3, 5, 2, 1, 3, 5, 6, 99))
        }
    }

/*
PART 2
------
Determine what pair of inputs produces the output 19690720

Inputs are provided to the program by replacing the values at addresses (indexes) 1 and 2

The value placed in address 1 is called the noun, and the value placed in address 2 is called the verb. Each of the two input values will be between 0 and 99, inclusive.

Once the program has halted, its output is available at address (index) 0.
Reset the computer's memory to the values in the program (your puzzle input) each time - don't reuse memory from a previous attempt.

Find the input noun and verb that cause the program to produce the output 19690720. What is 100 * noun + verb? (For example, if noun=12 and verb=2, the answer would be 1202.)

[19690720, 49, 25...] 4900 + 25 = 4925

*/

    describe("nounAndVerbFor()") {
        val valueAtAddressZero = 19690720

        it("should return a list") {
            assertThat(nounAndVerbFor(originalPuzzleInput, valueAtAddressZero)).isInstanceOf(List::class.java)
        }

        it("should return list of size 2") {
            assertThat(nounAndVerbFor(originalPuzzleInput, valueAtAddressZero).size).isEqualTo(2)
        }
    }

})
