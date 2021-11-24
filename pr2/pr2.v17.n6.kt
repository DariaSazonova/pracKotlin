package pr2

//Создайте функцию, которая по данному массиву целых чисел возвра-
//щает функцию, которая при каждом вызове последовательно возвра-
//щает элементы массива, а когда элементы кончатся – null.
fun returnarrel(arr:Array<Int>): () -> Int? {
    var n=0
    return { if (n<=arr.lastIndex) arr[n++] else null }
}
fun main() {
    val arr = arrayOf(1,2,3)
    val count= returnarrel(arr)
    println(count())
    println(count())
    println(count())
    println(count())
}