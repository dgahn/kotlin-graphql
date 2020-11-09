object SpringPlugin {
    const val dependencyManagement = "io.spring.dependency-management"
    const val boot = "org.springframework.boot"
}

object SpringVersion {
    const val dependencyManagement = "1.0.10.RELEASE"
    const val boot = "2.4.0-RC1"
    const val graphql = "4.0.0-alpha.7"
    const val kofu = "0.4.3-SNAPSHOT"
}

object SpringLibs {
    const val bootStarterWebflux = "org.springframework.boot:spring-boot-starter-webflux"
    const val bootStarterTest = "org.springframework.boot:spring-boot-starter-test"
    const val graphqlServer = "com.expediagroup:graphql-kotlin-spring-server:${SpringVersion.graphql}"
    const val kofu = "org.springframework.fu:spring-fu-kofu:${SpringVersion.kofu}"
}
