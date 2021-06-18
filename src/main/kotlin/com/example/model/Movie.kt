package com.example.model

data class Movie(
    var id: String,
    val title: String,
    val year: Int,
    var isBookmarked: Boolean,
)