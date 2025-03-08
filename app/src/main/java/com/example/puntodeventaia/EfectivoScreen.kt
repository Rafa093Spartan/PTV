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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EfectivoScreen(navController: NavHostController) {
    var dineroRecibido by remember { mutableStateOf("") }
    var descuento by remember { mutableStateOf("") }
    var cambio by remember { mutableStateOf("$0.00") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF2F2F2)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopAppBar(
            title = { Text("Cobro efectivo", color = Color.White) },
            colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF3D4F73))
        )

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .fillMaxHeight(0.7f)
                .background(Color(0xFF3D4F73), shape = RoundedCornerShape(16.dp))
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Total: $ XXXX.XX", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color.White)
                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = dineroRecibido,
                    onValueChange = { dineroRecibido = it },
                    label = { Text("Dinero recibido") },
                    modifier = Modifier.fillMaxWidth(0.8f),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color(0xFFF2F2F2),
                        unfocusedContainerColor = Color(0xFFF2F2F2),
                        disabledContainerColor = Color(0xFFF2F2F2)
                    )
                )
                Spacer(modifier = Modifier.height(10.dp))

                OutlinedTextField(
                    value = descuento,
                    onValueChange = { descuento = it },
                    label = { Text("Descuento (Opcional)") },
                    modifier = Modifier.fillMaxWidth(0.8f),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color(0xFFF2F2F2),
                        unfocusedContainerColor = Color(0xFFF2F2F2),
                        disabledContainerColor = Color(0xFFF2F2F2)
                    )
                )
                Spacer(modifier = Modifier.height(10.dp))

                Text("Cambio: $cambio", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.White)
                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = { /* Lógica de cobro */ },
                    modifier = Modifier.fillMaxWidth(0.8f).height(56.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF253659))
                ) {
                    Text("💵 Cobrar", fontSize = 18.sp)
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { navController.popBackStack() }, colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF253659))) {
            Text("⬅ Regresar")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EfectivoScreenPreview() {
    val navController = rememberNavController()
    EfectivoScreen(navController)
}
