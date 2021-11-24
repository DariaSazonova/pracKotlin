package pr5


import java.time.LocalDate
//Table
interface Table {
    fun getList() : Iterable<DataRow>
    fun add(dataRow: DataRow)
    fun set(index : Int, dataRow: DataRow)
    fun delete(index: Int)
}

interface Column {
    val name : String
    fun add(nullableDataRow: NullableDataRow)
    fun edit(editableRow : DataRow)
    fun sort(list : List<DataRow>) : List<DataRow>
    fun search(list : List<DataRow>) : List<DataRow>
}

//Input
interface RowIndex {
    fun getIndex(message: String, listSize : Int) : Int?
}

interface InputLooper {
    fun input(message : String, regex : Regex) : String?
}

interface Read {
    fun readString() : String?
}

//Menu Commands
interface ExecutorCommand {
    fun execute(dataBase: Table)
}

//Output
interface PrintMessage {
    fun printMessage(message : String)
}

interface PrintCommands {
    fun printCommands(commands: List<String>)
}

interface PrintColumns {
    fun printColumns(columns : List<String>)
}

//Validator
interface StringValidation {
    fun check(regex : Regex, inputString : String?) : Boolean
}

//Parsers
interface IntParser {
    fun parseToInt(inputString: String) : Int
}

