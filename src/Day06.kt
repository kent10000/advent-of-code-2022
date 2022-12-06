fun main() {
    
    fun MutableList<Char>.addRemove(char: Char) {
        this.removeAt(0)
        this.add(char)
    }

    fun CharIterator.nextChars(count: Int): List<Char> {
        val list = mutableListOf<Char>()
        for (u in 0 until count) {
            list.add(this.nextChar())
        }
        return list
    }

    fun findMessageIndex(input: String, sequenceLength: Int): Int {
        val s = input.iterator()

        var char4 = s.nextChars(sequenceLength).toMutableList()
        var count = sequenceLength
        while (char4.distinct().size != sequenceLength) {
            char4.addRemove(s.nextChar())
            count++
        }
        return count
    }

    fun part1(input: List<String>): Int {
        return findMessageIndex(input.first(), 4)
        //val sections = input.first().chunked(4)
        /*for ((i, section) in sections.withIndex()) {
            if (section.toList().distinct().size != section.count()) continue
            return (i*4) + 4
        }*/

        //return 0
    }


    fun part2(input: List<String>): Int {
        return findMessageIndex(input.first(), 14)
    }

    /* test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 1)
    */
    
    val input = readInput("Day06")
    println(part1(input))
    println(part2(input))
}


