package structuraPatterns.adapter

interface Temperature{
    var temperature: Double
}

class CelsiusTemperature(override var temperature: Double): Temperature

class FahrenheitTemperature(var celsiusTemperature: CelsiusTemperature): Temperature{
    override var temperature: Double
        get() = convertCelsiusToFahrenheit(celsiusTemperature.temperature)
        set(value) {
            celsiusTemperature.temperature = convertFahrenheitToCelsius(value)
        }

    private fun convertCelsiusToFahrenheit(c: Double) = (c * 9/5) + 32
    private  fun convertFahrenheitToCelsius(f:Double) = (f -32)*5/9
}

fun main() {
    val celsiusTemperature = CelsiusTemperature(36.0)
    val fahrenheitTemperature = FahrenheitTemperature(celsiusTemperature)
    println("First : celsius : ${celsiusTemperature.temperature}C  : fahrenheit : ${fahrenheitTemperature.temperature}F")
    celsiusTemperature.temperature = 28.0
    println("Second : celsius : ${celsiusTemperature.temperature}C  : fahrenheit : ${fahrenheitTemperature.temperature}F")
}