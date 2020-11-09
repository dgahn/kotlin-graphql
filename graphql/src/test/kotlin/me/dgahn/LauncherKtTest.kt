package me.dgahn

import io.kotest.core.spec.style.FunSpec
import org.springframework.test.web.reactive.server.WebTestClient

class LauncherKtTest : FunSpec({

    val client = WebTestClient.bindToServer().baseUrl("http://localhost:8181").build()
    val context = app.run(profiles = "test")

    test("루트로 접속하면 OK를 받는다.") {
        client.get().uri("/").exchange()
            .expectStatus().is2xxSuccessful
            .expectBody().isEmpty
    }

    afterSpec {
        context.close()
    }

})