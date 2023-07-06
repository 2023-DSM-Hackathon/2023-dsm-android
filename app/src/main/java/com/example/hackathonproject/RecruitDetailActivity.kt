package com.example.hackathonproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.hackathonproject.databinding.ActivityRecruitDetailBinding

class RecruitDetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityRecruitDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecruitDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}