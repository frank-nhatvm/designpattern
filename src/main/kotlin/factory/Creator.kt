package factory

abstract class Creator {
    abstract  fun create(): Product
}

class  ConcreteCreator(private  val name: String, private val price: Float) : Creator(){

    override fun create(): Product {
        return ConCreteProduct(name = name, price = price)
    }
}