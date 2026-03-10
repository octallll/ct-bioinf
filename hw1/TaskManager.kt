package hw1

fun main() {
    val elements = FASTQParser.parse(filename = "reads.fastq")

//    for (ans in Task1.calculate(elements)) {
//        print(ans)
//        print(" ")
//    }
//
//    println()

//    println(Task2.calculate(elements))

//    println(Task3.calculate(elements))

    for (ans in Task4.calculate(elements)) {
        print(ans)
        print(" ")
    }

    println()
}
