package me.dgahn.config

data class RepositoryConfig(
    val host: String,
    val port: Int,
    val dbName: String,
    val userName: String? = null,
    val password: String? = null
) {
    val hibernateUrl: String
        get() = "jdbc:postgresql://$host:$port/$dbName"
}