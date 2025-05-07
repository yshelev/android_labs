package com.example.second_lab

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    lateinit var back_iv: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_layout)
        supportActionBar?.hide()

        back_iv = findViewById<ImageView>(R.id.back_button)
        back_iv.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.button4).setOnClickListener {
            val intent: Intent = Intent(this, CoreActivity::class.java)
            startActivity(intent)
        }
    }
}