package day3

import java.io.File
import java.util.Arrays

fun main(args: Array<String>) {
    var dupes = mutableListOf<Char>()
    var totalPriorities = 0

    var priorities = ('a'..'z').toMutableList()
    priorities.addAll(('A'..'Z'))

    File("src/main/resources/day3/input.txt").readLines().forEach fileFE@ { it ->
        var frontHalf = it.subSequence(0, it.length/2)
        var backHalf = it.subSequence(it.length/2, it.length)
        frontHalf.forEach { a ->
            if (backHalf.contains(a)) {
                dupes.add(a)
                return@fileFE
            }
        }
    }

    dupes.forEach {
        totalPriorities += priorities.indexOf(it)+1
    }

    println("Total priorities: $totalPriorities")
    totalPriorities = 0

    var group = mutableListOf<String>()
    File("src/main/resources/day3/input.txt").readLines().forEachIndexed fileFE@{ index, it ->
        group.add(it)
        if (group.size == 3) {
            priorities.forEachIndexed { i, c ->
                if (group.get(0).contains(c) && group.get(1).contains(c) && group.get(2).contains(c)) {
                    println("Duplicate is $c. $group")
                    // All three groups contain this one
                    totalPriorities += i+1
                }
            }
            group.clear()
        }
    }

    println("Grouped priorities: $totalPriorities")
}