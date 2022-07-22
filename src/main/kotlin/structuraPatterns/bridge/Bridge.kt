package structuraPatterns.bridge

typealias Meters = Int
typealias PointsOfDamage = Long
const val RIFLE_DAMAGE: PointsOfDamage = 3L
const val REGULAR_SPEED: Meters = 1

interface Weapon{
    var damage: PointsOfDamage
    fun attach(x: Int, y: Int)
}

interface Legs{
    var speed: Meters
    fun move(x: Int,y: Int)
}

interface Trooper{
    fun move(x:Int,y:Int)
    fun attach(x:Int,y:Int)
}

data class StormTrooper(private  val weapon: Weapon, private val legs: Legs): Trooper{

    override fun move(x: Int, y: Int) {
        legs.move(x, y)
    }

    override fun attach(x: Int, y: Int) {
        weapon.attach(x, y)
    }
}

class BasicWeapon(override var damage: PointsOfDamage) : Weapon{
    override fun attach(x: Int, y: Int) {
        println("Attach position ($x,$y) with damage $damage")
    }
}

class BasicLegs(override var speed: Meters) : Legs{
    override fun move(x: Int, y: Int) {
        println("Moving to position ($x,$y) with speed $speed")
    }
}

fun main() {

    val riffle = BasicWeapon(damage = RIFLE_DAMAGE)
    val flameThrower = BasicWeapon(damage = (2* RIFLE_DAMAGE))
    val batton  = BasicWeapon(damage = (3* RIFLE_DAMAGE))

    val regularLegs  = BasicLegs(speed = REGULAR_SPEED)
    val athleticLegs = BasicLegs(speed = (2* REGULAR_SPEED))

    val stormTrooper = StormTrooper(weapon = riffle, legs = regularLegs)
    val flameTrooper = StormTrooper(weapon = flameThrower, legs = regularLegs)
    val scoutTrooper = StormTrooper(weapon = batton,athleticLegs)

    stormTrooper.move(10,10)
    flameTrooper.attach(10,10)
    flameTrooper.move(12,12)
    stormTrooper.attach(12,12)
    scoutTrooper.move(11,11)
    stormTrooper.attach(12,12)

}
