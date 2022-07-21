package creationalPattern.singleton

object Singleton {


    private var countUser = 0

    fun increaseVisit(){
        countUser++
    }

    fun showCurrentCountUser(){
        println("The number of users visited: $countUser")
    }

}
