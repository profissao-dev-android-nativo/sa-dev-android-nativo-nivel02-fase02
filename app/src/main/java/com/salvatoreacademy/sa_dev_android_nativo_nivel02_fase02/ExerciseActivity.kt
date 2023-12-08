package com.salvatoreacademy.sa_dev_android_nativo_nivel02_fase02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

class ExerciseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise)

        val tvName = findViewById<TextView>(R.id.tvName)
        val etName = findViewById<EditText>(R.id.etName)
        val tvEmail = findViewById<TextView>(R.id.tvEmail)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val btSend = findViewById<Button>(R.id.btSend)
        val btClear = findViewById<Button>(R.id.btClear)
        val constraintLayout = findViewById<ConstraintLayout>(R.id.constraintLayout)

        // Button Send Behavior
        btSend.setOnClickListener {
            val name = etName.text.toString()
            val email = etEmail.text.toString()

            var isValid = true

            if (name.isBlank()) {
                etName.error = "Insert your name!"
                isValid = false
            }

            if (email.isBlank()) {
                etEmail.error = "Insert your e-mail address!"
                isValid = false
            } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                etEmail.error = "Please enter a valid e-mail address!"
                isValid = false
            }

            if (isValid) {
                tvName.text = name
                tvEmail.text = email

                Toast.makeText(this, "Inputs updated successfully!", Toast.LENGTH_SHORT).show()
            }
        }

        // Button Clear Behavior
        btClear.setOnClickListener {
            val name = tvName.text
            val email = tvEmail.text

            val nameInput = etName.text
            val emailInput = etEmail.text

            tvName.text = ""
            tvEmail.text = ""

            etName.text = null
            etEmail.text = null

            Snackbar.make(constraintLayout, "Cleared successfully!", Snackbar.LENGTH_LONG)
                .setAction("Undo") {
                    tvName.text = name
                    tvEmail.text = email

                    etName.text = nameInput
                    etEmail.text = emailInput
                }
                .show()
        }
    }
}
