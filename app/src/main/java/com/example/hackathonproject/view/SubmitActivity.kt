package com.example.hackathonproject.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import com.example.hackathonproject.R
import com.example.hackathonproject.api.ApiProvider
import com.example.hackathonproject.databinding.ActivitySubmitBinding
import com.example.hackathonproject.model.WriteFeedRequest
import com.example.hackathonproject.util.ACCESS_TOKEN
import retrofit2.Call
import retrofit2.Response

class SubmitActivity : AppCompatActivity() {
    lateinit var binding: ActivitySubmitBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubmitBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnSubmit.setOnClickListener {
            ApiProvider.retrofit.postFeeds(
                ACCESS_TOKEN, WriteFeedRequest(
                    binding.etSubmitTitle.text.toString(),
                    binding.etSubmitPlace.text.toString(),
                    binding.etSubmitDate.text.toString(),
                    Integer.parseInt(binding.etSubmitPersonCount.text.toString()),
                    binding.etSubmitTime.text.toString(),
                    binding.etSubmitPersonContent.text.toString(),
                )
            ).enqueue(object : retrofit2.Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    when (response.code()) {
                        201 -> {
                            var intent = Intent(it.context, MainActivity::class.java)

                            startActivity(intent)
                            finish()
                        }

                        else -> {
                            var intent = Intent(it.context, MainActivity::class.java)

                            startActivity(intent)
                            finish()
                        }
                    }
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    var intent = Intent(it.context, MainActivity::class.java)

                    startActivity(intent)
                    finish()
                }

            })
        }
    }
}