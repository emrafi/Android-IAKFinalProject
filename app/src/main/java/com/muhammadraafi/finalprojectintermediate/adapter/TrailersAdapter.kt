package com.muhammadraafi.finalprojectintermediate.adapter

import android.content.Intent
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.muhammadraafi.finalprojectintermediate.R
import com.muhammadraafi.finalprojectintermediate.model.ListTrailers
import kotlinx.android.synthetic.main.trailers.view.*

/**
 * Created by uty1 on 09/02/2018.
 */
class TrailersAdapter(private val trailersList: List<ListTrailers>) : RecyclerView.Adapter<TrailersAdapter.Holder>() {

    override fun onBindViewHolder(holder: Holder?, position: Int) {
        holder?.bind(position)
    }

    override fun getItemCount(): Int {
        return trailersList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): Holder{
        val view:View = LayoutInflater.from(parent?.context).inflate(R.layout.trailers,parent,false)
        return Holder(view)
    }

    inner class Holder(itemView:View) : RecyclerView.ViewHolder(itemView){
      fun bind(position: Int){
          val context = itemView.context
          val trailersResult:ListTrailers=trailersList[position]
        Glide.with(context).load("http://img.youtube.com/vi/${ trailersResult.key}/hqdefault.jpg").error(R.mipmap.ic_launcher).into(itemView.ivTrailer)
          itemView.ivTrailer.setOnClickListener{
              val intent = Intent(Intent.ACTION_VIEW)
              intent.setData(Uri.parse("https://www.youtube.com/watch?v=${trailersResult.key}"))
            context.startActivity(intent)
          }
      }
    }
}