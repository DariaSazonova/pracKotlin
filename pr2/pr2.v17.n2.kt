package pr2

// В программе, сделанной в задании No1, вынесите проверяемое условие в
//отдельную single-expression функцию.
fun bol(len:Int):Boolean = len>0
fun summ(s:String):Int{
    var len = s.length-2
    var res=0
    while(bol(len)){
        res+=s[len].code-48
        len-=2
    }
    return res
}
fun main() {
    val s = readLine()
    if(s!=null){
        println(sumtail(s))
    }
    else  println("вы ничего не ввели")
}