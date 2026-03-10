package hw1

class Task3 {
    companion object {
        fun calculate(
            elements: ArrayList<FASTQElement>,
            pos: Int = 10,
        ): Int {
            var totalSum = 0

            for (element in elements) {
                totalSum += element.quality[pos].code - 33
            }

            return totalSum / elements.size
        }
    }
}
