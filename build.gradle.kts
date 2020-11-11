plugins {
    kotlin(KotlinPlugin.jvm) version KotlinVersion.kotlin
    kotlin(KotlinPlugin.spring) version KotlinVersion.kotlin

    id(SpringPlugin.boot) version SpringVersion.boot
    id(SpringPlugin.dependencyManagement) version SpringVersion.dependencyManagement

    id(GrpcPlugin.protobuf) version GrpcVersion.protobuf apply false
}

subprojects {
    apply(plugin = KotlinPlugin.kotlin)
    group = "me.dgahn"
    version = "0.1.0"

    repositories {
        mavenLocal()
        mavenCentral()
        maven("https://repo.spring.io/milestone")
        maven("https://repo.spring.io/snapshot")
    }

    tasks {
        compileKotlin {
            kotlinOptions.jvmTarget = "11"
        }
        compileTestKotlin {
            kotlinOptions.jvmTarget = "11"
        }

        withType<Test> {
            useJUnitPlatform()
        }
    }
}
