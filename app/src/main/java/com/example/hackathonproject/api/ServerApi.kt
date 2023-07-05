package com.example.hackathonproject.api

import com.example.hackathonproject.model.LoginRequest
import com.example.hackathonproject.model.LoginResponse
import com.example.hackathonproject.model.RecruitResponse
import com.example.hackathonproject.model.RegisterRequest
import com.example.hackathonproject.model.UserInfoResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ServerApi {
    @POST("/users")
    fun register(
        @Body registerRequest: RegisterRequest
    ) : Call<Void>

    @POST("/users/token")
    fun login(
        @Body loginRequest: LoginRequest
    ) : Call<LoginResponse>

    @GET("/users")
    fun getUserInfo(
        @Header("access_token") token: String
    ) : Call<UserInfoResponse>

    @GET("/feeds")
    fun getFeeds(
    ) : Call<RecruitResponse>


}