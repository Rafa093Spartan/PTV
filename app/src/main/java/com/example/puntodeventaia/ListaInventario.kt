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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListaInventario(navController: NavController) {
    var selectedProduct by remember { mutableStateOf<String?>(null) }

    ModalNavigationDrawer(
        drawerContent = {
            DrawerMenu { }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF2F2F2)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TopAppBar(
                title = { Text("Inventario", color = Color.White) },
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(Icons.Default.Menu, contentDescription = "Menú", tint = Color.White)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF3D4F73))
            )

            Spacer(modifier = Modifier.height(16.dp))

            Column(modifier = Modifier.fillMaxWidth(0.9f)) {
                repeat(7) { index ->
                    InventarioItem(productName = "Producto ${'A' + index}", onClick = {
                        selectedProduct = "Producto ${'A' + index}"
                    })
                    Spacer(modifier = Modifier.height(8.dp))
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

        selectedProduct?.let { product ->
            InventarioPopUp(productName = product, onDismiss = { selectedProduct = null })
        }
    }
}

@Composable
fun InventarioItem(productName: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(productName, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.Black)
            Text("Cdt XX", fontSize = 16.sp, color = Color.Gray)
        }
    }
}

@Composable
fun InventarioPopUp(productName: String, onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            Button(onClick = onDismiss) {
                Text("Confirmar")
            }
        },
        title = { Text("Nombre") },
        text = {
            Column {
                Text(productName, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(8.dp))
                Text("Precio")
                Text("$189.99")
                Spacer(modifier = Modifier.height(8.dp))
                Text("Descripción")
                Text("Calidad y rendimiento en cada unidad. Perfecto para cubrir tus necesidades con eficiencia y confiabilidad.")
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun ListaInventarioPreview() {
    ListaInventario(navController = rememberNavController())
}
