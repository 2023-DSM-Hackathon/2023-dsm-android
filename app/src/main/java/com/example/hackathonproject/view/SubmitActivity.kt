package com.example.hackathonproject.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hackathonproject.R
import com.example.hackathonproject.api.ApiProvider
import com.example.hackathonproject.databinding.ActivitySubmitBinding

class SubmitActivity : AppCompatActivity() {
    lateinit var binding: ActivitySubmitBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubmitBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener {
            ApiProvider.retrofit
        }
    }
}