fun main() {
    fun part1(input: List<String>): Int {
        
        var increaseCount = 0
        var previousInput = input[0]
        
        for (x = 1; x < input.Count; x++;) {
            val currentInput = input[x]
            if (currentInput > previousInput) {
                increaseCount++
            }
            previousInput = currentInput
        }
        return increaseCount
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 1)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
