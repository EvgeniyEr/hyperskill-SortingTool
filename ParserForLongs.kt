package sorting

import java.util.*

class ParserForLongs(sortingType: SortingType) : Parser<Long>(sortingType) {

    override val addTextToInfo = "numbers"

    override fun readEntity(): Long {
        val next = scanner.next()
        return next.toLongOrNull() ?: throw InputMismatchException("\"$next\" is not a long. It will be skipped.")
    }

    override fun sortData() {
        if (sortingType == SortingType.NATURAL) {
            entitiesOfParser.sort()
        } else {
            // Sort a map by values. Within the group, elements with equal values sorted naturally.
            val comparator = compareBy<Pair<Long, Int>>({ it.second }, { it.first })
            qtyOfRepets = qtyOfRepets.toList().sortedWith(comparator).toMap().toMutableMap()
        }
    }
}