package day.eight.password

fun main() {
    // Part 1
    println("Part 1.")
    println("---------------")
    val layerValues = encodedPassword.chunked(150)[layerWithFewestZerosIn(encodedPassword) - 1]
    val layerIntValues = listOfIntsFrom(layerValues)

    println(numberOf1sMultipliedByNumberOf2s(layerIntValues))

    // Part 2
    println("Part 2.")
    println("---------------")

}

fun decode(input: String, chunkSize: Int = 150): List<Int> {
    return listOfIntsFrom(input)
}

fun layerWithFewestZerosIn(input: String, chunkSize: Int = 150): Int {
    val layers = input.chunked(chunkSize)
    val zeroCount = mutableListOf<Int>()

    layers.map {
        zeroCount.add(listOfIntsFrom(it).count { int -> int == 0 })
    }

    return zeroCount.indexOf(zeroCount.min()) + 1
}

fun numberOf1sMultipliedByNumberOf2s(layer: List<Int>): Int {
    val ones = layer.count { it == 1 }
    val twos = layer.count {it == 2}

    return ones * twos
}

private fun listOfIntsFrom(input: String): List<Int> {
    return input.map { it.toString().toInt() }
}