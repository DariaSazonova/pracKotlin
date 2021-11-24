import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalTime

import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException


//База данных проката фильмов. Поля: дата, время, кинотеатр, фильм,
//номер зала, тип сеанса (3D/Imax/обычный).
//Функции: добавление, удаление, изменение, сортировка, поиск, вывод на экран.


// !!! добавить тип фильма

interface movieRentalInterface{
    fun add()
    fun del()
    fun print()
    fun update()
    fun sort()
    fun search()
}

data class dbElement(var date:LocalDate=LocalDate.now(),
                     var time: String="00:00",
                     var cinema:String="",
                     var film:String="",
                     var hallNum:Int=-1,
                     var typeOfSession:String="")
data class sessionVariants(var sessionTypes:List<String> = listOf("3D", "Imax", "обычный"))
// класс всяких проверок
 class checkstring{
    fun  checkEmpty (s:String):Boolean= s.isEmpty()
    fun checkDate (d:String):Boolean{
        return try {
            LocalDate.parse(d, DateTimeFormatter.ofPattern("dd.MM.yyyy"))
            true
        } catch (e: DateTimeParseException) {
            false
        }
    }
     fun checkTime(t:String):Boolean{
         val reg = Regex("""\s*(([0-1][0-9])|([2][0-3])):[0-5][0-9]\s*\n*""")
         return reg.matches(t)
     }
     fun checkNum(s:String) = s?.toIntOrNull()?.let { true } ?: false
}



 class addClass{
     val check = checkstring()
     val newElement=dbElement()
     val session=sessionVariants()
     fun addF(): dbElement {
        while(check.checkEmpty(newElement.film)){
            println("Write film name:")
            newElement.film= readLine().toString()
        }
        while (check.checkEmpty(newElement.cinema)){
            println("Write cinema name:")
            newElement.cinema= readLine().toString()
        }
        while(newElement.date== LocalDate.now()){
            println("Write date(dd.mm.yyyy):")
            val newDate = readLine().toString()
            if(check.checkDate(newDate)){
                newElement.date = LocalDate.parse(newDate, DateTimeFormatter.ofPattern("dd.MM.yyyy"))
            }
        }
        while(newElement.time== "00:00"){
            println("Write time(hh:mm)")
            val hourP= readLine().toString()
            if(check.checkTime(hourP))
                newElement.time = hourP
        }
        while (newElement.hallNum==-1){
            println("Write hallNum name:")
            val num = readLine().toString()
            if(check.checkNum(num))
            newElement.hallNum=num.toInt()
        }
         while (newElement.typeOfSession==""){
              for(i in session.sessionTypes.iterator()) println("$i")
              val s = readLine().toString().trim()
              if(s in session.sessionTypes ) newElement.typeOfSession=s
         }
        return newElement
    }
}
class printClass{
    fun print(objects:MutableList<dbElement>){
        if(objects.isEmpty()) println("DB is empty")
        else {
            for(i in objects.indices){
                println("${i + 1}. ${objects[i]}")
            }
        }
    }
}
class delClass{
    val check = checkstring()
    fun del(objects:MutableList<dbElement>){
        println("Enter number to delete")
        val number = readLine().toString()
        if(!check.checkEmpty(number)){
            if (number.toInt() in 1..objects.size) {
                objects.removeAt(number.toInt() - 1)
                println("$number deleted")
            }
            else println("Incorrect number of element!")
        }
    }
}
class movieRental(){
    private val objects:MutableList<dbElement> = mutableListOf()
    val addF = addClass()
    val print = printClass()
    val delС = delClass()
    fun add()=objects.add(addF.addF())
    fun print() = print.print(objects)
    fun del()=delС.del(objects)
    fun update() {
        TODO("Not yet implemented")
    }

    fun search() {
        TODO("Not yet implemented")
    }

    fun sort() {
        TODO("Not yet implemented")
    }
}
fun main(){
    val database=movieRental()
    var tNum=0
    while(tNum!=7) {
        println("Commands\n 1-add\n 2-print\n 3-del\n 7-exit")
        val t = readLine()
        if (t?.toIntOrNull() != null) {
            tNum = t.toInt()
            when (tNum) {
                1 -> database.add()
                2 -> database.print()
                3 -> database.del()
                7-> break
                else -> println("Command not found")
            }

        }
    }
//    val check = checkstring()
//    var s="0"
//    while(s!="7"){
//        s = readLine().toString()
//        println(check.checkDate(s))
//    }


}


