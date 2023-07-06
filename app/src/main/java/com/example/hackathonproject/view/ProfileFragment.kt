package com.example.hackathonproject.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hackathonproject.api.ApiProvider
import com.example.hackathonproject.databinding.FragmentProfileBinding
import com.example.hackathonproject.model.UserInfoResponse
import com.example.hackathonproject.util.ACCESS_TOKEN
import retrofit2.Call
import retrofit2.Response

class ProfileFragment : Fragment() {
    lateinit var binding: FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)

        Log.d("sdfsadfsadfdsaf", ACCESS_TOKEN)

        binding.btnProfileInfo.setOnClickListener {
            var intent = Intent(activity, InfoActivity::class.java)
            startActivity(intent)
        }

        ApiProvider.retrofit.getUserInfo(ACCESS_TOKEN)
            .enqueue(object : retrofit2.Callback<UserInfoResponse> {
                override fun onResponse(
                    call: Call<UserInfoResponse>, response: Response<UserInfoResponse>
                ) {
                    when (response.code()) {
                        200 -> {
                            Log.d("sdfsafdsfsafsafsd",response.body().toString())
                            Log.d("dsfafsfsfsfasf", response.code().toString())
                            binding.tvProfileName.text = "별명 : " + response.body()!!.user_profile.nickname
                            binding.tvProfileId.text = "ID : " + response.body()!!.user_profile.account_id
                            binding.tvProfileBirth.text = "생년월일 : " + response.body()!!.user_profile.birth_date
                        }

                        else -> {
                            Log.d("dfsfasfsaf", response.code().toString())
                        }
                    }

                }

                override fun onFailure(call: Call<UserInfoResponse>, t: Throwable) {
                    print(t.message.toString())
                }

            })


        return binding.root
    }

}