package com.salvatoreacademy.sa_dev_android_nativo_nivel02_fase02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class ExerciseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise)

        val tvResult = findViewById<TextView>(R.id.tvResult)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val btSend = findViewById<Button>(R.id.btSend)
        val btClear = findViewById<Button>(R.id.btClear)

        // Button Send Behavior
        btSend.setOnClickListener {
            val email = etEmail.text.toString()

            if (email.isBlank()) {
                etEmail.error = "Insert your e-mail address!"
            } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                etEmail.error = "Please enter a valid e-mail address!"
            } else {
                tvResult.text = email
            }
        }

        // Button Clear Behavior
        btClear.setOnClickListener {
            tvResult.text = ""
            etEmail.text = null
        }
    }
}
