package com.softyus.appdanosnotransmitibles

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnLogin = findViewById<Button>(R.id.buttonLogin1)
        //btn sung up
        val btnSingUp = findViewById<Button>(R.id.btnSingUP)

        // configurando listener para el clic
        btnLogin.setOnClickListener{funLogin()}
        btnSingUp.setOnClickListener{funSingUp()}

    }

    //función para llevar a login
    private fun funLogin(){
        val intent = Intent(this, UI.Login::class.java)
        startActivity(intent)
    }

    //función para llevar a sing up
    private fun funSingUp(){
        val intent = Intent(this, UI.singup::class.java)
        startActivity(intent)
    }
}