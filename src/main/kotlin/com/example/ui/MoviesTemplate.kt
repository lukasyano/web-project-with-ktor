package com.example.ui

import com.example.model.Movie
import io.ktor.html.*
import kotlinx.html.*

class MoviesTemplate(private val movies: List<Movie>) : Template<FlowContent> {

    override fun FlowContent.apply() {

        div(classes = "mt-2") {
            table(classes = "table table-striped") {
                thead {
                    tr {
                        th(scope = ThScope.col) { +"Movie Title" }
                        th(scope = ThScope.col) { +"Release Year" }
                        th(scope = ThScope.col) { +"" }
                    }
                }
                tbody {
                    movies.forEach {
                        tr {
                            td { +it.title }
                            td { +"${it.year}" }
                            td {
                                form(
                                    method = FormMethod.post,
                                    encType = FormEncType.multipartFormData,
                                    action = "/bookmark"
                                ) {
                                    if (it.isBookmarked) {
                                        button(classes = "btn btn-success", type = ButtonType.submit) {
                                            +"Done"
                                        }
                                    } else {
                                        button(classes = "btn btn-warning", type = ButtonType.submit) {
                                            +"Bookmark"
                                        }
                                    }
                                    input(type = InputType.hidden, name = "movieId") {
                                        value = it.id
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
