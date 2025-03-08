package com.example.puntodeventaia

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
fun EditarProductosScreen(navController: NavHostController) {
    var productos by remember { mutableStateOf(listOf("Producto 1", "Producto 2", "Producto 3")) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF2F2F2)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Encabezado con menú y logo
        TopAppBar(
            title = { Text("CashUP", color = Color.White) },
            navigationIcon = {
                IconButton(onClick = { /* Acción de menú */ }) {
                    Text("☰", fontSize = 20.sp, color = Color.White)
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF3D4F73))
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Contenedor principal estilizado
        Box(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .fillMaxHeight(0.8f)
                .background(Color(0xFF3D4F73), shape = RoundedCornerShape(16.dp))
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                productos.forEachIndexed { index, producto ->
                    ProductoItem(nombre = producto)
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botones de acción
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { navController.popBackStack() }, colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF253659))) {
                Text("⬅ Regresar")
            }
            Button(onClick = { productos = productos + "Producto ${productos.size + 1}" }, colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF253659))) {
                Text("➕ Añadir")
            }
        }
    }
}

@Composable
fun ProductoItem(nombre: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .height(50.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(nombre, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.Black)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EditarProductosScreenPreview() {
    val navController = rememberNavController()
    EditarProductosScreen(navController)
}
