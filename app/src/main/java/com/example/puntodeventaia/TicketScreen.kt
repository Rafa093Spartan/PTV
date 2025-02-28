package com.example.puntodeventaia

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TicketScreen(navController: NavController) {
    var menuOpen by remember { mutableStateOf(false) }

    ModalNavigationDrawer(
        drawerContent = {
            DrawerMenu { menuOpen = false }
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
                title = { Text("Ticket", color = Color.White) },
                navigationIcon = {
                    IconButton(onClick = { menuOpen = true }) {
                        Icon(Icons.Default.Menu, contentDescription = "Menú", tint = Color.White)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF3D4F73))
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Botones superiores
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                TicketButton("📷", "Cámara") { /* Acción cámara */ }
                TicketButton("📄", "Barcode") { /* Acción código de barras */ }
                TicketButton("⌨", "Teclado") { /* Acción teclado */ }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Contenedor principal
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .background(Color(0xFF3D4F73), shape = RoundedCornerShape(16.dp))
                    .padding(24.dp),
                contentAlignment = Alignment.Center
            ) {
                Column {
                    Text("Ticket #XXXX", fontSize = 20.sp, color = Color.White)
                    Text(
                        "Informacion de la tienda como direccion entre otros",
                        fontSize = 14.sp, color = Color.White
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    repeat(3) {
                        ListItem("List item", "100+")
                        Spacer(modifier = Modifier.height(8.dp))
                    }

                    Spacer(modifier = Modifier.height(16.dp))
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        Button(onClick = { /* Acción cancelar */ }) {
                            Text("Cancelar")
                        }
                        Button(onClick = { /* Acción cobrar */ }) {
                            Text("Cobrar")
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))
                    Text("Costo total:      \$XXXX.XX", fontSize = 14.sp, color = Color.White)
                    Text("IVA incluido:   \$XXXX.XX", fontSize = 14.sp, color = Color.White)
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
fun TicketButton(icon: String, label: String, onClick: () -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Button(
            onClick = onClick,
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3D4F73)),
            modifier = Modifier.size(80.dp)
        ) {
            Text(icon, fontSize = 24.sp, color = Color.White)
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(label, fontSize = 12.sp, color = Color.Black)
    }
}

@Composable
fun ListItem(title: String, quantity: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("🔵 $title", fontSize = 16.sp, color = Color.White)
        Text(quantity, fontSize = 16.sp, color = Color.White)
        Checkbox(checked = true, onCheckedChange = {})
    }
}

@Preview(showBackground = true)
@Composable
fun TicketScreenPreview() {
    TicketScreen(navController = rememberNavController())
}