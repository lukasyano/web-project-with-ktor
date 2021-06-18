package com.example

import com.example.model.Movie
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

    var movies = listOf(
        Movie("1", "Awake", 2021, false),
        Movie("2", "Doors", 2020, false),
        Movie("3", "Flashback", 2021, false),
        Movie("4", "Xtreme", 2019, false),
        Movie("5", "Tragic Jungle", 2021, false),
        Movie("6", "Blue Miracle", 2019, false),
        Movie("7", "Girl", 2018, false),
        Movie("8", "Come True", 2021, false),
        Movie("9", "Come True", 2017, false),
        Movie("10", "Army of Dead", 2021, false)
    )

    fun updateMovie(movieId : String) {
        val foundMovie : Movie? = movies.find { it.id == movieId }
        foundMovie?.let {
            it.isBookmarked = !it.isBookmarked
        }
    }
}