package com.muhammadraafi.finalprojectintermediate

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log.i
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.muhammadraafi.finalprojectintermediate.adapter.TrailersAdapter
import com.muhammadraafi.finalprojectintermediate.api.Client
import com.muhammadraafi.finalprojectintermediate.model.ListTrailers
import com.muhammadraafi.finalprojectintermediate.model.TrailersResponse
import kotlinx.android.synthetic.main.activity_detail.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * Created by uty1 on 03/02/2018.
 */
class DetailActivity : AppCompatActivity() {
    var id:String?=""
    var title:String?=""
    var overview:String?=""
    var poster:String?=""
    var backdrop:String?=""
    var rating:String?=""
    var rating_count:String?=""
    var release_date:String?=""

    private val tag = this::class.java.simpleName
    private lateinit var adapter:TrailersAdapter
    private var trailerList = mutableListOf<ListTrailers>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        getExtraIntent()
        setupView()
        getTrailers()
    }

    private fun getExtraIntent(){
        id = intent.getStringExtra("Id")
        title = intent.getStringExtra("Title")
        overview = intent.getStringExtra("Overview")
        poster = intent.getStringExtra("Poster")
        rating = intent.getStringExtra("Rating")
        rating_count = intent.getStringExtra("Rating_count")
        release_date = intent.getStringExtra("Release_date")
        backdrop = intent.getStringExtra("Backdrop")

    }

    private fun setupView(){

        tvTitle.text=title
        tvOverview.text=overview
        tvRate.text=rating
        tvRelDate.text=release_date

        Glide.with(this).load("https://image.tmdb.org/t/p/w185${backdrop}").error(R.mipmap.ic_launcher).into(ivBackDrop)
        Glide.with(this).load("https://image.tmdb.org/t/p/w185${poster}").error(R.mipmap.ic_launcher).into(ivPoster)
        adapter = TrailersAdapter(trailerList)
        rvTrailers.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false)
        rvTrailers.adapter=adapter
    }

    private fun getTrailers(){
        Client.api.getTrailers(id).enqueue(object : Callback<TrailersResponse>{
            override fun onFailure(call: Call<TrailersResponse>?, t: Throwable?) {
            }
            override fun onResponse(call: Call<TrailersResponse>?, response: Response<TrailersResponse>?) {
                i(tag, "data : ${Gson().toJsonTree(response?.body())}")
                response?.body()?.results?.let {
                    trailerList.addAll(it)
                    adapter.notifyDataSetChanged()
                }
            }
        })
    }
}