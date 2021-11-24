package pr3
//Выведите на экран информацию о трех лучших студентах по сред-
//нему баллу. В случае, если у нескольких студентов средний балл сов-
//падает, то выведите большее число студентов (пока не будут выведе-
//ны все студенты или не будут полностью исчерпаны студенты с тремя
//лучшими баллами). Вывод надо осуществлять в порядке убывания
//среднего балла, а для одинаковых средних баллов – в алфавитном
//порядке по фамилии и имени.
fun main() {
    val s= listOf(Triple("f", "f", listOf<Int>(5,4,3,2) ),
                    Triple("s", "s", listOf<Int>(3,5,3,4) ),
                    Triple("t", "t", listOf<Int>(3,5,3,4) ),
                    Triple("fo", "fo", listOf<Int>(2,5,5,5)))
    println(
        s.asSequence().groupBy({it.third.average()}, {it.first+" "+it.second}) .toList().sortedByDescending { it.first }
            .take(3).map{it.second}.joinToString("\n"){it.joinToString("\n")}
    )
}
