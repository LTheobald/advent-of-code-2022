package day4

import java.io.File

fun main(args: Array<String>) {
    var totalAll = 0
    var totalAny = 0
    File("src/main/resources/day4/input.txt").readLines().forEach fileFE@{ it ->
        var firstRange: IntRange = IntRange(it.split(',').first().split('-').first().toInt(), it.split(',').first().split('-').last().toInt())
        var secondRange: IntRange = IntRange(it.split(',').last().split('-').first().toInt(), it.split(',').last().split('-').last().toInt())
        if ((firstRange.contains(secondRange.start) && firstRange.contains(secondRange.endInclusive)) || (secondRange.contains(firstRange.start) && secondRange.contains(firstRange.endInclusive))) {
            totalAll++
        }
        firstRange.forEach {
            if (secondRange.contains(it)) {
                totalAny++
                return@fileFE
            }
        }
    }
    println("Total (All): $totalAll")
    println("Total (Any): $totalAny")
}