package com.example

import io.ktor.application.*
import io.ktor.html.*
import io.ktor.http.content.*
import io.ktor.request.*
import io.ktor.routing.*
import kotlinx.html.*

fun Route.bookmarkRoute() {
    post("/bookmark") {
        val multipart = call.receiveMultipart()
        var movieIdPassed = ""
        while (true) {
            val part = multipart.readPart() ?: break
            when (part) {
                is PartData.FormItem -> {
                    if (part.name == "movieId") {
                        movieIdPassed = part.value
                    }
                }
            }
            part.dispose
        }
        GlobalObject.movies.forEach {
            if (it.id == movieIdPassed) {
                GlobalObject.updateMovie(movieIdPassed)
            }
        }
        call.respondHtml {
            head {
                configureBootstrapInTheHeader()
                title { +"Awesome Movies" }
            }
            body {
                div(classes = "alert alert-success") {
                    this.role = "alert"
                    +"The bookmark got updated successfully"
                }
                configureBootstrapInTheBody()
            }
        }
    }
}
