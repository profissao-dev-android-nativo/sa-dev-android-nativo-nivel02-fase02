package com.salvatoreacademy.sa_dev_android_nativo_nivel02_fase02

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

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

            Toast.makeText(this, getString(R.string.updated_successfully), Toast.LENGTH_SHORT).show()
        }

        btClear.setOnClickListener {
            val oldText = tvResult.text

            tvResult.text = null
            etName.text = null

            val constraintLayout = findViewById<View>(R.id.constraintLayout)
            Snackbar.make(constraintLayout,
                getString(R.string.cleared_successfully), Snackbar.LENGTH_INDEFINITE)
                .setAction(getString(R.string.undo)) {
                    tvResult.text = oldText
                    etName.setText(oldText)

                    Toast.makeText(this, getString(R.string.text_reverted), Toast.LENGTH_SHORT).show()
                }
                .show()
        }
    }
}
