object KotlinPlugin {
    const val kotlin = "kotlin"
}

object KotlinVersion {
    const val kotlin = "1.4.10"
    const val coroutine = "1.3.9"
}

object KotlinLibs {
    const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${KotlinVersion.kotlin}"
    const val coroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${KotlinVersion.coroutine}"
    const val coroutinesReactive = "org.jetbrains.kotlinx:kotlinx-coroutines-reactive:${KotlinVersion.coroutine}"
    const val coroutinesReactor = "org.jetbrains.kotlinx:kotlinx-coroutines-reactor:${KotlinVersion.coroutine}"
}