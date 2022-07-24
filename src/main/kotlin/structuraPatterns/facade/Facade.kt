package structuraPatterns

import kotlin.io.path.Path

fun startFromConfiguration(fileLocation: String){
    val path = Path(fileLocation)
    val lines = path.toFile().readLines()
}