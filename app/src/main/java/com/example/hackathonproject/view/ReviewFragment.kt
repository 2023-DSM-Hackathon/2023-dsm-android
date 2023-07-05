package com.example.hackathonproject.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hackathonproject.R
import com.example.hackathonproject.databinding.FragmentReviewBinding


class ReviewFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentReviewBinding.inflate(inflater, container, false)

        binding.fabReviewSubmit.setOnClickListener {
            var intent = Intent(activity, ReviewSubmitActivity::class.java)
            startActivity(intent)
        }

        return binding.root
    }
}