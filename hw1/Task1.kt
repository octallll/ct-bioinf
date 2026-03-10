package hw1

import kotlin.math.max
import kotlin.math.min
import kotlin.math.round

class Task1 {
    companion object {
        fun calculate(elements: ArrayList<FASTQElement>): Array<Int> {
            val allCount = elements.size

            var minSize = Int.MAX_VALUE
            var maxSize = Int.MIN_VALUE

            var sumSize = 0

            for (element in elements) {
                minSize = min(minSize, element.bases.length)
                maxSize = max(maxSize, element.bases.length)

                sumSize += element.bases.length
            }

            var middleSize = round(sumSize.toDouble() / allCount).toInt()

            return arrayOf(allCount, minSize, middleSize, maxSize)
        }
    }
}
