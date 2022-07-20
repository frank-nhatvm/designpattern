package structuraPatterns.decorator

interface StarTrekRepository{
    fun getCaptain(starShipName: String): String
    fun addCaptain(starShipName: String, captainName:String)
}

class DefaultStarTrekRepository : StarTrekRepository{
    private  val starShipCaptain = mutableMapOf("USS Enter prise " to "Luka Mora")

    override fun getCaptain(starShipName: String): String {
        return starShipCaptain[starShipName] ?: "Unknown"
    }

    override fun addCaptain(starShipName: String, captainName: String) {
        starShipCaptain[starShipName] = captainName
    }
}

class  LoggingGetCaptain(private val repository: StarTrekRepository) : StarTrekRepository by repository{
    override fun getCaptain(starShipName: String): String {
        println("Getting captain for $starShipName")
        return repository.getCaptain(starShipName)
    }
}

class ValidatingAdd(private val repository: StarTrekRepository): StarTrekRepository by repository{
    private val maxNameLength = 15
    override fun addCaptain(starShipName: String, captainName: String) {
        require(captainName.length < maxNameLength){
            "$captainName name is longer than $maxNameLength characters!"
        }
        repository.addCaptain(starShipName, captainName)
    }
}

fun main() {
    val defaultStarTrekRepository = DefaultStarTrekRepository()
    val loggingRepository = LoggingGetCaptain(defaultStarTrekRepository)
    val validateCaptainRepository = ValidatingAdd(defaultStarTrekRepository)
    val loggingAndValidateRepository = LoggingGetCaptain(validateCaptainRepository) // ValidatingAdd(loggingRepository)

}