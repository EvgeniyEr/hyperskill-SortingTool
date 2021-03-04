package sorting

class ParserForLine : Parser() {
    override fun getInfo(): String {
        var line: String
        val qtyOfRepets = mutableMapOf<String, Int>()

        return if (scanner.hasNextLine()) {
            while (scanner.hasNextLine()) {
                totalReps++
                line = scanner.nextLine()
                qtyOfRepets[line] = (qtyOfRepets[line] ?: 0) + 1
            }
            val qtyOfSortedRepets = qtyOfRepets.toSortedMap(compareBy<String> { it.length }.thenBy { it })
            var longestLine = qtyOfSortedRepets.lastKey()
            occurrencePercentage = qtyOfRepets[longestLine]!! * 100 / totalReps

            "Total lines: $totalReps.\nThe longest line:\n$longestLine\n(${qtyOfRepets[longestLine]} time(s), $occurrencePercentage%)."
        } else {
            "Total lines: 0."
        }
    }
}