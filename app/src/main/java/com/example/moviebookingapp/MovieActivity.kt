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
class MovieActivity : AppCompatActivity(R.layout.movie_activity){
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
        val movieImage : ImageView = findViewById(R.id.movieImage)
        val movieName : TextView = findViewById(R.id.titleMovie)
        val movieCertification : TextView = findViewById(R.id.certificationMovie)
        val movieDescription : TextView = findViewById(R.id.descriptionMovie)
        val movieStarring : TextView = findViewById(R.id.starringMovie)
        val movieRunningTime : TextView = findViewById(R.id.runningTimeMovie)
        val seatsRemaining : TextView = findViewById(R.id.seatsRemainingMovie)
        val seatsSelected : TextView = findViewById(R.id.numSeats)
        val plusButton : ImageView = findViewById(R.id.buttonPlus)
        val minusButton : ImageView = findViewById(R.id.buttonMinus)
        val homeButton : Button = findViewById(R.id.homeButton)

        movieName.text = movie.name
        movieCertification.text = movie.certification
        movieDescription.text = movie.description
        movieStarring.text = movie.starring.joinToString(", ")
        movieRunningTime.text = movie.runningTimeMins.toString()
        seatsSelected.text = movie.seatsSelected.toString()

        Picasso.get()
            .load(movie.image)
            .into(movieImage)

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
        val movie : Movie? = intent.getSerializableExtra("update movie") as? Movie
        if (movie != null) {
            val resultIntent = Intent()
            resultIntent.putExtra("movie", movie)
            setResult(Activity.RESULT_OK, resultIntent)
        }
        super.onBackPressed()
    }
}
