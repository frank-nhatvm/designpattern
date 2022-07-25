package structuraPatterns.command

typealias Command = ()-> Unit

val moveGenerator = fun(trooper: Trooper, x: Int, y: Int) : Command{
    return fun() {
        trooper.move(x,y)
    }
}

class Trooper{
   private val listCommands = mutableListOf<Command>()

    fun move(x: Int, y: Int){
        println("Move to : ($x,$y)")
    }

    fun appendMove(x:Int,y: Int) = apply{
        listCommands.add(moveGenerator(this,x,y))
    }

    fun execute(){
        while (listCommands.isNotEmpty()){
            val command = listCommands.removeFirst()
            command.invoke()
        }
    }

}

fun main() {

    val trooper1 = Trooper()
    trooper1.appendMove(0,0).appendMove(20,0).appendMove(20,20).execute()

}