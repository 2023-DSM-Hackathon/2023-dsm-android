package com.example.hackathonproject.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hackathonproject.R
import com.example.hackathonproject.api.ApiProvider
import com.example.hackathonproject.databinding.FragmentReviewBinding
import com.example.hackathonproject.model.GetReviewResponse
import com.example.hackathonproject.model.RecruitResponse
import com.example.hackathonproject.util.ACCESS_TOKEN
import retrofit2.Call
import retrofit2.Response


@Suppress("UNREACHABLE_CODE")
class ReviewFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentReviewBinding.inflate(inflater, container, false)

        binding.rvReview.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

        binding.fabReviewSubmit.setOnClickListener {
            var intent = Intent(activity, ReviewSubmitActivity::class.java)
            startActivity(intent)
        }

        ApiProvider.retrofit.getReviews(ACCESS_TOKEN).enqueue(object : retrofit2.Callback<GetReviewResponse> {
            override fun onResponse(
                call: Call<GetReviewResponse>, response: Response<GetReviewResponse>
            ) {
                when (response.code()) {
                    200 -> {
                        Log.d("dsfafdsfdsfas", response.body().toString())
                        binding.rvReview.adapter = ReviewAdapter(GetReviewResponse(reviews = response.body()!!.reviews))
                        binding.rvReview.adapter?.notifyItemChanged(response.body()!!.reviews.size)
                    }
                    else -> {
                        Log.d("dsfafdsfdsfas", response.body().toString())
                    }
                }
            }
            override fun onFailure(call: Call<GetReviewResponse>, t: Throwable) {

            }
        })
        return binding.root


    }
}