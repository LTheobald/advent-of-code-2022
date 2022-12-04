
package day1

import java.io.File

fun main(args: Array<String>) {
    var currentTotalCalories = 0
    var totals = mutableListOf<Int>()

    File("src/main/resources/day1/input.txt").readLines().forEach{
        if (it.isNullOrBlank()) {
            totals.add(currentTotalCalories)
            currentTotalCalories = 0
        } else {
            currentTotalCalories += it.toInt()
        }
    }

    totals.sortDescending()
    println("Highest calories found: ${totals.first()}")
    println("Top three totals are: ${totals.subList(0,3).sum()}")
}