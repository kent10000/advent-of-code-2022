fun main() {

    fun getElfCalories(input: List<String>): List<Int> {
        val elfCalories = mutableListOf(0)

        for (value in input) {
            if (value.isBlank()) {
                elfCalories.add(0)
                continue
            }
            elfCalories[elfCalories.size - 1] += value.toInt()
        }
        return elfCalories
    }

    fun part1(input: List<String>): Int {
        val elfCalories = getElfCalories(input)

        return elfCalories.max()
    }


    fun part2(input: List<String>): Int {
        val elfCalories = getElfCalories(input).sortedByDescending { it }
        return elfCalories.subList(0,3).sum()
    }

    /* test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 1)
    */


    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
