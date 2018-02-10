package com.muhammadraafi.finalprojectintermediate.api

import retrofit2.Call
import retrofit2.http.GET
import com.muhammadraafi.finalprojectintermediate.model.MovieResponse
import com.muhammadraafi.finalprojectintermediate.model.TrailersResponse
import retrofit2.http.Path

/**
 * Created by uty1 on 03/02/2018.
 */
interface Service {
    @GET("movie/popular?api_key=e2cc92ec8be1b8f4ed1fbb3a66883d7f")
    fun getMoviePopuler(): Call<MovieResponse>

    @GET("movie/top_rated?api_key=e2cc92ec8be1b8f4ed1fbb3a66883d7f")
    fun getMovieTopRated() : Call<MovieResponse>

    @GET("movie/{id_movie}/videos?api_key=e2cc92ec8be1b8f4ed1fbb3a66883d7f")
    fun getTrailers(@Path("id_movie") idMovie: String?):Call<TrailersResponse>
}