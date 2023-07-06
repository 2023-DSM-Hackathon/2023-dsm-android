package com.example.hackathonproject.model

data class UserInfoResponse(
    val user_profile: UserProfile,
    val achievements: ArrayList<Achievement>,
    val feeds: ArrayList<MyFeeds>,
    val applies: ArrayList<Applies>,
    val reviews: ArrayList<Reviews>,
)

data class UserProfile(
    val id: Int,
    val nickname: String,
    val birth_date: String,
    val account_id: String,
)
data class Achievement(
    val content: String,
    val success: Boolean,
)

data class MyFeeds(
    val id: Int,
    val title: String,
    val date: String,
    val meeting_time: String,
    val place: String,
)

data class Applies(
    val id: Int,
    val title: String,
    val date: String,
    val meeting_time: String,
    val content: String,
)

data class Reviews(
    val id: Int,
    val title: String,
    val image_url: String,
    val content: String,
)