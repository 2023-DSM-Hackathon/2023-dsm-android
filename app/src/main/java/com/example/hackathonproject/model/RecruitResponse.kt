package com.example.hackathonproject.model

data class RecruitResponse(
    val feeds: ArrayList<Feeds>,
)

data class Feeds(
    val id: Int,
    val title: String,
    val place: String,
    val content: String,
    val date: String,
    val meeting_time: String,
    val head_count: Int,
    val current_head_count: Int,
    val status: String,
)