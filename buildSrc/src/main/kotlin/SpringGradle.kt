object SpringVersion {
    const val dataR2dbc = "1.1.4.RELEASE"
    const val dependencyManagement = "1.0.10.RELEASE"
    const val boot = "2.3.5.RELEASE"
    const val graphql = "4.0.0-alpha.7"
}

object SpringLibs {
    const val dataR2dbc = "org.springframework.data:spring-data-r2dbc:${SpringVersion.dataR2dbc}"
    const val dependencyManagement = "io.spring.dependency-management"
    const val boot = "org.springframework.boot"
    const val bootStarterWebflux = "org.springframework.boot:spring-boot-starter-webflux"
    const val graphqlServer = "com.expediagroup:graphql-kotlin-spring-server${SpringVersion.graphql}"
}
