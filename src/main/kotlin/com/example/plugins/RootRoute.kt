package com.example.plugins

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*


//extended function, buts it's kind useless
fun Routing.root() {
    get("/") {
        call.respondText("Hello World!", ContentType.Text.Plain)
    }
}