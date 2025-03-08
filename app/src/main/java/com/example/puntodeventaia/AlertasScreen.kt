package com.example.puntodeventaia

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlertasScreen(navController: NavController) {
    var menuOpen by remember { mutableStateOf(false) }

    ModalNavigationDrawer(
        drawerContent = {
          //  DrawerMenu { menuOpen = false }
        },
        gesturesEnabled = menuOpen
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF2F2F2)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Encabezado con botón de menú
            TopAppBar(
                title = { Text("Alertas", color = Color.White) },
                navigationIcon = {
                    IconButton(onClick = { menuOpen = true }) {
                        Icon(Icons.Default.Menu, contentDescription = "Menú", tint = Color.White)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF3D4F73))
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Contenedor principal
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .fillMaxHeight(0.75f)
                    .background(Color(0xFF3D4F73), shape = RoundedCornerShape(16.dp))
                    .padding(16.dp)
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    AlertCard(
                        title = "⚠️ Alerta de Inventario ⚠️",
                        message = "📦 Producto X ha sido registrado para venta en el punto de venta móvil. \n🔍 Verificar stock y reposición si es necesario."
                    )
                    AlertCard(
                        title = "⚠️ Aviso de Demanda ⚠️",
                        message = "📈 Se espera un aumento en las ventas de Producto Y. Considera realizar un pedido para evitar desabasto."
                    )
                    AlertCard(
                        title = "⚠️ Proyección de Ventas ⚠️",
                        message = "🔍 Se anticipa un incremento en la demanda de Producto X. Evalúa necesidades de stock."
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { navController.popBackStack() },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF253659)),
                modifier = Modifier.fillMaxWidth(0.6f)
            ) {
                Text("⬅ Regresar", fontSize = 16.sp, color = Color.White)
            }
        }
    }
}

@Composable
fun AlertCard(title: String, message: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(title, fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.Black)
            Spacer(modifier = Modifier.height(4.dp))
            Text(message, fontSize = 14.sp, color = Color.DarkGray)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AlertasScreenPreview() {
    AlertasScreen(navController = rememberNavController())
}
