package com.example.second_lab

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.second_lab.ActivityFragment
import com.example.second_lab.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class CoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.core_layout)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val fragmentActivity = ActivityFragment.newInstance("", "")
        val fragmentProfile = ProfileFragment.newInstance("", "")

        supportFragmentManager.beginTransaction().apply {
            add(R.id.fragmentContainerView, fragmentActivity, "activity")
            add(R.id.fragmentContainerView, fragmentProfile, "profile")
            hide(fragmentProfile)
            commit()
        }

        findViewById<BottomNavigationView>(R.id.bottomNavigationView).setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.item_1 -> {
                    supportFragmentManager.beginTransaction().apply {
                        show(fragmentActivity)
                        hide(fragmentProfile)
                        commit()
                    }
                    true
                }

                R.id.item_2 -> {
                    supportFragmentManager.beginTransaction().apply {
                        show(fragmentProfile)
                        hide(fragmentActivity)
                        commit()
                    }
                    true
                }
                else -> false
            }
        }
    }
}