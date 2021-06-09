package com.example.plugins

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

private const val userData = "{ \"users\": [\"Nate\", \"Lukas\", \"Antanas\"] }"

fun Application.configureRouting() {
    // Starting point for a Ktor app:
    routing {

        //This running in RootRoute.kt
        this.root()

        // RUN THIS - curl -X POST -d "post variable text" http://localhost:8080/
        post("/") {
            val post = call.receive<String>()
            call.respondText("Revieved $post from the post body", ContentType.Text.Plain)
        }

        //http://localhost:8080/users
        get("/users") {
            call.respondText(userData)
        }
    }
}
