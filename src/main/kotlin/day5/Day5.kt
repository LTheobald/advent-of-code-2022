package day4

import java.io.File
import java.util.Stack
import java.util.regex.Pattern

fun main(args: Array<String>) {

    var stackInstructions = mutableListOf<String>()
    var stacksBuilt = false
    var stacks = mutableListOf<Stack<Char>>()

    File("src/main/resources/day5/input.txt").readLines().forEach fileFE@{ it ->
        if (it.isNullOrBlank()) {
            // Blank line. End of stack building instructions
            stacksBuilt = true

            // Last line is the counts, get that out then reverse for ease of consumption
            var stackCount = stackInstructions.last().trim().split(' ').last().toInt()
            stackInstructions.removeLast()
            stackInstructions.reverse()

            // What's the cleaner way?
            for (i in 1..stackCount) {
                stacks.add(Stack())
            }

            stackInstructions.forEach{ inst ->
                // Stack layout has extra padding which makes this easier
                inst.chunked(4).forEachIndexed{ index, part ->
                    if (!part.isNullOrBlank()) {
                        // Trim & get the second char (as it should be like [X])
                        stacks.get(index).add(part.trim().get(1))
                    }
                }
            }

            println(stacks)
        } else if (!stacksBuilt) {
            stackInstructions.add(it);
        } else {
            // Movement processing
            var moveParts = it.split(' ')
            var amount = moveParts[1].toInt()
            var from = moveParts[3].toInt()
            var to = moveParts[5].toInt()

            // Part 1
            //for (i in 1..amount) {
            //    stacks.get(to-1).push(stacks.get(from-1).pop())
            //}

            // Part 2
            var temp = mutableListOf<Char>()
            for (i in 1..amount) {
                temp.add(stacks.get(from-1).pop())
            }
            temp.reverse()
            temp.forEach{ tempItem ->
                stacks.get(to-1).push(tempItem)
            }
        }
    }

    println("Answer: ")
    stacks.forEach{
        print(it.peek())
    }
}