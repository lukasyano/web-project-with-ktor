package com.example.authentication

import com.example.data.DataManager
import io.ktor.application.*
import io.ktor.auth.*

//https://ktor.io/docs/authentication
fun Application.configureAuthentication() {

    install(Authentication) {
        basic("auth-basic") {
            validate { credentials ->
                if (isUserFound(credentials)) {
                    UserIdPrincipal(credentials.name)
                } else {
                    null
                }
            }
        }
    }
}

fun isUserFound(userPasswordCredential: UserPasswordCredential): Boolean {
    DataManager.users.forEach {
        if (userPasswordCredential.name == it.name && userPasswordCredential.password == it.password){
            return true
        }
    }
    return false
}
