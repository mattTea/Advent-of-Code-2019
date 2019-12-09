package day.four.secureContainer

val range = (356261..846303).toList()

fun decodePassword(range: List<Int>): List<Int> {
    return range.filter { code ->
        val numbers = code.toString().map { it.toString().toInt() }

        numbers[0] == numbers[1] ||
        numbers[1] == numbers[2] ||
        numbers[2] == numbers[3] ||
        numbers[3] == numbers[4] ||
        numbers[4] == numbers[5]
    }
}