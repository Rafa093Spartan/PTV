package com.example.puntodeventaia

import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CobroScreen(navController: NavController) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerContent = {
            DrawerMenu {
                scope.launch { drawerState.close() }
            }
        },
        drawerState = drawerState
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF2F2F2)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Encabezado con botón de menú
            TopAppBar(
                title = { Text("Cobro", color = Color.White) },
                navigationIcon = {
                    IconButton(onClick = { scope.launch { drawerState.open() } }) {
                        Icon(Icons.Default.Menu, contentDescription = "Menú", tint = Color.White)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF3D4F73))
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
                        "Seleccione su\nmétodo de pago:",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(20.dp))

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            CobroButton(text = "Efectivo", icon = "💵")
                            CobroButton(text = "Tarjeta", icon = "💳")
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            CobroButton(text = "Transferencia", icon = "🏦")
                            CobroButton(text = "QR", icon = "📱")
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            CobroButton(text = "Puntos de cliente", icon = "🔘")
                            CobroButton(text = "Cartera digital", icon = "👛")
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            // Botón de regresar
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

// Menú lateral
@Composable
fun DrawerMenu(onClose: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .width(250.dp)
            .background(Color(0xFF3D4F73)),
        horizontalAlignment = Alignment.Start
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.padding(start = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.google_logo),
                contentDescription = "Perfil",
                modifier = Modifier
                    .size(40.dp)
                    .background(Color.Gray, shape = RoundedCornerShape(50))
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Sarah", color = Color.White, fontWeight = FontWeight.Bold)
        }
        HorizontalDivider(modifier = Modifier.padding(16.dp), thickness = 1.dp, color = Color.White)

        DrawerItem("📦 VENTAS", onClose)
        DrawerItem("📦 INVENTARIO", onClose)
        DrawerItem("💲 TRANSACCIONES", onClose)
        DrawerItem("👤 USUARIOS", onClose)
        DrawerItem("🛡️ POLÍTICAS DE USO", onClose)

        Spacer(modifier = Modifier.weight(1f))
        Text("BETA 1.0", fontSize = 12.sp, color = Color.LightGray, modifier = Modifier.padding(16.dp))
    }
}

// Elementos del menú
@Composable
fun DrawerItem(text: String, onClose: () -> Unit) {
    TextButton(
        onClick = onClose,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = ButtonDefaults.textButtonColors(contentColor = Color.White)
    ) {
        Text(text, fontSize = 16.sp)
    }
}

// Botón de pago
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
    CobroScreen(navController = rememberNavController())
}
