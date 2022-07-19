import factory.ConcreteCreator

fun main() {
    val product = ConcreteCreator(name = "computer", price = 18f).create()
    println(product.showInfo())
}