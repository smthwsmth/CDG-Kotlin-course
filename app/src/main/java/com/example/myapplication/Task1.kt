package com.example.myapplication
import kotlin.math.abs


fun main (args: Array<String>) {
    var matches = createArrayOfMatches()
    matches = deleteTieMatches(matches)
    matches = defineMatchesWithBiggestGap(matches)
    val setOfMatches = createSetOfMatches(matches)
}







fun createArrayOfMatches (): Array<Match?> {
    fun informMessage (matches: Array<Match?>) {
        println("STEP 1: data class Match and array of class Match's instances were created:")
        var counter = 0
        for (i in matches) {
            counter++
            println("$counter) $i")
        }
    }

    val matches: Array<Match?> = arrayOf(
        Match((0..5).random(), (0..5).random()),
        Match((0..5).random(), (0..5).random()),
        Match((0..5).random(), (0..5).random()),
        Match((0..5).random(), (0..5).random()),
        Match((0..5).random(), (0..5).random()),
        Match((0..5).random(), (0..5).random()),
        Match((0..5).random(), (0..5).random()),
        Match((0..5).random(), (0..5).random()),
        Match((0..5).random(), (0..5).random()),
        Match((0..5).random(), (0..5).random())
    )
    informMessage(matches)
    return matches
}
fun deleteTieMatches (matches: Array<Match?>): Array<Match?> {
    fun informMessage (matches: Array<Match?>) {
        println("\nSTEP 2: Tie matches were deleted. Actual array is:")
        var counter = 0
        for (i in matches) {
            counter++
            println("$counter) $i")
        }


    }
    for (i in matches) {
        if (i != null && i.firstTeamGoals == i.secondTeamGoals) {
            matches[matches.indexOf(i)] = null
        }
    }
    informMessage(matches)
    return matches
}
fun defineMatchesWithBiggestGap (matches: Array<Match?>): Array<Match?> {

    fun calculateBiggestGap (matches: Array<Match?>): Int {
        var maximum = 0
        for (i in matches) {
            if (i != null) {
                val gap = abs(i.firstTeamGoals - i.secondTeamGoals)
                if (gap > maximum) maximum = gap else continue
            }
        }
        return maximum
    }

    val maxGap = calculateBiggestGap(matches)

    for (i in matches) {
        if (i != null && abs(i.firstTeamGoals - i.secondTeamGoals) != maxGap) {
            matches[matches.indexOf(i)] = null
        }
    }
    return matches
}
fun createSetOfMatches (matches: Array<Match?>): Set<Match?> {
    fun informMessage(matches: Set<Match?>) {
        println("\nSTEP 3: Matches with the biggest gap between two commands were found, a Set was created. Actual Set is:")
        var counter = 0
        for (i in matches) {
            counter++
            println("$counter) $i")
        }
    }

    var matchesSet = matches.toSet()
    matchesSet = matchesSet.toMutableSet()
    matchesSet.remove(null)
    matchesSet = matchesSet.toSet()
    informMessage(matchesSet)
    return matchesSet
}

data class Match (val firstTeamGoals: Int, val secondTeamGoals: Int)