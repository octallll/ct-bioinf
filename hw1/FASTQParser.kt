package hw1

import java.io.File

class FASTQParser {
    companion object {
        fun parse(filename: String): ArrayList<FASTQElement> {
            val file = File(filename)

            val lines = file.readLines()

            var index = 0

            val elements = ArrayList<FASTQElement>()

            while (index < lines.size) {
                elements.add(
                    FASTQElement(
                        lines[index],
                        lines[index + 1],
                        lines[index + 2],
                        lines[index + 3],
                    ),
                )

                index += 4
            }

            return elements
        }
    }
}
