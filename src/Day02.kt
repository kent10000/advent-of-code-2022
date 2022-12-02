fun main() {
    //rock //paper
    fun rockPaperScissors(player1: Hand, player2: Hand): Int {
        //Paper Beats Rock
        //Rock Beats Scissors
        //Scissors Beat Paper
        if (player1 == player2) { return 0 } //Draw
        
        if ((player1 + 1 == player2) || (player1 == 3 && player2 != Paper)) {
            return 1
        }
        return 2
    }

    fun part1(input: List<String>): Int {

        //Oponent
        //A - Rock, B - Paper, C - Scissors 
        //Self
        //X - Rock 1, Y - Paper 2, Z - Scissors 3
        //Win is 6 Draw is 3 Loss is 0 
        



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

enum class Hand {
    Rock = 0, Paper, Scissors
}
