package com.example.hackathonproject.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hackathonproject.R
import com.example.hackathonproject.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}