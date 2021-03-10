package sorting

class ParserForWord(sortingType: SortingType) : Parser<String>(sortingType) {

    override val addTextToInfo = "words"

    override fun readEntity(): String {
        return scanner.next()
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
}