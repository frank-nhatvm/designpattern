import creationalPattern.singleton.Singleton

fun main() {
    fun counter() : () -> Int {
        var i = 0
        return {i++}
    }

    val next = counter()
    println("first: ${next()}")
    println("second: ${next()}")
    println("third: ${next()}")

    val list = listOf<String>()
    java.util.ArrayList(list)
}

