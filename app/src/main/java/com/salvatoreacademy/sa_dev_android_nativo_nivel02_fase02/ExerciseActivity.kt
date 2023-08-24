package com.salvatoreacademy.sa_dev_android_nativo_nivel02_fase02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ExerciseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise)

        val tvResult = findViewById<TextView>(R.id.tvResult)
        val etEmail = findViewById<TextView>(R.id.etEmail)
        val btSend = findViewById<TextView>(R.id.btSend)

        btSend.setOnClickListener {
            val email = etEmail.text.toString()

            tvResult.text = email
        }
    }
}
