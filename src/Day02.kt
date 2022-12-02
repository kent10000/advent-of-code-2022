import java.lang.Exception

fun main() {
    //rock //paper
    fun rockPaperScissors(player1: Hand, player2: Hand): Int {
        //Paper Beats Rock Beats Scissors Beats Paper
        if (player1 == player2) { return 0 } //Draw

        if (player1.value + 1 == player2.value || (player1.value == 2 && player1.value -1 == player2.value)) {
            return 1
        }
        return 2
        //paper 1 and rock 0 p
        //rock 1 paper 0
        //scissors 2 paper 
    }

    fun parseChoice(letter: String): Hand {
        return when (letter.uppercase()) {
            "A" , "X" -> Hand.Rock
            "B", "Y" -> Hand.Paper
            "C", "Z" -> Hand.Scissors
            else -> throw Exception("Invalid Gesture")
        }
    }

    fun part1(input: List<String>): Int {

        //Oponent
        //A - Rock, B - Paper, C - Scissors
        //Self
        //X - Rock 1, Y - Paper 2, Z - Scissors 3
        //Win is 6 Draw is 3 Loss is 0

        var score = 0

        input.forEach {
            val choices = it.split(" ")

            val opponentChoice = parseChoice(choices[0])
            val selfChoice = parseChoice(choices[1])

            val winner = rockPaperScissors(opponentChoice, selfChoice)
            //0 Draw, 1 Opponent, 2 Self
            score += selfChoice.score  + (winner * 3)
        }
        return score
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

enum class Hand(val value: Int, val score :Int){
    Rock(1,1),
    Paper(0,2),
    Scissors(2,3)
}
