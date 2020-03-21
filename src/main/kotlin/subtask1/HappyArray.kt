package subtask1

class HappyArray {

    // TODO: Complete the following function
    fun convertToHappy(sadArray: IntArray): IntArray {

        var happyArray: MutableList<Int> = sadArray.toMutableList();
        var isSadArray = true

        while (isSadArray) {

            var badIndex = -1;
            val count = happyArray.count()
            if (count > 0) {
                for (i in 1 until count - 1) {
                    if (happyArray[i - 1] + happyArray[i + 1] < happyArray[i] ) {
                        badIndex = i
                        break
                    }
                }
            }

            if (badIndex > 0) {
                happyArray.removeAt(badIndex)
            } else {
                isSadArray = false
            }
        }

        return happyArray.toIntArray()
    }
}
