package hw1

class Task2 {
    companion object {
        fun calculate(elements: ArrayList<FASTQElement>): Double {
            var totalSize = 0
            var totalGC = 0

            for (element in elements) {
                totalSize += element.bases.length

                totalGC += element.bases.filter { c -> (c == 'G') or (c == 'C') }.length
            }

            return totalGC.toDouble() / totalSize * 100
        }
    }
}
