package com.salvatoreacademy.sa_dev_android_nativo_nivel02_fase02

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Encontrar os elementos de interface
        // findViewById
        //  <> -> Tipo da informação (TextView, EditText, Button etc)
        //  () -> ID da informação (R.id.tvResult etc)
        // val -> variáveis que não mudam de valor
        // var -> variáveis que podem mudar de valor
        val btSend = findViewById<Button>(R.id.btSend)
        val tvResult = findViewById<TextView>(R.id.tvResult)
        val etName = findViewById<EditText>(R.id.etName)
        val btClear = findViewById<Button>(R.id.btClear)

        // Declarar um Listener
        btSend.setOnClickListener {
            // Tudo que eu escrever dentro das chaves, será executado quando clicar no botão
            tvResult.text = etName.text.toString()

            Toast.makeText(this, "Updated successfully.", Toast.LENGTH_SHORT).show()
        }

        btClear.setOnClickListener {
            tvResult.text = null
            etName.text = null
        }
    }
}
