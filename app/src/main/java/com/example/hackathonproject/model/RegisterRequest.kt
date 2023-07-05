package com.example.hackathonproject.model

data class RegisterRequest(
    val nickname: String,
    val age: Int,
    val sex: String,
    val account_id: String,
    val password: String,
)