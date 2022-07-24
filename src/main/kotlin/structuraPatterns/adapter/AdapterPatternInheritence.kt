package structuraPatterns.adapter

data class  Point(val x: Int, val y : Int)

class Manipulator{
    fun animateToNewPosition(shape: Shape, newPosition: Point){

    }
}

interface Shape{
 fun boundingBox(bottomLeft: Point, topRight: Point)
 fun createManipulator(): Manipulator
}

/**
 * Adaptee
 */
abstract class TextView{
    fun getOrigin(x: Int, y: Int){

    }

    fun getExtend(width: Int, height: Int){

    }

    abstract fun isEmpty(): Boolean

}

/**
 * Adapter
 */
class  TextShape : TextView(), Shape{

    override fun boundingBox(bottomLeft: Point, topRight: Point) {
        TODO("Not yet implemented")
    }

    override fun createManipulator(): Manipulator {
        TODO("Not yet implemented")
    }

    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }
}

fun main() {
    val textShape = TextShape()
}