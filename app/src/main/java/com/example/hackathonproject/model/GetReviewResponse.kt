package com.example.hackathonproject.model

data class GetReviewResponse(
    val reviews: ArrayList<Review>,
)

data class Review(
    val id: Int,
    val nickname: String,
    val title: String,
    val content: String,
    val image_url: String,
    val comment_count: Int,
)