package com.example.hackathonproject.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import com.example.hackathonproject.R
import com.example.hackathonproject.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    private val frameLayout: FrameLayout by lazy {
        findViewById(R.id.frameLayout)
    }

    private val bottomNav: BottomNavigationView by lazy {
        findViewById(R.id.bottomNav)
    }
    private lateinit var binding: ActivityMainBinding

    private lateinit var recruitFragment: RecruitFragment
    private lateinit var reviewFragment: ReviewFragment
    private lateinit var profileFragment: ProfileFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.bottomNav.setOnNavigationItemSelectedListener(onBottomNavigationSelectedListener)

    }

    override fun onResume() {
        super.onResume()
        supportFragmentManager.beginTransaction().replace(R.id.frameLayout, RecruitFragment()).commit()
    }

    private val onBottomNavigationSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {
        when(it.itemId) {
            R.id.menu_recruit -> {
                recruitFragment = RecruitFragment()
                supportFragmentManager.beginTransaction().replace(R.id.frameLayout, recruitFragment).commit()
            }
            R.id.menu_review -> {
                reviewFragment = ReviewFragment()
                supportFragmentManager.beginTransaction().replace(R.id.frameLayout, reviewFragment).commit()
            }
            R.id.menu_profile -> {
                profileFragment = ProfileFragment()
                supportFragmentManager.beginTransaction().replace(R.id.frameLayout, profileFragment).commit()
            }
        }
        true
    }
}