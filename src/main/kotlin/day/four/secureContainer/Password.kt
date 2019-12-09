package day.four.secureContainer

val range = (356261..846303).toList()

fun main() {
    println(decodePassword(range).size)
}

internal fun decodePassword(range: List<Int>): List<Int> {
    return range.filter { code ->
        val numbers = code.toString().map { it.toString().toInt() }

        equalNeighbours(numbers) && increasingDigits(numbers)
    }
}

private fun equalNeighbours(numbers: List<Int>): Boolean {
    return ((numbers[0] == numbers[1]) && (numbers[1] != numbers[2])) ||
            ((numbers[1] == numbers[2]) && (numbers[2] != numbers[3]) && (numbers[1] != numbers[0])) ||
            ((numbers[2] == numbers[3]) && (numbers[3] != numbers[4]) && (numbers[2] != numbers[1])) ||
            ((numbers[3] == numbers[4]) && (numbers[4] != numbers[5]) && (numbers[3] != numbers[2])) ||
            ((numbers[4] == numbers[5]) && (numbers[3] != numbers[4]))
}

private fun increasingDigits(numbers: List<Int>): Boolean {
    return numbers[0] <= numbers[1] &&
            numbers[1] <= numbers[2] &&
            numbers[2] <= numbers[3] &&
            numbers[3] <= numbers[4] &&
            numbers[4] <= numbers[5]
}