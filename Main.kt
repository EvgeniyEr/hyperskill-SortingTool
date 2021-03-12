package sorting

import java.io.File

fun main(args: Array<String>) {
    var nameInputFile = ""
    var nameOutputFile = ""
    var dataType = "word"
    var sortingType = Parser.SortingType.NATURAL

    if (args.isNotEmpty()) {
        for (i in args.indices) {
            when (args[i]) {
                "-inputFile" -> {
                    try {
                        nameInputFile = args[i + 1]
                    } catch (e: ArrayIndexOutOfBoundsException) {
                        println("No input file defined!")
                        return
                    }
                }
                "-outputFile" -> {
                    try {
                        nameOutputFile = args[i + 1]
                    } catch (e: ArrayIndexOutOfBoundsException) {
                        println("No output file defined!")
                        return
                    }
                }
                "-dataType" -> {
                    try {
                        dataType = args[i + 1]
                    } catch (e: ArrayIndexOutOfBoundsException) {
                        println("No data type defined!")
                        return
                    }
                }
                "-sortingType" -> {
                    try {
                        sortingType = Parser.SortingType.findByString(args[i + 1])
                    } catch (e: ArrayIndexOutOfBoundsException) {
                        println("No sorting type defined!")
                        return
                    }
                }
                else -> {
                    val arg = args[i]
                    if (args[i].matches(Regex("-\\w+"))) {
                        println("\"$arg\" is not a valid parameter. It will be skipped.")

                    }
                }
            }
        }
    }
    val parser = when (dataType) {
        "long" -> ParserForLongs(sortingType)
        "line" -> ParserForLine(sortingType)
        else -> ParserForWord(sortingType)
    }

    val info = parser.readData(nameInputFile).getInfo()
    if (nameOutputFile.isNotEmpty()) {
        File(nameOutputFile).writeText(info)
    } else {
        print(info)
    }
}