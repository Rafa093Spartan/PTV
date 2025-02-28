package com.example.puntodeventaia

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InventarioScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF2F2F2)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Encabezado con menú y logo
        TopAppBar(
            title = { Text("Inventariado", color = Color.White) },
            navigationIcon = {
                IconButton(onClick = { /* Acción de menú */ }) {
                    Text("☰", fontSize = 20.sp, color = Color.White)
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF3D4F73))
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Tarjeta principal extendida y estilizada
        Box(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .fillMaxHeight(0.9f) // Ajustado al 90% de la pantalla
                .background(Color(0xFF3D4F73), shape = RoundedCornerShape(16.dp))
                .padding(24.dp), // Más padding para mejor estética
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    "Bienvenido, ¿qué desea hacer?",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(20.dp))

                // Opciones en cuadrícula mejor distribuidas
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                    DashboardButton(text = "Productos", icon = "📦")
                    DashboardButton(text = "Editar\nproductos", icon = "✏️")
                }
                Spacer(modifier = Modifier.height(20.dp))
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                    DashboardButton(text = "Alertas", icon = "⚠️")
                    DashboardButton(text = "Reportes", icon = "📊")
                }
            }
        }
    }
}

@Composable
fun DashboardButton(text: String, icon: String) {
    Card(
        modifier = Modifier
            .size(110.dp) // Un poco más grande para mejor legibilidad
            .padding(8.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp) // Sombra para resaltar
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(icon, fontSize = 28.sp, color = Color(0xFF2C3E50)) // Icono más grande
                Spacer(modifier = Modifier.height(6.dp))
                Text(text, fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color.Black)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InventarioPreview() {
    InventarioScreen(navController = rememberNavController())
}
