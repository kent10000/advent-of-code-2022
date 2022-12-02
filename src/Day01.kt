fun main() {

    fun part1(input: List<String>): Int {
       val elfCalories = mutableListOf(0)

        for (value in input) {
            if (value.isBlank()) {
                elfCalories.add(0)
                continue
            }
            elfCalories[elfCalories.size - 1] += value.toInt()
        }

        return elfCalories.max()
    }


    fun part2(input: List<String>): Int {
        return input.size
    }

    /* test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 1)
    */


    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
