package behavioralPatterns.strategy

enum class Direction {
    LEFT,
    RIGHT
}

data class Position(val x: Int, val y: Int)

interface Weapon {
    fun shoot(position: Position, direction: Direction)
}

class PeaShooter : Weapon {
    override fun shoot(position: Position, direction: Direction) {
        println("PeaShooter weapon shoots x: ${position.x} y: ${position.y} in direction ${direction.name}")
    }
}

class Pomegranate : Weapon{
    override fun shoot(position: Position, direction: Direction) {
        println("Pomegranate weapon shoots x: ${position.x} y: ${position.y} in direction ${direction.name}")
    }
}

class Banana: Weapon{
    override fun shoot(position: Position, direction: Direction) {
        println("Banana weapon shoots x: ${position.x} y: ${position.y} in direction ${direction.name}")
    }
}

abstract class Hero {
    protected var currentWeapon: Weapon = PeaShooter()

    abstract fun shoot(position: Position, direction: Direction)

    fun equi(newWeapon: Weapon){
        currentWeapon = newWeapon
    }
}

class OurHero : Hero() {

    override fun shoot(position: Position, direction: Direction) {
        currentWeapon.shoot(position, direction)
    }
}

fun main() {
    val ourHero = OurHero()
    ourHero.shoot(Position(10,12), direction = Direction.LEFT)
    ourHero.equi(Banana())
    ourHero.shoot(Position(10,12), direction = Direction.RIGHT)
    ourHero.equi(Pomegranate())
    ourHero.shoot(Position(10,12), direction = Direction.LEFT)
}




