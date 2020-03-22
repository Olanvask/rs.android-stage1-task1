package subtask2

class MiniMaxSum {

    // TODO: Complete the following function
    fun getResult(input: IntArray): IntArray {

        val totalSum = input.sum()
        val sortedArray = input.sortedArray()
        val minimumSum = totalSum - sortedArray.last()
        val maximumSum = totalSum - sortedArray.first()
        return intArrayOf(minimumSum, maximumSum)
    }
}
