package com.example

import com.example.bootstrap.configureBootstrapInTheBody
import com.example.bootstrap.configureBootstrapInTheHeader
import com.example.data.DataManager
import com.example.ui.MoviesTemplate
import com.example.ui.TopBarTemplate
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.html.*
import io.ktor.routing.*
import kotlinx.html.*

fun Application.configureRouting() {
    routing {
        authenticate("auth-basic") {
            get("/") {
                call.respondHtml {
                    head {
                        configureBootstrapInTheHeader()
                        title { +"Awesome Movies" }
                    }
                    body {
                        insert(TopBarTemplate()) {}
                        insert(MoviesTemplate(DataManager.movies)) {}

                        configureBootstrapInTheBody()
                    }
                }
            }
            bookmarkRoute()
        }
    }
}
