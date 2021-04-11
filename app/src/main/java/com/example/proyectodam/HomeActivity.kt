package com.example.proyectodam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

enum class ProviderType {
    CORREO
    //SE SEGUIRÁN AÑADIENDO PROVEEDORES
}

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }
}