package subtask3

class BillCounter {

    // TODO: Complete the following function
    // The output could be "Bon Appetit" or the string with number(e.g "10")
    fun calculateFairlySplit(bill: IntArray, k: Int, b: Int): String {

        val count = bill.count()
        if ((count > 1) && (k < count) && (k >= 0)) {
            var totalSum = bill.sum()
            totalSum = totalSum - bill[k]

            val amount: Int = totalSum / 2

            if (b == amount) {
                return "bon appetit"
            } else {
                return (b - amount).toString()
            }
        }

        return ""
    }
}
