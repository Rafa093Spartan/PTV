package com.example.puntodeventaia

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuPrincipalScreen(navController: NavController) {
    var menuOpen by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF2F2F2)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Encabezado con botón de menú
        TopAppBar(
            title = { Text("CashUP", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold) },
            colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF3D4F73))
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Contenedor principal
        Box(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .background(Color(0xFF3D4F73), shape = RoundedCornerShape(16.dp))
                .padding(24.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Bienvenido, ¿qué desea hacer?", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.White)
                Spacer(modifier = Modifier.height(16.dp))

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                        MenuButton("📦 Ventas") { navController.navigate("ticket") }
                        MenuButton("📦 Inventario") { navController.navigate("inventario") }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                        MenuButton("💲 Transacciones") {}
                        MenuButton("👤 Usuarios") {}
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                        MenuButton("🛡️ Políticas de uso") {}
                    }
                }
            }
        }
    }
}

@Composable
fun MenuButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = Color.White),
        modifier = Modifier.size(120.dp)
    ) {
        Text(text, fontSize = 14.sp, color = Color.Black, fontWeight = FontWeight.Bold)
    }
}

@Preview(showBackground = true)
@Composable
fun MenuPrincipalScreenPreview() {
    MenuPrincipalScreen(navController = rememberNavController())
}
