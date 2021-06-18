package com.example

import com.example.authentication.configureAuthentication
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "localhost") {

        configureAuthentication()

        configureRouting()

    }.start(wait = true)
}
