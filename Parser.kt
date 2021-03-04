package sorting

import java.util.*

open abstract class Parser {
    val scanner = Scanner(System.`in`)
    var totalReps: Int = 0
    var occurrencePercentage: Int = 0

    abstract fun getInfo(): String
}