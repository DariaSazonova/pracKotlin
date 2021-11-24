//сумма цифр, стоящих на четных позициях в числе (если нумеровать
//цифры с конца): для числа 1234 ответ 4
fun main() {
    val s = readLine()
    if(s!=null){
        var len = s.length-2
        var res=0
        while(len>=0){
            res+=s[len].code-48
            len-=2
        }
        println(res)
    }
    else {
        println("вы ничего не ввели")
    }
}