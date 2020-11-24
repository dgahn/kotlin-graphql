dependencies {
    implementation(project(":graphql"))
    implementation(platform(ArmeriaLibs.armeriaBom))
    implementation(platform(ArmeriaLibs.nettyBom))
    implementation(ArmeriaLibs.springWebfluxStarter)
}