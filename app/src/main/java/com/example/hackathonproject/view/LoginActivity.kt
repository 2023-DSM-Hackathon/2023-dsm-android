package com.example.hackathonproject.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.hackathonproject.api.ApiProvider
import com.example.hackathonproject.databinding.ActivityLoginBinding
import com.example.hackathonproject.model.LoginRequest
import com.example.hackathonproject.model.LoginResponse
import retrofit2.Call
import com.example.hackathonproject.util.ACCESS_TOKEN
import retrofit2.Response
import javax.security.auth.callback.Callback

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var access_token: String

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var intent = Intent(this, MainActivity::class.java)

        binding.btLoginRegister.setOnClickListener {
            var intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
        binding.btLoginLogin.setOnClickListener {
            val account_id = binding.etLoginId.text.toString()
            val password = binding.etLoginPw.text.toString()

            if (account_id.isBlank() || password.isBlank()) {
                Toast.makeText(this@LoginActivity, "로그인을 다시 시도해주세요", Toast.LENGTH_SHORT).show()
            } else {
                ApiProvider.retrofit.login(LoginRequest(account_id, password))
                    .enqueue(object : Callback, retrofit2.Callback<LoginResponse> {
                        override fun onResponse(
                            call: Call<LoginResponse>, response: Response<LoginResponse>
                        ) {
                            when (response.code()) {
                                200 -> {
                                    ACCESS_TOKEN =
                                        "Bearer " + response.body()?.access_token.toString()
                                    Toast.makeText(
                                        this@LoginActivity, "로그인에 성공했습니다!", Toast.LENGTH_SHORT
                                    ).show()
                                    startActivity(intent)
                                    finish()

                                }

                                else -> {
                                    Toast.makeText(
                                        this@LoginActivity, "로그인에 실패했습니다..", Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                        }

                        override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                            Toast.makeText(
                                this@LoginActivity, "로그인에 실패했습니다..", Toast.LENGTH_SHORT
                            ).show()
                        }

                    })
            }
        }

    }
}