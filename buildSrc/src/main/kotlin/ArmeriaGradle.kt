object ArmeriaVersion {
    const val armeriaBom = "1.2.0"
    const val nettyBom = "4.1.53.Final"
}

object ArmeriaLibs {
    const val armeriaBom = "com.linecorp.armeria:armeria-bom:${ArmeriaVersion.armeriaBom}"
    const val nettyBom = "io.netty:netty-bom:${ArmeriaVersion.nettyBom}"
    const val springWebfluxStarter = "com.linecorp.armeria:armeria-spring-boot2-webflux-starter"
}