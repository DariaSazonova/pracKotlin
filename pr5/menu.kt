package pr5

class Menu (
    private val outputMessage : PrintMessage = Speaker(),
    private val outputCommands : PrintCommands = OutputCommands(),
    private val stringValidation : StringValidation = ValidateString(),
    private val intParser : IntParser = ParserToInt(),
    private val inputString : Read = InputString(),
    private val dataBase : Table = DataTable(),
    private val listCommands: List<Triple<Int, String, ExecutorCommand>>
) {
    fun run() {
        var cmdNum : Int? = 0
        while (cmdNum != null) {
            outputMessage.printMessage("Commands: \n")
            outputCommands.printCommands(listCommands.map { "${it.first + 1}. ${it.second}" })
            outputMessage.printMessage("If you want to exit  write '-1'!!!\n")
            outputMessage.printMessage("write number of command -> ")
            val cmd = inputString.readString()
            if (cmd != null) {
                if (stringValidation.check("^[1-9]+\\d*".toRegex(), cmd)) {
                    cmdNum = intParser.parseToInt(cmd) - 1
                    listCommands.firstOrNull {
                        it.first == cmdNum
                    }?.third
                        ?.execute(dataBase)
                        ?: println("\nCommand wasn't found. Try again!\n")
                } else {
                    if (stringValidation.check("-1".toRegex(), cmd)) {
                        outputMessage.printMessage("\nExit\n")
                        cmdNum = null
                    } else {
                        outputMessage.printMessage("\nCommand wasn't found. Try again!\n")
                    }
                }
            }
            else {
                outputMessage.printMessage("\nExit\n")
                cmdNum = null
            }
        }
    }
}
