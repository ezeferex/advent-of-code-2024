import kotlin.math.abs

fun main() {

    fun String.toIntPair(): Pair<Int, Int> {
        val items = this.split("   ")
        check(items.size == 2)
        return Pair(items[0].toInt(), items[1].toInt())
    }

    fun part1(input: List<String>): Int {
        val itemPairs = input.map { it.toIntPair() }
        val leftLocations = itemPairs.map { it.first }.sortedDescending()
        val rightLocations = itemPairs.map { it.second }.sortedDescending()

        return leftLocations.zip(rightLocations).sumOf { abs(it.first - it.second) }
    }

    fun part2(input: List<String>): Int {
        val (leftLocations, rightLocations) = input.map { it.toIntPair() }.unzip()
        return leftLocations.sumOf { item ->
            item * rightLocations.count { item == it }
        }
    }

    val testInput = readInput("Day01_test")
    check(part1(testInput) == 11)
    check(part2(testInput) == 31)

    val input = readInput("Day01")
    print("Result input 1: ")
    part1(input).println()
    print("Result input 2: ")
    part2(input).println()
}
