//Проверка правильности последовательности операторов присваива-
//ния, правая часть которых – выражения, в которых используются
// литералы типа «множество» со значениями перечислимого типа, пе-
//ременные и операции +, -, *.
fun main() {
    val s=arrayOf(
        "s:=[h..fghh,ddf]+[  ]+[ h ]+[f, a..l, j, f2]   ;    ",
        "s:=[..];",
        "  g  :=   ;",
        "   sed1  := []+[ ] * [,];"
    )
    val re=Regex("""\s*[A-Za-z_]+\w*\s*:=\s*(\[((\s*[A-Za-z_]+(\w*)(\.\.[A-Za-z_]+\w*)?\s*\,)*)?((\s)*[A-Za-z_]+(\w)*(\s)*(\.\.[A-Za-z_]+\w*\s*)?)?(\s*)?\]\s*[\+\-\*]*\s*)+\s*;\s*""")
    for(i in s.iterator())
        println(re.matches(i))
}


