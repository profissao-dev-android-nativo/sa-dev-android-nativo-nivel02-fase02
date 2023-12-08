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
                etName.error = getString(R.string.insert_your_name_error)
                isValid = false
            }

            if (email.isBlank()) {
                etEmail.error = getString(R.string.insert_your_email_error)
                isValid = false
            } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                etEmail.error = getString(R.string.please_enter_a_valid_email)
                isValid = false
            }

            if (isValid) {
                tvName.text = name
                tvEmail.text = email

                Toast.makeText(this,
                    getString(R.string.inputs_updated_successfully), Toast.LENGTH_SHORT).show()
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

            Snackbar.make(constraintLayout,
                getString(R.string.cleared_successfully_2), Snackbar.LENGTH_LONG)
                .setAction(getString(R.string.undo_2)) {
                    tvName.text = name
                    tvEmail.text = email

                    etName.text = nameInput
                    etEmail.text = emailInput
                }
                .show()
        }
    }
}
