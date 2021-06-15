package com.example

import io.ktor.application.*
import io.ktor.auth.*

//https://ktor.io/docs/authentication
fun Application.configureAuthentication() {

    install(Authentication) {
        basic("auth-basic") {
            validate { credentials ->
                if (credentials.name == "lukas" && credentials.password == "lukas123") {

                    GlobalObject.userName = credentials.name
                    UserIdPrincipal(credentials.name)
                } else {
                    null
                }
            }
        }
    }
}
