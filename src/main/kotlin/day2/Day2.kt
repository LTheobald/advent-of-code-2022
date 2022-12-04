package day2

import java.io.File

fun main(args: Array<String>) {
    var roundScore = 0
    var totalScore = 0

    File("src/main/resources/day2/input.txt").readLines().forEach{
        var opponentMove = it.first();
        var yourMove = it.get(2)

        if (opponentMove.equals('A')) {
            // Opponent: Rock
            if (yourMove.equals('X')) {
                roundScore = 3 // 3 for scissors, 0 for loss
            } else if (yourMove.equals('Y')) {
                roundScore = 4 // 1 for rock, 3 for draw
            } else {
                roundScore = 8 // 2 for paper, 6 for win
            }
        } else if (opponentMove.equals('B')) {
            // Opponent: Paper
            if (yourMove.equals('X')) {
                roundScore = 1 // 1 for rock, 0 for loss
            } else if (yourMove.equals('Y')) {
                roundScore = 5 // 2 for paper, 3 for draw
            } else {
                roundScore = 9 // 3 for scissors, 6 for win
            }
        } else if (opponentMove.equals('C')) {
            // Opponent: Scissors
            if (yourMove.equals('X')) {
                roundScore = 2 // 2 for paper, 0 for loss
            } else if (yourMove.equals('Y')) {
                roundScore = 6 // 3 for scissors, 3 for draw
            } else {
                roundScore = 7 // 1 for rock, 6 for draw
            }
        }
        totalScore += roundScore
    }

    println("Total score: $totalScore")
}