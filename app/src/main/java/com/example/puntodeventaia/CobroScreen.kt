package com.example.puntodeventaia.ui

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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CobroScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF2F2F2)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Encabezado con usuario y menú
        TopAppBar(
            title = { Text("Bienvenido\n usuario", color = Color.White, fontSize = 16.sp) },
            navigationIcon = {
                IconButton(onClick = { /* Acción de usuario */ }) {
                    Text("👤", fontSize = 24.sp, color = Color.White)
                }
            },
            actions = {
                IconButton(onClick = { /* Acción de menú */ }) {
                    Text("☰", fontSize = 24.sp, color = Color.White)
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF253659))
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Tarjeta principal
        Box(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .fillMaxHeight(0.75f)
                .background(Color(0xFF3D4F73), shape = RoundedCornerShape(16.dp))
                .padding(24.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    "Seleccione su\nmetodo de pago:",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(20.dp))

                // Opciones de pago en diseño más estructurado
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                        CobroButton(text = "Efectivo", icon = "💵")
                        CobroButton(text = "Tarjeta", icon = "💳")
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                        CobroButton(text = "Transferencia", icon = "🏦")
                        CobroButton(text = "QR", icon = "📱")
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                        CobroButton(text = "Puntos de cliente", icon = "🔘")
                        CobroButton(text = "Cartera digital", icon = "👛")
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        // Botón de regresar
        Button(
            onClick = { /* Acción de regresar */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF253659)),
            modifier = Modifier.fillMaxWidth(0.6f)
        ) {
            Text("⬅ Regresar", fontSize = 16.sp, color = Color.White)
        }
    }
}

@Composable
fun CobroButton(text: String, icon: String) {
    Card(
        modifier = Modifier
            .size(100.dp)
            .padding(8.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(icon, fontSize = 32.sp, color = Color(0xFF021140))
                Spacer(modifier = Modifier.height(6.dp))
                Text(text, fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color.Black)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CobroScreenPreview() {
    CobroScreen()
}
