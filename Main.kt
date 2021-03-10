package sorting

fun main(args: Array<String>) {
    var dataType = "word"
    var sortingType = Parser.SortingType.NATURAL

    if (args.isNotEmpty()) {
        for (i in args.indices) {
            when (args[i]) {
                "-dataType" -> dataType = args[i + 1]
                "-sortingType" -> sortingType = Parser.SortingType.findByString(args[i + 1])
            }
        }
    }
    val parser = when (dataType) {
        "long" -> ParserForLongs(sortingType)
        "line" -> ParserForLine(sortingType)
        else -> ParserForWord(sortingType)
    }
    print(parser.getInfo())
}