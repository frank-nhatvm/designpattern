import factory.ConcreteCreator
import singleton.Singleton

fun main() {
    Singleton.increaseVisit()
    Singleton.showCurrentCountUser()
    Singleton.increaseVisit()
    Singleton.showCurrentCountUser()
}