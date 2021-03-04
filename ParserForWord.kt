package sorting

class ParserForWord : Parser() {
    override fun getInfo(): String {
        var word: String
        val qtyOfRepets = mutableMapOf<String, Int>()

        return if (scanner.hasNext()) {
            while (scanner.hasNext()) {
                totalReps++
                word = scanner.next()
                qtyOfRepets[word] = (qtyOfRepets[word] ?: 0) + 1
            }
            val qtyOfSortedRepets = qtyOfRepets.toSortedMap(compareBy<String> { it.length }.thenBy { it })
            var longestWord = qtyOfSortedRepets.lastKey()
            occurrencePercentage = qtyOfRepets[longestWord]!! * 100 / totalReps

            "Total words: $totalReps.\nThe longest word: $longestWord (${qtyOfRepets[longestWord]} time(s), $occurrencePercentage%)."
        } else {
            "Total words: 0."
        }
    }
}