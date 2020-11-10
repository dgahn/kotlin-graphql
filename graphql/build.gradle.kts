apply(plugin = SpringPlugin.boot)
apply(plugin = SpringPlugin.dependencyManagement)

dependencies {
    implementation(SpringLibs.graphqlServer)
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

    testImplementation(SpringLibs.bootStarterTest)
    testImplementation(TestContainerLibs.postgresql)
}
