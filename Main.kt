package sorting

import java.util.*
import kotlin.math.max

fun main() {
    val scanner = Scanner(System.`in`)
    var qtyOfIntegers = 1
    var greatestNumber = scanner.next().toInt()
    var newNumber: Int
    val qtyOfRepets = mutableMapOf<Int, Int>()

    while (scanner.hasNext()) {
        newNumber = scanner.next().toInt()
        qtyOfIntegers++
        greatestNumber = max(greatestNumber, newNumber)
        qtyOfRepets[newNumber] = (qtyOfRepets[newNumber] ?: 0) + 1
    }
    println("Total numbers: $qtyOfIntegers.")
    println("The greatest number: $greatestNumber (${qtyOfRepets[greatestNumber]} time(s)).")
}