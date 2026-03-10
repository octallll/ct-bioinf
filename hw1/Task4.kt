package hw1

import kotlin.math.max
import kotlin.math.min
import kotlin.math.round

class Task4 {
    companion object {
        private const val SHIFT = 33

        fun get(c: Char): Int = c.code - SHIFT

        fun calculate(
            elements: ArrayList<FASTQElement>,
            windowSize: Int = 5,
            needQuality: Int = 30,
            needSize: Int = 60,
        ): ArrayList<Int> {
            var trimCount = 0
            var restCount = 0

            var maxSize = Int.MIN_VALUE
            var minSize = Int.MAX_VALUE
            var sumSize = 0
            var needSizeIn = 0

            for (element in elements) {
                val quality = element.quality
                val originalLen = element.bases.length
                val quals = quality.map { get(it) }.toIntArray()

                if (quals.size < windowSize) {
                    trimCount++
                    continue
                }

                var total = 0
                for (i in 0 until windowSize) {
                    total += quals[i]
                }

                val requiredTotal = needQuality * windowSize

                if (total < requiredTotal) {
                    trimCount++
                    continue
                }

                var lengthToKeep = quals.size

                for (i in 0 until quals.size - windowSize) {
                    total = total - quals[i] + quals[i + windowSize]
                    if (total < requiredTotal) {
                        lengthToKeep = i + windowSize
                        break
                    }
                }

                var i = lengthToKeep

                while (i > 1 && quals[i - 1] < needQuality) {
                    i--
                }

                if (i < 1) {
                    trimCount++
                    continue
                }

                val newSize = i
                restCount++

                maxSize = max(maxSize, newSize)
                minSize = min(minSize, newSize)
                sumSize += newSize

                if (newSize >= needSize) {
                    needSizeIn++
                }
            }

            return arrayListOf(trimCount, minSize, round(sumSize.toDouble() / restCount).toInt(), maxSize, needSizeIn)
        }
    }
}
