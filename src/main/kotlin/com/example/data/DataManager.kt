package com.example.data

import com.example.model.Movie
import com.example.model.User

object DataManager {

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

    val users = listOf(
        User(1,"lukas","lukas123"),
        User(1,"mykolas","mykolas123"),
        User(1,"test","test123"),
    )

    fun updateMovie(movieId : String) {
        val foundMovie : Movie? = movies.find { it.id == movieId }
        foundMovie?.let {
            it.isBookmarked = !it.isBookmarked
        }
    }
}