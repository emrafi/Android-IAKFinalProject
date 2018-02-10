package com.muhammadraafi.finalprojectintermediate

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.Gson
import com.muhammadraafi.finalprojectintermediate.adapter.MoviesAdapter
import com.muhammadraafi.finalprojectintermediate.api.Client
import com.muhammadraafi.finalprojectintermediate.model.Movie
import com.muhammadraafi.finalprojectintermediate.model.MovieResponse
import kotlinx.android.synthetic.main.content_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by uty1 on 08/02/2018.
 */
class MovieTopFragment : Fragment() {
    private val movieList = mutableListOf<Movie>()
    private lateinit var adapter: MoviesAdapter
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView: View?=inflater?.inflate(R.layout.content_main,container,false)
        getData()
        return rootView
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    private fun setupView(){
        adapter = MoviesAdapter(movieList)
        recycler_view.layoutManager= GridLayoutManager(context,1)
        recycler_view.adapter = adapter
    }

    private fun getData(){

        Client.api.getMovieTopRated().enqueue(object  : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>?, t: Throwable?) {
                Log.e(tag, t?.message)
            }

            override fun onResponse(call: Call<MovieResponse>?, response: Response<MovieResponse>?) {
                Log.i(tag, "data: ${Gson().toJsonTree(response?.code())}")
                val nMovieList=response?.body()?.resultsList
                nMovieList?.let {
                    movieList.addAll(it)
                    adapter.notifyDataSetChanged()
                }

            }
        })
    }

}