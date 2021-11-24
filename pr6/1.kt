package pr6

//Создайте функцию, которая по данному массиву значений типа T воз-
//вращает функцию, которая при каждом вызове последовательно воз-
//вращает элементы массива, а когда элементы кончатся – null. Здесь  T – любой тип.

fun<T> returnarrel(arr:Array<T>): () -> T? {
    var n=0
    return { if (n<=arr.lastIndex) arr[n++] else null }
}
fun main() {
    val arr = arrayOf(1,"123","  ")
    val count= returnarrel(arr)
    println(count())
    println(count())
    println(count())
    println(count())
    println(count())
    println(count())
}
