package com.example.hw14_maktab67_part1.repository

import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.QueryMap

interface FlickrApi {

    @POST("rest/")
    fun getImage(@QueryMap query: HashMap<String, String>) : Call<FlickrApiModel>

}