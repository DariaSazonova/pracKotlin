package pr6

// n=17
class List<T>(private var list: MutableList<T> = mutableListOf()) {
    fun add(el: T): Boolean {//вставляет элемент в конец списка;
        val size = list.size
        list.add(el)
        return list.size>size
    }

    fun delete(): Boolean {//удаляет элемент из начала списка
        val size = list.size
        if(list.isNotEmpty())
            list.removeAt(0)
        return list.size<size
    }

    fun print() {//печатает последний элемент списка
        if(list.isNotEmpty())
            println(list.last())
    }
    fun eraseAll(){
        list.clear()
    }
    fun printAll() = list.forEachIndexed { index, s -> println("$index:$s")}
}


fun main() {
    val list = List<Any>()
    list.add(1)
    list.add(2)
    list.add("3")
    list.delete()
    list.print()
    list.eraseAll()
    list.printAll()
}