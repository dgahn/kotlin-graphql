plugins {
    kotlin("jvm") version KotlinVersion.kotlin
    id(SpringLibs.dependencyManagement) version SpringVersion.dependencyManagement
    id(SpringLibs.boot) version SpringVersion.boot
}

allprojects {
    apply(plugin = KotlinPlugin.kotlin)
    apply(plugin = SpringLibs.dependencyManagement)

    group = "me.dgahn"
    version = "0.1.0"

    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        implementation(KotlinLibs.kotlinStdlib)
        implementation(KotlinLibs.coroutineCore)
        implementation(KotlinLibs.coroutinesReactive)
        implementation(KotlinLibs.coroutinesReactor)

        implementation(SpringLibs.bootStarterWebflux)

        implementation(LogLibs.logback)
        implementation(LogLibs.kotlinLogging)

        testImplementation(KotestLibs.runnerJunit5)
        testImplementation(KotestLibs.assertionsCore)
        testImplementation(KotestLibs.kotestProperty)

        testImplementation(TestContainerLibs.postgresql)
    }

    tasks {
        compileKotlin {
            kotlinOptions.jvmTarget = "1.8"
        }
        compileTestKotlin {
            kotlinOptions.jvmTarget = "1.8"
        }

        withType<Test> {
            useJUnitPlatform()
        }
    }
}
