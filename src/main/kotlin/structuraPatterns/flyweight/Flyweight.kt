package structuraPatterns.flyweight

import java.io.File

object SnailSprites {
    val sprites = List(8) { i
        ->
        val path = when (i) {
            0 -> "snail-left.jpg"
            1 -> "snail-right.jbp"
            in 2..4 -> "snail-move-left-${i - 1}.jpg"
            else -> "snail-move-right${4 - i}.jpg"
        }
        File(path)
    }
}

enum class Direction {
    LEFT,
    RIGHT;
}

class TansanianSnail {
    val direction = Direction.LEFT
    val sprites = SnailSprites.sprites
}

