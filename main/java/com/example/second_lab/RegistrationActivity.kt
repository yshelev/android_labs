package com.example.second_lab

import android.content.Intent
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RegistrationActivity : AppCompatActivity() {
    lateinit var tv: TextView
    lateinit var back_iv: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registration_layout)
        supportActionBar?.hide()

        back_iv = findViewById<ImageView>(R.id.back_button)
        back_iv.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        tv = findViewById<TextView>(R.id.textView2)

        val text = tv.text.toString()
        val spanString = SpannableString(text)
        val clickable = Clickable()
        val clickable1 = Clickable()
        spanString.setSpan(clickable, 37, 97, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        spanString.setSpan(clickable1, 119, 146, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        tv.text = spanString
    }
}