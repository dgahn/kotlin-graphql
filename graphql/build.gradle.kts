apply(plugin = SpringPlugin.boot)
apply(plugin = SpringPlugin.dependencyManagement)

dependencies {
    api(SpringLibs.graphqlServer)
    api(KotlinLibs.kotlinStdlib)
    api(KotlinLibs.coroutineCore)
    api(KotlinLibs.coroutinesReactive)
    api(KotlinLibs.coroutinesReactor)

    api(SpringLibs.bootStarterWebflux)
    api(SpringLibs.bootStarterValidation)

    testImplementation(SpringLibs.bootStarterTest)
    testImplementation(TestContainerLibs.postgresql)
}
