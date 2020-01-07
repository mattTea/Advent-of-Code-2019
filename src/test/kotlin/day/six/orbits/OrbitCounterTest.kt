package day.six.orbits

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object OrbitCounterTest : Spek({
    describe("orbitCounter()") {
        it("should return count of 1 total orbit") {
            val input = listOf("A)B")

            assertThat(orbitCounter(input)).isEqualTo(1)
        }

        it("should return count of 3 total orbits") {
            val input = listOf("A)B", "B)C")

            assertThat(orbitCounter(input)).isEqualTo(3)
        }

        it("should return count of 5 total orbits") {
            val input = listOf("A)B", "B)C", "B)G")

            assertThat(orbitCounter(input)).isEqualTo(5)
        }

        it("should return count of 6 total orbits") {
            val input = listOf("A)B", "B)C", "C)D")

            assertThat(orbitCounter(input)).isEqualTo(6)
        }

        it("should return count of 5 total orbits (differently ordered orbit details)") {
            val input = listOf("B)G", "A)B", "B)C")

            assertThat(orbitCounter(input)).isEqualTo(5)
        }

        it("should return count of 42 total orbits") {
            val input = listOf(
                "A)B",
                "B)C",
                "C)D",
                "D)E",
                "E)F",
                "B)G",
                "G)H",
                "D)I",
                "E)J",
                "J)K",
                "K)L"
            )

            assertThat(orbitCounter(input)).isEqualTo(42)
        }
    }
})

/*
Part 1.
-------

If A orbits B and B orbits C, then A indirectly orbits C.
This chain can be any number of objects long...
- if A orbits B, B orbits C, and C orbits D, then A indirectly orbits D.

For the following example...

A)B
B)C
C)D
D)E
E)F
B)G
G)H
D)I
E)J
J)K
K)L

Visually, the above map of orbits looks like this:

        G - H       J - K - L
      /           /
A - B - C - D - E - F
              \
                I

we can count the total number of orbits as follows...

- D directly orbits C and indirectly orbits B and A, a total of 3 orbits.
- L directly orbits K and indirectly orbits J, E, D, C, B, and A, a total of 7 orbits.
- A orbits nothing

- The total number of direct and indirect orbits in this example is 42.

What is the total number of direct and indirect orbits in your map data?

*/