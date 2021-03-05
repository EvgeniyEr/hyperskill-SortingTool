package sorting

class ParserForIntegersSort : Parser() {

    override fun getInfo(): String {
        var number: Long
        val numbers = mutableListOf<Long>()

        return if (scanner.hasNext()) {
            while (scanner.hasNext()) {
                totalReps++
                number = scanner.nextLong()
                numbers.add(number)
            }
            numbers.sort()
            "Total numbers: $totalReps.\nSorted data: ${numbers.joinToString(" ")}"
        } else {
            "Total numbers: 0."
        }
    }
}