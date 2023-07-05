package com.example.hackathonproject.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hackathonproject.R
import com.example.hackathonproject.databinding.ItemRecyclerBinding
import com.example.hackathonproject.model.Feeds
import com.example.hackathonproject.model.RecruitResponse

class RecruitAdapter(val feeds: ArrayList<Feeds>) :
    RecyclerView.Adapter<RecruitAdapter.ViewHolder>() {

    var datas = mutableListOf<Feeds>()

    inner class ViewHolder(binding: ItemRecyclerBinding) : RecyclerView.ViewHolder(binding.root) {
        private val title: TextView = itemView.findViewById(R.id.tv_item_title)
        private val content: TextView = itemView.findViewById(R.id.tv_item_content)
        private val place: TextView = itemView.findViewById(R.id.tv_item_place)
        private val date: TextView = itemView.findViewById(R.id.tv_item_date)
        private val time: TextView = itemView.findViewById(R.id.tv_item_time)
        private val submit: Button = itemView.findViewById(R.id.btn_item_submit)
        private val head_count: TextView = itemView.findViewById(R.id.tv_item_person_count)

        fun bind(item: Feeds) {
            title.text = item.title
            content.text = item.content
            place.text = item.place
            date.text = item.date
            time.text = item.meeting_time
            head_count.text = "${item.current_head_count}+/+${item.head_count}"
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecruitAdapter.ViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    override fun getItemCount(): Int {
        return datas.size
    }


}