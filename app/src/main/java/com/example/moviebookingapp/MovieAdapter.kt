package com.example.moviebookingapp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class MovieAdapter(private var movie: List<Movie>, private val itemClickListener: (Movie) -> Unit) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_view, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movie[position]
        holder.bind(movie)
        holder.movieName.text = movie.name
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

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val movieImage: ImageView = itemView.findViewById(R.id.movieImage)
        val movieName: TextView = itemView.findViewById(R.id.titleMovie)
        val movieCertification: TextView = itemView.findViewById(R.id.certificationMovie)
        val movieStarring: TextView = itemView.findViewById(R.id.starringMovie)
        val movieRunningTime: TextView = itemView.findViewById(R.id.runningTimeMovie)
        val movieSeatsRemaining: TextView = itemView.findViewById(R.id.seatsRemainingMovie)

        fun bind(movie: Movie) {
            itemView.setOnClickListener { itemClickListener(movie) }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateMovie(movie: Movie) {
        this.movie = listOf(movie)
        notifyDataSetChanged()
    }
}
