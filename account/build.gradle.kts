apply(plugin = SpringPlugin.boot)
apply(plugin = SpringPlugin.dependencyManagement)

dependencies {
    implementation(project(":common-entity"))
    implementation(KotlinLibs.coroutineCore)
    implementation(KotlinLibs.coroutinesReactive)
    implementation(KotlinLibs.coroutinesReactor)
    implementation(KotlinLibs.coroutinesJdk8)
    implementation(KotlinLibs.kotlinReflect)

    implementation(HibernateLibs.reactiveCore)
    implementation(HibernateLibs.types)
    implementation(HibernateLibs.spatial)

    implementation(VertxLibs.pgClient)

    testImplementation(KotestLibs.assertionsCore)
    testImplementation(KotestLibs.kotestProperty)
    testImplementation(KotestLibs.runnerJunit5)
    implementation(kotlin("stdlib-jdk8"))
}
