package day.eight.password

fun layerWithFewestZerosIn(input: String): Int {
    val layers = input.chunked(150)
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
