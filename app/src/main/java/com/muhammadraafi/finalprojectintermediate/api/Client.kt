package com.muhammadraafi.finalprojectintermediate.api

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by uty1 on 03/02/2018.
 */
class Client : Application() {

    companion object {
        lateinit var api: Service
    }

    override fun onCreate(){
        super.onCreate()

        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        api = retrofit.create(Service::class.java)

    }
}