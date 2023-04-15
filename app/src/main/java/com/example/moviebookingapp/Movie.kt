package com.example.moviebookingapp

import java.io.Serializable

data class Movie (
    var name: String,
    var image: String,
    val certification: String,
    val description: String,
    val starring: List<String>,
    val runningTimeMins: Int,
    var seatsRemaining: Int,
    var seatsSelected: Int
) : Serializable