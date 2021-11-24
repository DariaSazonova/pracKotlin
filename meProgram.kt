import java.math.BigInteger
import java.time.LocalTime

fun calc(input: BigInteger):BigInteger{
    var factorial:BigInteger = generateSequence(Pair(1,2)){ Pair(it.first*it.second,it.second+1)}.takeWhile { (it.second-1).toBigInteger() <= input }.map{it.first}.last().toBigInteger()
    var fib = generateSequence(Triple(1.toBigInteger(),1.toBigInteger(), 2.toBigInteger())){ Triple(it.second,it.first+it.second,it.third+1.toBigInteger())}.takeWhile {it.third<=factorial}.map{it.second}.last()
    return fib
}
fun main() {
    var d="(0?[1-9]|[12]\\d|30|31)[^\\w\\d\\r\\n:](0?[1-9]|1[0-2])[^\\w\\d\\r\\n:](\\d{4}|\\d{2})".toRegex()
    var a="11.13.2021"
        //println(a.toLocalTime())
}