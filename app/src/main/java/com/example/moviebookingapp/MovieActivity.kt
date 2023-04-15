package com.example.moviebookingapp

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import com.example.moviebookingapp.Movie as Movie

@Suppress("DEPRECATION")
class MovieActivity : AppCompatActivity(R.layout.activity_main){
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val movie = intent.getSerializableExtra("movie") as? Movie

        if (movie != null) {
            setupMovieData(movie)
        } else {
            Log.e("MovieActivity", "Movie object is null")
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setupMovieData(movie: Movie) {
        val movieImage = findViewById<ImageView>(R.id.movieImage)
        val movieName = findViewById<TextView>(R.id.titleMovie)
        val movieDescription = findViewById<TextView>(R.id.descriptionMovie)
        val movieStarring = findViewById<TextView>(R.id.starringMovie)
        val movieRunningTime = findViewById<TextView>(R.id.runningTimeMovie)
        val seatsRemaining = findViewById<TextView>(R.id.seatsRemainingMovie)
        val seatsSelected = findViewById<TextView>(R.id.seatsSelectedMovie)
        val plusButton = findViewById<ImageView>(R.id.buttonPlus)
        val minusButton = findViewById<ImageView>(R.id.buttonMinus)
        val homeButton = findViewById<Button>(R.id.homeButton)

        movieName.text = movie.name
        movieDescription.text = movie.description
        movieStarring.text = movie.starring.joinToString(", ")
        movieRunningTime.text = "${movie.runningTimeMins} mins"
        seatsRemaining.text = "${movie.seatsRemaining} seats remaining"
        seatsSelected.text = "${movie.seatsSelected} seats selected"

        Picasso.get()
            .load(movie.image)
            .into(movieImage)

        seatsRemaining.text = "${movie.seatsRemaining} seats remaining"

        fun updateSeats() {
            plusButton.isEnabled = movie.seatsRemaining> 0
            minusButton.isEnabled = movie.seatsSelected > 0
        }

        minusButton.setOnClickListener {
            if (movie.seatsSelected > 0) {
                movie.seatsRemaining++
                movie.seatsSelected--
                seatsRemaining.text = "${movie.seatsRemaining} seats remaining"
                seatsSelected.text = movie.seatsSelected.toString()
                updateSeats()
            }
        }

        plusButton.setOnClickListener {
            if (movie.seatsRemaining > 0) {
                movie.seatsRemaining--
                movie.seatsSelected++
                seatsRemaining.text = "${movie.seatsRemaining} seats remaining"
                seatsSelected.text = movie.seatsSelected.toString()
                updateSeats()
            }
        }

        updateSeats()

        homeButton.setOnClickListener {
            val resultIntent = Intent()
            resultIntent.putExtra("updatedMovie", movie)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        val movie = intent.getSerializableExtra("movie") as? Movie
        val resultIntent = Intent()
        if (movie != null) {
            resultIntent.putExtra("updatedMovie", movie)
        }
        setResult(Activity.RESULT_OK, resultIntent)
        super.onBackPressed()
    }
}