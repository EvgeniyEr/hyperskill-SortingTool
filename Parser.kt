package sorting

import java.util.*
import kotlin.math.round

abstract class Parser<T>(val sortingType: SortingType) {

    protected val scanner = Scanner(System.`in`)
    protected var occurrencePercentage: Double = 0.0
    protected val strBuilder = StringBuilder()
    protected var qtyOfRepets = mutableMapOf<T, Int>()
    protected var entitiesOfParser = mutableListOf<T>()

    protected abstract val addTextToInfo: String
    protected abstract fun readEntity(): T
    protected abstract fun sortData()

    init {
        if (scanner.hasNext()) {
            readData()
            sortData()
        }
    }

    enum class SortingType(var str: String) {
        NATURAL("natural"),
        BY_COUNT("byCount"),
        NULL("");

        companion object {
            fun findByString(str: String): SortingType {
                for (enum in values()) {
                    if (str == enum.str) return enum
                }
                return NULL
            }
        }
    }

    open fun getInfo(): String {
        val totalReps = entitiesOfParser.size
        strBuilder.append("Total $addTextToInfo: $totalReps.\n")
        if (sortingType == SortingType.NATURAL) {
            strBuilder.append("Sorted data: ")
            strBuilder.append(entitiesOfParser.joinToString(" "))
        } else {
            for (repeats in qtyOfRepets) {
                occurrencePercentage = repeats.value * 100.0 / totalReps
                strBuilder.append("${repeats.key}: ${repeats.value} time(s), ${round(occurrencePercentage)}%.\n")
            }
        }
        return strBuilder.toString()
    }

    private fun readData() {
        var entity: T
        while (scanner.hasNext()) {
            entity = readEntity()
            qtyOfRepets[entity] = (qtyOfRepets[entity] ?: 0) + 1
            entitiesOfParser.add(entity)
        }
    }
}