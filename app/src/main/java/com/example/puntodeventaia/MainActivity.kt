package com.example.puntodeventaia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.puntodeventaia.ui.LoginScreen
import com.example.puntodeventaia.ui.theme.PuntoDeVentaIaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PuntoDeVentaIaTheme {
                LoginScreen()
            }
        }
    }
}
