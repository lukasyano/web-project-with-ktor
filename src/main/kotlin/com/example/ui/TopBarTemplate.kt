package com.example.ui

import io.ktor.html.*
import kotlinx.html.FlowContent
import kotlinx.html.a
import kotlinx.html.div
import kotlinx.html.nav

class TopBarTemplate : Template<FlowContent> {

    override fun FlowContent.apply() {
        div {
            nav(classes = "navbar navbar-expand-md navbar-dark bg-dark ") {
                a(classes = "navbar-brand") { +"Awesome Movies" }
            }
        }
    }
}
