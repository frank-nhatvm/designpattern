package creationalPattern.abtractFactory

interface Property {
    val name: String
    val value: Any
}

interface ServerConfiguration {
    val properties: List<Property>
}

interface Parser {
    fun property(prop: String): Property
    fun server(propertyStrings: List<String>): ServerConfiguration
}

data class IntProperty(
    override val name: String,
    override val value: Int,
) : Property

data class StringProperty(
    override val name: String,
    override val value: String,
) : Property

data class ServerConfigurationIml(override val properties: List<Property>): ServerConfiguration

class YamlParser: Parser{
    override fun property(prop: String): Property {
        TODO("Not yet implemented")
    }

    override fun server(propertyStrings: List<String>): ServerConfiguration {
        TODO("Not yet implemented")
    }
}

class JsonParser: Parser{
    override fun property(prop: String): Property {
        val (name,value) = prop.split(":")
        return when(name){
            "port" -> IntProperty(name = name, value = value.trim().toInt())
            "environment" -> StringProperty(name = name,value = value.trim())
            else -> throw Exception("")
        }
    }

    override fun server(propertyStrings: List<String>): ServerConfiguration {
        val properties = propertyStrings.map { property(it) }
        return ServerConfigurationIml(properties)
    }
}

fun main() {

}