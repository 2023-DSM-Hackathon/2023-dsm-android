package com.example.hackathonproject.api

import com.example.hackathonproject.model.LoginResponse
import com.example.hackathonproject.model.RegisterRequest
import com.example.hackathonproject.model.UserInfoResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ServerApi {
    @POST("/users")
    fun register() : Call<RegisterRequest>

    @POST("/users/token")
    fun login() : Call<LoginResponse>

    @GET("/users")
    fun getUserInfo(
        @Header("access_token") token: String
    ) : Call<UserInfoResponse>


}