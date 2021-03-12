package sorting

import java.util.*

class ParserForLongs(sortingType: SortingType) : Parser<Long>(sortingType) {

    override val addTextToInfo = "numbers"
    override val comparatorOfNaturalSorting = compareBy<Long> { it.toString().toLong() }
    override val comparatorOfByCountSorting = compareBy<Pair<Long, Int>>({ it.second }, { it.first })

    override fun readEntity(): Long {
        val next = scanner.next()
        return next.toLongOrNull() ?: throw InputMismatchException("\"$next\" is not a long. It will be skipped.")
    }

    override fun readEntityOfFile(line: String) {
        var entity: Long
        line.split(" ").forEach {
            try {
                entity = it.toLongOrNull() ?: throw InputMismatchException("\"$it\" is not a long. It will be skipped.")
                qtyOfRepets[entity] = (qtyOfRepets[entity] ?: 0) + 1
                entitiesOfParser.add(entity)
            } catch (e: InputMismatchException) {
                println(e.message)
            }
        }
    }
}