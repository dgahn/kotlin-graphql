rootProject.name = "kotlin-graphql"

include("graphql")
include("common-entity")
include("account")
include("server-launcher")
include("scene")

pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://repo.spring.io/milestone")
        maven("https://repo.spring.io/snapshot")
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id == "org.springframework.boot") {
                useModule("org.springframework.boot:spring-boot-gradle-plugin:${requested.version}")
            }
        }
    }
}
