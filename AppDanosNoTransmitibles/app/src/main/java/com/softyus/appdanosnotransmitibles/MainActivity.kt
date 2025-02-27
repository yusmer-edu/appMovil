package com.softyus.appdanosnotransmitibles

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsetsController
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
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

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            // Para Android 11 (API 30) y superior
            window.insetsController?.setSystemBarsAppearance(
                WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS,
                WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
            )
        } else {
            // Para versiones anteriores a Android 11
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }

        // Asegurar que el contenido no se superponga con la barra de estado
        WindowCompat.setDecorFitsSystemWindows(window, false)

        // Cambiar el color de la barra de estado
        window.statusBarColor = Color.WHITE

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