package sorting

import java.util.*

class ParserForWord(sortingType: SortingType) : Parser<String>(sortingType) {

    override val addTextToInfo = "words"
    override val comparatorOfNaturalSorting = compareBy<String> { it }
    override val comparatorOfByCountSorting = compareBy<Pair<String, Int>>({ it.second }, { it.first })

    override fun readEntity(): String {
        return scanner.next()
    }

    override fun readEntityOfFile(line: String) {
        val delimiter = "\\s+".toRegex()
        line.split(delimiter).forEach {
            try {
                qtyOfRepets[it] = (qtyOfRepets[it] ?: 0) + 1
                entitiesOfParser.add(it)
            } catch (e: InputMismatchException) {
                println(e.message)
            }
        }
    }
}