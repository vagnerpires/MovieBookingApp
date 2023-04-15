package com.example.moviebookingapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class MovieAdapter (private val movie: List<Movie>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_view, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movie[position]
        holder.movieName.text= movie.name
        holder.movieCertification.text = movie.certification
        holder.movieStarring.text = movie.starring.toString()
        holder.movieRunningTime.text = movie.runningTimeMins.toString()
        holder.movieSeatsRemaining.text = movie.seatsRemaining.toString()
        Picasso.get()
            .load(movie.image)
            .into(holder.movieImage)
    }

    override fun getItemCount(): Int {
        return movie.size
    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val movieImage = itemView.findViewById<ImageView>(R.id.movieImage)
        val movieName = itemView.findViewById<TextView>(R.id.titleMovie)
        val movieCertification = itemView.findViewById<TextView>(R.id.certificationMovie)
        val movieStarring = itemView.findViewById<TextView>(R.id.starringMovie)
        val movieRunningTime = itemView.findViewById<TextView>(R.id.runningTimeMovie)
        val movieSeatsRemaining = itemView.findViewById<TextView>(R.id.seatsRemainingMovie)
    }
}
