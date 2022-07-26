package structuraPatterns.memeto

class Manager {

    private var thoughts = mutableListOf<String>()

    fun think(thought: String) {
        thoughts.add(thought)
        if (thoughts.size > 2) {
            thoughts.removeFirst()
        }
    }

    fun saveThatThought(): Memory{
        return Memory(thoughts.toList())
    }

    fun whatDidIThought(memory: Memory){
        memory.restore()
    }

    inner class Memory(private val mindState: List<String>) {

        fun restore() {
            thoughts = mindState.toMutableList()
        }

    }

}

fun main() {
    val michael = Manager()
    with(michael){
        think("coconut")
        think("banana")
    }
    var memento = michael.saveThatThought()
    with(michael){
        think("plan")
        think("coffee")
    }
    michael.whatDidIThought(memento)
}