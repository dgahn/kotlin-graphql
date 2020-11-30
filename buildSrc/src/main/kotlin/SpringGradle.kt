object SpringPlugin {
    const val dependencyManagement = "io.spring.dependency-management"
    const val boot = "org.springframework.boot"
}

object SpringVersion {
    const val dependencyManagement = "1.0.10.RELEASE"
    const val boot = "2.3.5.RELEASE"
    const val graphql = "4.0.0-alpha.7"
}

object SpringLibs {
    const val bootStarterWebflux = "org.springframework.boot:spring-boot-starter-webflux:${SpringVersion.boot}"
    const val bootStarterValidation = "org.springframework.boot:spring-boot-starter-validation:${SpringVersion.boot}"
    const val bootStarterTest = "org.springframework.boot:spring-boot-starter-test:${SpringVersion.boot}"
    const val graphqlServer = "com.expediagroup:graphql-kotlin-spring-server:${SpringVersion.graphql}"
}
