package com.example.hackathonproject.model

data class WriteFeedRequest(
    val title: String,
    val place: String,
    val date: String,
    val head_count: Int,
    val meeting_time: String,
    val content: String,
)