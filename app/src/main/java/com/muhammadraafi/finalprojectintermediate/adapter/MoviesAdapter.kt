package com.muhammadraafi.finalprojectintermediate.adapter

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log.i
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.muhammadraafi.finalprojectintermediate.DetailActivity
import com.muhammadraafi.finalprojectintermediate.R
import com.muhammadraafi.finalprojectintermediate.model.Movie
import kotlinx.android.synthetic.main.movie_card.view.*

/**
 * Created by uty1 on 03/02/2018.
 */
class MoviesAdapter(private val listMovie:List<Movie>): RecyclerView.Adapter<MoviesAdapter.Holder>() {
    override fun getItemCount(): Int {
        return listMovie.size
    }

    override fun onBindViewHolder(holder: Holder?, position: Int) {
        holder?.bind(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): Holder {
        val view: View = LayoutInflater.from(parent?.context).inflate(R.layout.movie_card,parent,false)
        return Holder(view)
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(position: Int) {
            val context = itemView.context
            val movie: Movie = listMovie[position]
            i("adapter", "movie: ${Gson().toJsonTree(movie)}")

            Glide.with(context)
                    .load("https://image.tmdb.org/t/p/w185${movie.poster_path}").into(itemView?.thumbnail)

            itemView.title.text = movie.title
            itemView.userRating.text = movie.vote_average

            itemView.card_view.setOnClickListener {
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra("Id", movie.id)
                intent.putExtra("Title", movie.title)
                intent.putExtra("Poster", movie.poster_path)
                intent.putExtra("Backdrop", movie.backdrop_path)
                intent.putExtra("Overview", movie.overview)
                intent.putExtra("Rating", movie.vote_average)
                intent.putExtra("Rating_count", movie.vote_count)
                intent.putExtra("Release_date",movie.release_date)

                context.startActivity(intent)
            }
        }
    }
}