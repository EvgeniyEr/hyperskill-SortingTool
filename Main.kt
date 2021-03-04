package sorting

fun main(args: Array<String>) {
    val parser: Parser = if (args.isNotEmpty()) {
        val parseType = args[1]
        FactoryParser.create(parseType)
    } else {
        FactoryParser.create()
    }
    print(parser.getInfo())
}

object FactoryParser {
    fun create(type: String = "word"): Parser {
        return when (type) {
            "long" -> ParserForLongs()
            "line" -> ParserForLine()
            else -> ParserForWord()
        }
    }
}