package com.example.hackathonproject.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.hackathonproject.R
import com.example.hackathonproject.api.ApiProvider
import com.example.hackathonproject.api.ServerApi
import com.example.hackathonproject.databinding.ActivityRegisterBinding
import com.example.hackathonproject.model.RegisterRequest
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback
import kotlin.math.log

@Suppress("IMPLICIT_CAST_TO_ANY")
class RegisterActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var intent = Intent(this, LoginActivity::class.java)

        binding.btLoginRegister.setOnClickListener {
            val nickname = binding.etRegisterName.text.toString()
            val birth_date =
                binding.etRegisterYear.text.toString() + "-" + binding.etRegisterMonth.text.toString() + "-" + binding.etRegisterDay.text.toString()


            val sex = if (binding.etRegisterGender.text.toString() == "여자") {
                "FEMALE"
            } else if (binding.etRegisterGender.text.toString() == "남자") {
                "MALE"
            } else {
                Toast.makeText(
                    this@RegisterActivity, "성별을 다시 입력해주세요", Toast.LENGTH_SHORT
                ).show()

            }
            val account_id = binding.etRegisterId.text.toString()
            val password = binding.etRegisterPassword.text.toString()

            if (nickname == "" || birth_date == "" || sex == "" || account_id == "" || password == "") Toast.makeText(
                this@RegisterActivity, "회원 정보를 다시 입력해주세요", Toast.LENGTH_SHORT
            ).show()
            else {
                ApiProvider.retrofit.register(
                    RegisterRequest(
                        nickname, birth_date, sex.toString(), account_id, password
                    )
                ).enqueue(object : retrofit2.Callback<Void> {
                    override fun onResponse(call: Call<Void>, response: Response<Void>) {
                        when (response.code()) {
                            201 -> {
                                startActivity(intent)
                                Toast.makeText(
                                    this@RegisterActivity, "회원가입을 성공했습니다!", Toast.LENGTH_SHORT
                                ).show()
                                Log.d("dsafsafsfsaf", response.code().toString())
                            }

                            else -> {
                                Toast.makeText(
                                    this@RegisterActivity, "회원가입에 실패했습니다..", Toast.LENGTH_SHORT
                                ).show()
                                Log.d("dsafsafsfsaf", response.code().toString())
                            }
                        }
                    }

                    override fun onFailure(call: Call<Void>, t: Throwable?) {
                        Toast.makeText(this@RegisterActivity, "회원가입에 실패했습니다..", Toast.LENGTH_SHORT)
                            .show()
                        Log.d("dsafsafsfsaf", t?.message.toString())
                    }

                })
            }
        }
    }
}