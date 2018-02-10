package com.muhammadraafi.finalprojectintermediate.model

import com.google.gson.annotations.SerializedName

/**
 * Created by uty1 on 03/02/2018.
 */
data class MovieResponse(
    @field:SerializedName("page")
    val page: String? = "",

    @field:SerializedName("total_results")
    val total_results: String? = "",

    @field:SerializedName("total_pages")
    val total_pages: String? = "",

    @field:SerializedName("results")
    val resultsList: List<Movie>? = null

    )

data class Movie(
        @field:SerializedName("vote_count")
        val vote_count: String? = "",

        @field:SerializedName("id")
        val id: String? = "",

        @field:SerializedName("video")
        val video: Boolean? = null ,

        @field:SerializedName("vote_average")
        val vote_average: String? = "",

        @field:SerializedName("title")
        val title: String? = "",

        @field:SerializedName("popularity")
        val popularity: String? = "",

        @field:SerializedName("poster_path")
        val poster_path: String? = "",

        @field:SerializedName("original_language")
        val original_language: String? = "",

        @field:SerializedName("original_title")
        val original_title: String? = "",

        @field:SerializedName("backdrop_path")
        val backdrop_path: String? = "",

        @field:SerializedName("adult")
        val adult: Boolean? = null,

        @field:SerializedName("overview")
        val overview: String? = "",

        @field:SerializedName("release_date")
        val release_date: String? = ""

        )

data class TrailersResponse(
        @field:SerializedName("results")
        val results:List<ListTrailers>?=null
)

data class ListTrailers(
        @field:SerializedName("key")
        val key:String?=""
)