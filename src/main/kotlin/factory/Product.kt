package factory

interface Product {
    fun showInfo()
}

class ConCreteProduct constructor(private  val name: String,private val price: Float) : Product{
    override fun showInfo() {
        println("product $name : $price")
    }
}