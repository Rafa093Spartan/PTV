package com.example.puntodeventaia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.puntodeventaia.ui.LoginScreen
import com.example.puntodeventaia.ui.CajaScreen
import com.example.puntodeventaia.ui.theme.PuntoDeVentaIaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController() // Controlador de navegación

            PuntoDeVentaIaTheme {
                NavHost(navController = navController, startDestination = "login") {
                    composable("login") { LoginScreen(navController) }
                    composable("caja") { CajaScreen() }
                }
            }
        }
    }
}
