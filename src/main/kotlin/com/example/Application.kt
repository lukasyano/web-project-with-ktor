package com.example

import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "localhost") {
        configureAuthentication()
        configureRouting()
    }.start(wait = true)

}

object GlobalObject {
    var userName = ""

    val movies = listOf(
            "Awake (2021)",
            "Doors (2020)",
            "Flashback (2021)",
            "Xtreme (2020)",
            "Tragic Jungle (2021)",
            "Blue Miracle (2020)",
            "Girl (2021)",
            "Come True (2020)",
            "Army of Dead (2021)",
    )
}