package day.ten.asteroidDetector

import kotlin.math.floor

fun findBestDetectorLocation(asteroidField: List<String>, sideLength: Int): Pair<Int, Int> {
    val bestLocation = bestLocationFor(sideLength)

    // convert pair into an absolute index in list
    // -> (1, 1) is [4] for a 3x3 = floor(3x3 / 2)
    // -> (2, 2) is [12] for a 5x5


    // does an asteroid exist at bestLocation?

    return bestLocation
}

private fun bestLocationFor(sideLength: Int): Pair<Int, Int> {
    val position = floor(sideLength.toDouble() * sideLength / 2).toInt()

    return Pair(position - sideLength, position - sideLength)
}



/*

New thinking...

listOf(".", "#", ".",
       ".", "#", ".",
       ".", "#", ".")

                asteroid at (1, 0) or [1] or [x + (sideLength * y)] cannot see
                asteroid at (1, 2) or [7] or [x + (sidelength * y)]
 if there is an asteroid at (1, 1) or [4] or [x + (sidelength * y)]

other correlation here is -> if all 'x' coordinates are equal, then the 'y' coordinate that is inbetween stops others seeing each other

*/