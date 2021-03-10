package sorting

class ParserForLongs(sortingType: SortingType) : Parser<Long>(sortingType) {

    override val addTextToInfo = "numbers"

    override fun readEntity(): Long {
        return scanner.nextLong()
    }

    override fun sortData(){
        if (sortingType == SortingType.NATURAL) {
            entitiesOfParser.sort()
        } else {
            // Sort a map by values. Within the group, elements with equal values sorted naturally.
            val comparator = compareBy<Pair<Long, Int>>({ it.second }, { it.first })
            qtyOfRepets = qtyOfRepets.toList().sortedWith(comparator).toMap().toMutableMap()
        }
    }
}