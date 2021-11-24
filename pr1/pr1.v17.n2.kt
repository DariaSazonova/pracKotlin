//В строке указано несколько неотрицательных целых чисел, разделен-
//ных пробелами (по одному пробелу между числами). В каком коли-
//честве чисел присутствуют все цифры от 0 до 9?
fun main() {
    val s = readLine()
    if(s!=null){
        var res=0
        var checkNum=Array(10){0} // индекс массива - количество таких цифр в числе
        var interRes=0
        var count=0;
        for (n in s){
            count++
            if(n==' ' || count==s.length){
                if(count==s.length) checkNum[n.code-48]++
                for(i in checkNum ) if(i>0) interRes++
                if(interRes>9) res++
                checkNum= Array(10){0}
                interRes=0
            }
            else {
                checkNum[n.code-48]++
            }
        }
        println("результат: $res")
    }
    else { println("вы ничего не ввели ")}
}