//done
package pr3
//По данному натуральному числу n найдите наибольший факториал,
//меньший n
fun main() {
    val n = 123
    val f=(generateSequence(Pair(1,2)){ Pair(it.first*it.second,it.second+1)}.map { it.first}.takeWhile { it < n }.toList()).last()
    println(f)
}