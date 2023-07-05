package com.example.hackathonproject.model

data class RegisterRequest(
    val nickname: String,
    val birth_date: String,
    val sex: String,
    val account_id: String,
    val password: String,
)