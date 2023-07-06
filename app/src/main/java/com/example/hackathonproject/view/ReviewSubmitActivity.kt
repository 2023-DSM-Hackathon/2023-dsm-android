package com.example.hackathonproject.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hackathonproject.R
import com.example.hackathonproject.databinding.ActivityReviewSubmitBinding

class ReviewSubmitActivity : AppCompatActivity() {
    lateinit var binding: ActivityReviewSubmitBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReviewSubmitBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnReviewSubmit.setOnClickListener {
            var intent = Intent(this, ReviewFragment::class.java)
            startActivity(intent)
            finish()
        }
    }
}