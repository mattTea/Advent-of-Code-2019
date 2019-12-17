package day.eight.password

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object PasswordTest : Spek({
    describe("layerWithfewestZerosIn()") {
        it("should return number of zeros in first layer") {
            val input = "112340123401234012340123401234012340123401234012340123401234012340123401234012340123401234012340123401234012340123401234012340123401234012340123401234"

            assertThat(layerWithFewestZerosIn(input)).isEqualTo(1)
        }
    }
})

/*

Decode the BIOS password - the puzzle input is the encoded password.

The images of the password is sent as a series of digits that each represent the color of a single pixel.

The digits fill each row of the image left-to-right, then move downward to the next row,
filling rows top-to-bottom until every pixel of the image is filled.

Each image actually consists of a series of identically-sized layers that are filled in this way.

- The first digit corresponds to the top-left pixel of the first layer
- The second digit corresponds to the pixel to the right of that on the same layer
- And so on until the last digit, which corresponds to the bottom-right pixel of the last layer.

For example, given an image 3 pixels wide and 2 pixels tall, the image data 123456789012 corresponds to the following image layers:

Layer 1: 123
         456

Layer 2: 789
         012

The image you received is 25 pixels wide and 6 pixels tall.

Puzzle input is 15000 chars long
Therefore has 100 layers

1. find the layer that contains the fewest 0 digits.
2. On that layer, what is the number of 1 digits multiplied by the number of 2 digits?

*/