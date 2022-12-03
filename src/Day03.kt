fun main() {

    fun getPriority(letter: Char): Int {
        var code = letter.code - 96
        if (code < 0) code += 58
        return code
    }

    fun part1(input: List<String>): Int {

        var sum = 0

        for (line in input) {
            val parts = line.chunked(line.length/2) //splits into two
            val (compartment1, compartment2) = Pair(parts.component1(), parts.component2())
            val same = compartment1.toCharArray().intersect(compartment2.asIterable().toSet())

            same.forEach {
                sum += getPriority(it)
            }
        }
        return sum
    }


    fun part2(input: List<String>): Int {

        val groups = input.chunked(3)
        var sum = 0
        for (group in groups) {
            val (elf1, elf2, elf3) = Triple(group.component1(), group.component2(), group.component3())
            val same = elf1.toCharArray().intersect(elf2.asIterable().toSet()).intersect(elf3.asIterable().toSet())
            sum += getPriority(same.first())
        }
        return sum
    }

    /* test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 1)
    */


    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}
