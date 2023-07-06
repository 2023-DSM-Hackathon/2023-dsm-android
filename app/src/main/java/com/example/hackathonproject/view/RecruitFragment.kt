package com.example.hackathonproject.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hackathonproject.api.ApiProvider
import com.example.hackathonproject.model.RecruitResponse
import com.example.hackathonproject.databinding.FragmentRecruitBinding
import com.example.hackathonproject.model.Feeds
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class RecruitFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentRecruitBinding.inflate(inflater, container, false)

        binding.rvRecruit.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)


        ApiProvider.retrofit.getFeeds().enqueue(object : retrofit2.Callback<RecruitResponse> {
            override fun onResponse(
                call: Call<RecruitResponse>, response: Response<RecruitResponse>
            ) {
                when (response.code()) {
                    200 -> {
                        binding.rvRecruit.adapter = RecruitAdapter(RecruitResponse(feeds = response.body()!!.feeds))
                        binding.rvRecruit.adapter?.notifyItemChanged(response.body()!!.feeds.size)
                    }
                }
            }
            override fun onFailure(call: Call<RecruitResponse>, t: Throwable) {
                Toast.makeText(activity, "로그인에 실패했습니다", Toast.LENGTH_SHORT).show()
            }
        })

        binding.fabRecruitSubmit.setOnClickListener {
            var intent = Intent(activity, SubmitActivity::class.java)
            startActivity(intent)
        }

        return binding.root
    }
}