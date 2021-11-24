package pr2

//Создайте функцию, которая реализует алгоритм второго задания первой
//практической работы, в которую все числа, слова или пары (в зависимости
//от варианта) передаются в аргументах функции. Например: f(123,25,222);
//f("dfd "dd "ddd"); d (Pair(2,3),Pair(3,5),Pair(4,1)).
fun countNum(vararg numbers:Int):Int{
    var res=0
    var checkNum=Array(10){0} // индекс массива - количество таких цифр в числе
    var interRes=0
    var num:Int
    var numMod:Int
    for (n in numbers){
        num=n
        while(num!=0){
            numMod=num%10
            num /= 10
            checkNum[numMod]++
        }
        for(i in checkNum ) if(i>0) interRes++
        if(interRes>9) res++
        checkNum= Array(10){0}
        interRes=0
    }
    return res
}
fun main() {
    println(countNum(1234567890, 1234567890, 1087654329, 123, 3553 ))
}