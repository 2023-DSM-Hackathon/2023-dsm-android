package com.example.hackathonproject.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hackathonproject.model.RecruitData
import com.example.hackathonproject.databinding.FragmentRecruitBinding

class RecruitFragment : Fragment() {

    lateinit var recruitAdapter: RecruitAdapter
    val datas = arrayListOf<RecruitData>(
        RecruitData("dsfs", "sdfsfa", "dsafass", "dfa", "dsfasa", 129),
        RecruitData("dsfs", "sdfsfa", "dsafass", "dfa", "dsfasa", 129),
        RecruitData(
            "dsfs", "sdfsfa", "dsafass", "dfa", "dsfasa", 129
        ),


        )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentRecruitBinding.inflate(inflater, container, false)

        binding.fabRecruitSubmit.setOnClickListener {
            var intent = Intent(activity, SubmitActivity::class.java)
            startActivity(intent)
        }

//        binding.rvRecruit.adapter = recruitAdapter
//
//        val lm = LinearLayoutManager(activity)
//        binding.rvRecruit.layoutManager = lm
//        binding.rvRecruit.setHasFixedSize(true)


        return binding.root
    }
}

