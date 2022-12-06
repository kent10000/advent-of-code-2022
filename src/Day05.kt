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

    fun List<MutableList<Char>>.executeInstruction(instruction: String) {
        val actions = instruction.split(" ")

        //1,3,6
        val (count, from, to) = Triple(actions[1].toInt(), actions[3].toInt() - 1, actions[5].toInt() - 1)
        //println("$count, $from, $to")
        val chars = this[from].subList(this[from].size - count, this[from].size)
        this[to].addAll(chars.reversed())
        (0 until count).forEach { _ -> this[from].removeLast()}
        //chars.forEach{ println(it)}

    }

    fun List<MutableList<Char>>.executeNewInstruction(instruction: String) {
        val actions = instruction.split(" ")

        //1,3,6
        val (count, from, to) = Triple(actions[1].toInt(), actions[3].toInt() - 1, actions[5].toInt() - 1)
        //println("$count, $from, $to")
        val chars = this[from].subList(this[from].size - count, this[from].size)
        this[to].addAll(chars)
        (0 until count).forEach { _ -> this[from].removeLast()}
        //chars.forEach{ println(it)}

    }

    fun part1(input: List<String>): String {

        val stacks = loadStacks(input)
        val instructions = input.subList(input.indexOf(String()) + 1, input.size)
        //instructions.forEach { executeInstruction(it); return@forEach}
        for (instruction in instructions) {
            stacks.executeInstruction(instruction)
        }
        var crates = ""
        stacks.forEach { crates += it.lastOrNull() ?: " " }
        return crates
    }


    fun part2(input: List<String>): String {
        val stacks = loadStacks(input)
        val instructions = input.subList(input.indexOf(String()) + 1, input.size)
        //instructions.forEach { executeInstruction(it); return@forEach}
        for (instruction in instructions) {
            stacks.executeNewInstruction(instruction)
        }
        var crates = ""
        stacks.forEach { crates += it.lastOrNull() ?: " " }
        return crates
    }

    /* test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 1)
    */


    val input = readInput("Day05")
    println(part1(input))
    println(part2(input))
}
