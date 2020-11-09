package me.dgahn

import org.springframework.boot.logging.LogLevel
import org.springframework.fu.kofu.reactiveWebApplication
import org.springframework.fu.kofu.webflux.webFlux
import org.springframework.web.reactive.function.server.ServerResponse

val app = reactiveWebApplication {
    logging {
        level = LogLevel.DEBUG
    }
    webFlux {
        port = if (profiles.contains("test")) 8181 else 8080
        router {
            GET("/") { ServerResponse.ok().build() }
        }
    }
}

fun main() {
    app.run()
}