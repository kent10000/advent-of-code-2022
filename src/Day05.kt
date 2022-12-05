fun main() {
    
    fun loadStacks(input: List<String>): List<MutableList<Char>> {

        var stacks = input.subList(0, input.indexOf(String()))
        val num = stacks.last().dropLastWhile { !it.isDigit() }.last().digitToInt()
        stacks = stacks.dropLast(1)
        val list: List<MutableList<Char>> = List(num) { mutableListOf()}

        for (line in stacks) {
            val items = line.chunked(4)
            //items.forEach { println(it) }
            for ((cursor, i) in items.withIndex()) {
                if (i.isNotBlank()) {
                    list[cursor].add(i[1])
                }
            }
        }
        list.forEach { it.reverse() }
        return list
    }

    fun executeInstruction(instruction: String) {
        val actions = instruction.split(" ")
        for (i in actions) {
            println(i)
        }
        //1,2,6
        //val (count, from, to) = Triple(actions)
    }

    fun part1(input: List<String>): Int {

        val stacks = loadStacks(input)
        var instructions = input.subList(input.indexOf(String()) + 1, input.size)
        instructions.forEach { executeInstruction(it); return@forEach}
        
        //stacks.forEach { it.forEach { print("$it ")}; println() }
        return 0
    }


    fun part2(input: List<String>): Int {
        return 0
    }

    /* test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 1)
    */


    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
