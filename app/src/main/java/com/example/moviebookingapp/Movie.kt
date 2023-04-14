package com.example.moviebookingapp

data class Movie (
    var name: String,
    var image: String,
    val certification: String,
    val description: String,
    val starring: List<String>,
    val runningTimeMins: Int,
    var seatsRemaining: Int,
    var seatsSelected: Int
)