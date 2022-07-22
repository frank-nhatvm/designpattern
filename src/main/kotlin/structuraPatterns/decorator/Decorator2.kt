package structuraPatterns.decorator

interface VisualComponent{
    fun onDraw()
}

abstract class  Decorator (protected val visualComponent: VisualComponent)  : VisualComponent by visualComponent{

}

abstract  class ScrollDecorator ( visualComponent: VisualComponent, protected var scrollPosition: Int): Decorator(visualComponent){
    abstract  fun scrollTo(position:Int)
}

abstract class  BorderDecorator(visualComponent: VisualComponent,protected val borderWidth: Int): Decorator(visualComponent){
    abstract  fun drawBorder()
}

class  TextView: VisualComponent{
    override fun onDraw() {
        println("draw a text on screen")
    }
}

class VerticalScrollDecorator (visualComponent: VisualComponent,scrollPosition: Int): ScrollDecorator(visualComponent,scrollPosition){

    override fun scrollTo(position: Int) {
        scrollPosition = position
        println("Scroll to position: $scrollPosition")
    }
}

class CornerBorderDecorator(visualComponent: VisualComponent,borderWidth: Int): BorderDecorator(visualComponent,borderWidth){
    override fun onDraw() {
        visualComponent.onDraw()
        drawBorder()
    }
    override fun drawBorder() {
        println("Draw border with width: $borderWidth")
    }
}

fun main() {
    val tvBody = TextView()
    val tvWithCornerBorderAndScrollable = VerticalScrollDecorator(CornerBorderDecorator(tvBody,0),1)
    tvWithCornerBorderAndScrollable.onDraw()
    tvWithCornerBorderAndScrollable.scrollTo(11)
}

