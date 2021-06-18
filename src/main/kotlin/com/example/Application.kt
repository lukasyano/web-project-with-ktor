package com.example

import com.example.authentication.configureAuthentication
import io.ktor.auth.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "localhost") {

        configureAuthentication()

        routing {
            authenticate("auth-basic") {
                rootRoute()
                bookmarkRoute()
            }
        }

    }.start(wait = true)
}
