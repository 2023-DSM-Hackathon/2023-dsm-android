package com.example.hackathonproject.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import com.example.hackathonproject.R
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    private val frameLayout: FrameLayout by lazy {
        findViewById(R.id.frameLayout)
    }

    private val bottomNav: BottomNavigationView by lazy {
        findViewById(R.id.bottomNav)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().add(frameLayout.id, RecruitFragment()).commit()

        bottomNav.setOnNavigationItemSelectedListener {
            supportFragmentManager.beginTransaction().replace(
                frameLayout.id, when (it.itemId) {
                    R.id.menu_recruit -> RecruitFragment()
                    R.id.menu_review -> ReviewFragment()
                    else -> ProfileFragment()
                }
            )
            true
        }
    }
}