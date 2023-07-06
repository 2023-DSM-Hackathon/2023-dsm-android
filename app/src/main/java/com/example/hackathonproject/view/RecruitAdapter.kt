package com.example.hackathonproject.view

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hackathonproject.R
import com.example.hackathonproject.RecruitDetailActivity
import com.example.hackathonproject.databinding.ItemRecyclerBinding
import com.example.hackathonproject.model.Feeds
import com.example.hackathonproject.model.RecruitResponse

class RecruitAdapter(val feeds: RecruitResponse) :
    RecyclerView.Adapter<RecruitAdapter.ViewHolder>() {


    class ViewHolder(val binding: ItemRecyclerBinding) : RecyclerView.ViewHolder(binding.root) {


        private val submit: Button = itemView.findViewById(R.id.btn_item_submit)
        fun bind(item: RecruitResponse, position: Int) {
            submit.setOnClickListener {
                val intent = Intent(it.context, RecruitDetailActivity::class.java)
                it.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvItemTitle.text = feeds.feeds[position].title
        holder.binding.tvItemContent.text = feeds.feeds[position].content
        holder.binding.tvItemDate.text = "모집 날짜 : ${feeds.feeds[position].date}"
        holder.binding.tvItemPlace.text = "장소 : ${feeds.feeds[position].place}"
        holder.binding.tvItemTime.text = "모집 시간 : ${feeds.feeds[position].meeting_time}"
        holder.binding.tvItemPersonCount.text =
            " ${feeds.feeds[position].current_head_count}/${feeds.feeds[position].head_count}"
    }

    override fun getItemCount(): Int {
        return feeds.feeds.size
    }

    fun setData(newList: RecruitResponse) {
        feeds.feeds = newList.feeds
        // 새로고침
    }
}