package structuraPatterns.composite

import structuraPatterns.bridge.Trooper

class Squad(protected val units: List<Trooper>): Trooper{

    constructor(vararg  units: Trooper): this(units.toList())

    override fun move(x: Int, y: Int) {
        TODO("Not yet implemented")
    }

    override fun attach(x: Int, y: Int) {
        TODO("Not yet implemented")
    }
}