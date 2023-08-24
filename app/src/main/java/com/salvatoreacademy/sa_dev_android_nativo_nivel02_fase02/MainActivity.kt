package com.salvatoreacademy.sa_dev_android_nativo_nivel02_fase02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

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
        val etName = findViewById<TextView>(R.id.etName)

        // Declarar um Listener
        btSend.setOnClickListener {
            // Tudo que eu escrever dentro das chaves, será executado quando clicar no botão
            tvResult.text = etName.text.toString()

            Toast.makeText(this, "Updated successfully.", Toast.LENGTH_SHORT).show()
        }
    }
}
