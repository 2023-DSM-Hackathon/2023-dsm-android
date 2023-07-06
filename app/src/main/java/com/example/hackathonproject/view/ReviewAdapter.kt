package com.example.hackathonproject.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hackathonproject.R
import com.example.hackathonproject.databinding.ItemRecyclerBinding
import com.example.hackathonproject.databinding.ItemReviewRecyclerviewBinding
import com.example.hackathonproject.model.GetReviewResponse
import com.example.hackathonproject.model.ReviewModel


class ReviewAdapter(val reviews: GetReviewResponse) : RecyclerView.Adapter<ReviewAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ItemReviewRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewAdapter.ViewHolder {
        val binding = ItemReviewRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ReviewAdapter.ViewHolder, position: Int) {
        holder.binding.tvReviewItemTitle.text = reviews.reviews[position].title
        holder.binding.tvReviewItemContent.text = reviews.reviews[position].content
        holder.binding.tvReviewItemName.text = reviews.reviews[position].nickname
    }

    override fun getItemCount(): Int {
        val data = reviews.reviews.size
        return data
    }
}