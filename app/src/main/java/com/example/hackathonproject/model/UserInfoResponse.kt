package com.example.hackathonproject.model

data class UserInfoResponse(
    val user_profile: List<UserProfile>
)

data class UserProfile(
    val id: Int,
    val nickname: String,
    val account_id: String,
    val achievements: List<Achievement>
)

data class Achievement(
    val content: String,
    val success: Boolean,
)