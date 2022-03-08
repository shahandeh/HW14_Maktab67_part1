package com.example.hw14_maktab67_part1.repository

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkManager {

    private val client: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply{
            level = HttpLoggingInterceptor.Level.BODY
        })
        .build()

    private val retrofit: Retrofit = Retrofit
        .Builder()
        .baseUrl("https://www.flickr.com/services/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    val service: FlickrApi = retrofit.create(FlickrApi::class.java)

}