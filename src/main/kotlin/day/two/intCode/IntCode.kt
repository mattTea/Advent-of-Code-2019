package day.two.intCode

val puzzleInput = listOf(1,0,0,3,1,1,2,3,1,3,4,3,1,5,0,3,2,1,13,19,1,9,19,23,1,6,23,27,2,27,9,31,2,6,31,35,1,5,35,39,1,10,39,43,1,43,13,47,1,47,9,51,1,51,9,55,1,55,9,59,2,9,59,63,2,9,63,67,1,5,67,71,2,13,71,75,1,6,75,79,1,10,79,83,2,6,83,87,1,87,5,91,1,91,9,95,1,95,10,99,2,9,99,103,1,5,103,107,1,5,107,111,2,111,10,115,1,6,115,119,2,10,119,123,1,6,123,127,1,127,5,131,2,9,131,135,1,5,135,139,1,139,10,143,1,143,2,147,1,147,5,0,99,2,0,14,0)

fun main() {
    println(runIntCodeProgram(puzzleInput))
}

fun runIntCodeProgram(input: List<Int>): List<Int> {
    var intCodeProgram = input

    for (int in 0..intCodeProgram.size step 4) {
        println(int)
        println(intCodeProgram)
        intCodeProgram = intCode(intCodeProgram, int)
    }

    return intCodeProgram
}

fun intCode(input: List<Int>, index: Int): List<Int> {
    return when (input[index]) {
        99 -> input
        1 -> opCodeOf1(input, index)
        2 -> opCodeOf2(input, index)
        else -> emptyList()
    }
}

private fun opCodeOf1(input: List<Int>, index: Int): List<Int> {
    val positionToReplace = input[index + 3]
    val replaceWith = input[input[index + 1]] + input[input[index + 2]]

    val newList = input.toMutableList()
    newList[positionToReplace] = replaceWith

    return newList
}

private fun opCodeOf2(input: List<Int>, index: Int): List<Int> {
    val positionToReplace = input[index + 3]
    val replaceWith = input[input[index + 1]] * input[input[index + 2]]

    val newList = input.toMutableList()
    newList[positionToReplace] = replaceWith

    return newList
}
