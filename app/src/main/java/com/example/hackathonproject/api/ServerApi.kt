package com.example.hackathonproject.api

import com.example.hackathonproject.model.GetReviewResponse
import com.example.hackathonproject.model.LoginRequest
import com.example.hackathonproject.model.LoginResponse
import com.example.hackathonproject.model.RecruitResponse
import com.example.hackathonproject.model.RegisterRequest
import com.example.hackathonproject.model.UserInfoResponse
import com.example.hackathonproject.model.WriteFeedRequest
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
        @Header("Authorization") token: String
    ) : Call<UserInfoResponse>

    @GET("/feeds")
    fun getFeeds(
    ) : Call<RecruitResponse>

    @POST("/feeds")
    fun postFeeds(
        @Header("Authorization") token: String,
        @Body writeFeedRequest: WriteFeedRequest
    ) : Call<Void>

    @GET("/reviews")
    fun getReviews(
        @Header("Authorization") token: String,
    ) : Call<GetReviewResponse>

}