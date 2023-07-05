package com.example.hackathonproject.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hackathonproject.R
import com.example.hackathonproject.model.RecruitData

class RecruitAdapter(private val context: Context) :
    RecyclerView.Adapter<RecruitAdapter.ViewHolder>() {

    var datas = mutableListOf<RecruitData>()

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val title: TextView = itemView.findViewById(R.id.tv_item_title)
        private val content: TextView = itemView.findViewById(R.id.tv_item_content)
        private val place: TextView = itemView.findViewById(R.id.tv_item_place)
        private val date: TextView = itemView.findViewById(R.id.tv_item_date)
        private val time: TextView = itemView.findViewById(R.id.tv_item_time)
        private val submit: Button = itemView.findViewById(R.id.btn_item_submit)

        fun bind(item: RecruitData) {
            title.text = item.title
            content.text = item.content
            place.text = item.place
            date.text = item.date
            time.text = item.time
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_recycler,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecruitAdapter.ViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    override fun getItemCount(): Int {
        return datas.size
    }


}