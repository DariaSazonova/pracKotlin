package pr2

// tailrec-функция
tailrec fun sumtail(s:String, len:Int=(s.length-2), resI:Int=0): Int {
    return if(len>=0){
        sumtail(s,len-2,resI+s[len].code-48)
    } else resI
}
//обычная функция
fun sum(s:String):Int{
    var len = s.length-2
    var res=0
    while(len>=0){
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