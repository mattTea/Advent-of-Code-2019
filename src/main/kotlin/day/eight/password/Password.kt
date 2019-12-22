package day.eight.password

fun main() {
    val layerValues = encodedPassword.chunked(150)[layerWithFewestZerosIn(encodedPassword) - 1]
    val layerIntValues = layerValues.map { it.toString().toInt() }

    println(numberOf1sMultipliedByNumberOf2s(layerIntValues))
}

fun layerWithFewestZerosIn(input: String, chunkSize: Int = 150): Int {
    val layers = input.chunked(chunkSize)
    val zeroCount = mutableListOf<Int>()

    layers.map {
        zeroCount.add(
            it.toCharArray()
                .map { char -> char.toString() }
                .map { string -> string.toInt() }
                .count { element -> element == 0 }
        )
    }

    return zeroCount.indexOf(zeroCount.min()) + 1
}

fun numberOf1sMultipliedByNumberOf2s(layer: List<Int>): Int {
    val ones = layer.count { it == 1 }
    val twos = layer.count {it == 2}

    return ones * twos
}
