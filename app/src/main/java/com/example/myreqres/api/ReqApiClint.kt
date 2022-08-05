package com.example.myreqres.api

import android.util.Log
import com.example.myreqres.model.Req
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ReqApiClint {
    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://reqres.in/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val api: ReqResApi by lazy {
        retrofit.create(ReqResApi::class.java)

    }

    suspend fun getData(): ArrayList<Req> {
        Log.d("api",api.getReq().data.get(1).first_name)

        return api.getReq().data
    }
}