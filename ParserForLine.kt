package sorting

import kotlin.math.round

class ParserForLine(sortingType: SortingType) : Parser<String>(sortingType) {

    override val addTextToInfo = "lines"

    override fun readEntity(): String {
        return scanner.nextLine()
    }

    override fun sortData(){
        if (sortingType == SortingType.NATURAL) {
            entitiesOfParser.sort()
        } else {
            // Sort a map by values. Within the group, elements with equal values sorted naturally.
            val comparator = compareBy<Pair<String, Int>>({ it.second }, { it.first })
            qtyOfRepets = qtyOfRepets.toList().sortedWith(comparator).toMap().toMutableMap()
        }
    }

    override fun getInfo(): String {
        val totalReps = entitiesOfParser.size
        strBuilder.append("Total lines: $totalReps.\n")
        if (sortingType == SortingType.NATURAL) {
            strBuilder.append("Sorted data:\n")
            for (line in entitiesOfParser) {
                strBuilder.append("${line}\n")
            }
        } else {
            for (repeats in qtyOfRepets) {
                occurrencePercentage = repeats.value * 100.0 / totalReps
                strBuilder.append("${repeats.key}: ${repeats.value} time(s), ${round(occurrencePercentage)}%.\n")
            }
        }
        return strBuilder.toString()
    }
}