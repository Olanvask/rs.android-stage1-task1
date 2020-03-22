package subtask4

class StringParser {

    // TODO: Complete the following function
    fun getResult(inputString: String): Array<String> {
        var pairs = mutableListOf<Pair<Int, String>>()

        val charSetArrays = arrayOf(charArrayOf('<', '>'), charArrayOf('(', ')'), charArrayOf('[', ']'))

        for (charSetArray in charSetArrays) {
            var charPositions = mutableListOf<MutableList<Int>>()

            for (k in 0 until 2) {
                var currentCharPositions = mutableListOf<Int>()

                val pattern = "\\" + charSetArray[k]
                val matchedResults = Regex(pattern = pattern).findAll(input = inputString)
                for (matchedText in matchedResults) {
                    currentCharPositions.add(matchedText.range.first)
                }

                charPositions.add(currentCharPositions)
            }

            val firstCharPositions = charPositions[0];
            val secondCharPositions = charPositions[1];

            val firstCharPositionsCount = firstCharPositions.count()
            val secondCharPositionsCount = secondCharPositions.count()

            for (i in 0 until firstCharPositionsCount) {
                val firstIndex = firstCharPositions[i]

                var j = 0

                while (j < secondCharPositionsCount) {
                    var secondIndex = secondCharPositions[j]

                    if (firstIndex < secondIndex) {
                        val tempString = inputString.substring(firstIndex + 1, secondIndex)

                        if ((!(tempString.contains(charSetArray[0],true))) || (tempString.contains(charSetArray[1], true))) {
                            val pair = Pair<Int, String>(firstCharPositions[i],
                                tempString)
                            pairs.add(pair)
                            break
                        }
                    }

                    j++
                }
            }
        }
        val positionComparator = compareBy<Pair<Int, String>> {it.first}
        val sortedList = pairs.sortedWith(positionComparator)
        val listOfStrings = sortedList.map { it.second }

        return listOfStrings.toTypedArray()
    }
}
