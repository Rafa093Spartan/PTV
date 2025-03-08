package com.example.puntodeventaia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.puntodeventaia.ui.LoginScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavigator()
        }
    }
}

@Composable
fun AppNavigator() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login") {
        composable("login")  { LoginScreen(navController) }
        composable("cobro")  { CobroScreen(navController) }  // Agregar la vista de cobro
        composable("ticket") { TicketScreen(navController)}
        composable("MenuPS") { MenuPrincipalScreen(navController) }
        composable("InveS") { InventarioScreen(navController) }
        composable("transa") { TransferenciaScreen(navController) }
        composable("Alertas_Screen") { AlertasScreen(navController) }
        composable("reportes") { ReportesScreen(navController) }
        composable("editar_productos") { EditarProductosScreen(navController) }



       // composable("menu")   { MenuScreen(navController)}
        }
    }

