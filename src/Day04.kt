import kotlin.math.abs

fun main() {

    fun part1(input: List<String>): Int {
        var count = 0
        for (line in input) {
            val parts =  line.split(Regex("[-,]"))

            val elf1 = Pair(parts.component1().toInt(), parts.component2().toInt())
            val elf2 = Pair(parts.component3().toInt(), parts.component4().toInt())

            /*val r1 = abs(elf2.second - elf1.second)
            val r2 = abs(elf2.first - elf1.first)
            println(("$r1 $r2"))*/
            //2, 0
            //7,0
            //4,4

    //4..6 and 6..6
            //9..10 2..10
            if (elf1.second == elf2.second ) {
                count++
                continue
            }
            if (elf1.second > elf2.second ) {
                if (elf1.first <= elf2.first) count++
                continue
            }
            if (elf1.first >= elf2.first) {
                count++
                continue
            }
        }
        return count
    }


    fun part2(input: List<String>): Int {
        var count = 0
        for (line in input) {
            val parts =  line.split(Regex("[-,]"))

            val elf1 = parts.component1().toInt()..parts.component2().toInt()
            val elf2 = parts.component3().toInt()..parts.component4().toInt()

            if (elf1.intersect(elf2).isNotEmpty()) count++
        }
        return count
    }

    /* test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 1)
    */


    val input = readInput("day04")
    println(part1(input))
    println(part2(input))
}
