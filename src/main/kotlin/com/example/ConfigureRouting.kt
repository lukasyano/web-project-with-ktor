package com.example

import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.html.*
import io.ktor.routing.*
import kotlinx.html.*

fun Application.configureRouting() {
    routing {

        get("/") {
            call.respondHtml {
                buildMoviesHtml()
            }
        }

        authenticate("auth-basic"){
            get("juskaiciai"){
                call.respondHtml {
                    body {
                        h2 {
                            +"Jsukaiciaiiiiiiii"
                        }
                    }
                }
            }
        }
    }
}

// https://play.kotlinlang.org/byExample/09_Kotlin_JS/06_HtmlBuilder
private fun HTML.buildMoviesHtml() {

    head {
        configureBootstrapInTheHeader()
        title {
            +"Awesome Movies"
        }
    }
    body {
        div(classes = "container") {
            div(classes = "row") {
                div(classes = "offset-md-4 col-md-4 order-md-2 mb-4") {
                    h1 {
                        +"Suggested movies for -> ${GlobalObject.userName}"
                    }
                    ul {
                        for (item in GlobalObject.movies) {
                            li { +item }
                        }
                    }

                    button(classes = "btn btn-danger") { +"Test 123" }

                    br {}
                    br {}

                    div(classes = "alert alert-success") {
                        this.role = "alert"
                        +"My Ktor and Bootstrap application loaded with success!"
                    }
                }
            }
        }
        configureBootstrapInTheBody()
    }
}
