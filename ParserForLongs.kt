package sorting

class ParserForLongs : Parser() {

    override fun getInfo(): String {
        var number: Long
        val qtyOfRepets = mutableMapOf<Long, Int>()

        return if (scanner.hasNext()) {
            while (scanner.hasNext()) {
                totalReps++
                number = scanner.nextLong()
                qtyOfRepets[number] = (qtyOfRepets[number] ?: 0) + 1
            }
            val qtyOfSortedRepets = qtyOfRepets.toSortedMap()
            var greatestNumber = qtyOfSortedRepets.lastKey()
            occurrencePercentage = qtyOfRepets[greatestNumber]!! * 100 / totalReps

            "Total numbers: $totalReps.\nThe greatest number: $greatestNumber (${qtyOfRepets[greatestNumber]} time(s), $occurrencePercentage%)."
        } else {
            "Total numbers: 0."
        }
    }
}