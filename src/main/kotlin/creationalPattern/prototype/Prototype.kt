package creationalPattern.prototype

enum class Role {
    ADMIN,
    SUPER_ADMIN,
    REGULAR_USER
}

data class User(
    val name: String,
    val role: Role,
   private val permissions: Set<String>
) {
    fun hasPermission(permission: String) = permission in permissions
}


fun main() {
    val admin = User(name = "admin",role = Role.ADMIN, permissions = setOf("main"))

    val admin2 = admin.copy(name = "admin2")

    println("admin1: $admin admin2 : $admin2 ")
}