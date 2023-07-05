package com.example.hackathonproject.model

import java.util.Date

data class RecruitData(
    val title: String,
    val content: String,
    val place: String,
    val time: String,
    val date: String,
    val person_count: Int,
)