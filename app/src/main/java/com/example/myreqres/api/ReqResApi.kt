package com.example.myreqres.api

import com.example.myreqres.model.ReqRes
import retrofit2.http.GET

interface ReqResApi {
    @GET("users")

     suspend fun getReq():ReqRes
}