package day.eight.password

fun main() {
    // Part 1
    println("Part 1.")
    println("-------")
    val layerValues = encodedPassword.chunked(150)[layerWithFewestZerosIn(encodedPassword) - 1]
    val layerIntValues = listOfIntsFrom(layerValues)

    println(numberOf1sMultipliedByNumberOf2s(layerIntValues))
    println("---------------")
    println("")

    // Part 2
    println("Part 2.")
    println("-------")

    val decodedTopLayer = decode(encodedPassword)
    val topLayerByPixelWidth = decodedTopLayer.chunked(25)

    for (row in topLayerByPixelWidth) {
        println(row)
        // GCPHL
    }
}

fun decode(input: String, layerChunkSize: Int = 150): List<Int> {
    val layersWithIntValues = input.chunked(layerChunkSize).map { listOfIntsFrom(it) }

    var layerIndex = 0
    val decodedLayer = layersWithIntValues[0].toMutableList()

    while (layerIndex < layersWithIntValues.size - 1) {
        decodedLayer.forEachIndexed { index, element ->
            if (element == 2) {
                decodedLayer[index] = layersWithIntValues[layerIndex + 1][index]
            }
        }
        layerIndex += 1
    }
    return decodedLayer
}

fun layerWithFewestZerosIn(input: String, layerChunkSize: Int = 150): Int {
    val layers = input.chunked(layerChunkSize)
    val zeroCount = mutableListOf<Int>()

    layers.map {
        zeroCount.add(listOfIntsFrom(it).count { int -> int == 0 })
    }

    return zeroCount.indexOf(zeroCount.min()) + 1
}

fun numberOf1sMultipliedByNumberOf2s(layer: List<Int>): Int {
    val ones = layer.count { it == 1 }
    val twos = layer.count { it == 2 }

    return ones * twos
}

private fun listOfIntsFrom(input: String): List<Int> {
    return input.map { it.toString().toInt() }
}