package com.example.puntodeventaia.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.puntodeventaia.R
import com.example.puntodeventaia.ui.theme.PuntoDeVentaIaTheme

@Composable
fun LoginScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF2F2F2)), // Fondo claro
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(top = 125.dp), // Añadir espacio superior
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Logo
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo de la app",
                modifier = Modifier
                    .height(100.dp)
                    .width(200.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))

            // Campos de texto
            var email by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Correo") },
                shape = RoundedCornerShape(24.dp),
                modifier = Modifier.fillMaxWidth(0.8f)
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = password,
                shape = RoundedCornerShape(24.dp),
                onValueChange = { password = it },
                label = { Text("Contraseña") },
                modifier = Modifier.fillMaxWidth(0.8f)
            )
            Spacer(modifier = Modifier.height(16.dp))

            // Botón de inicio de sesión
            Button(
                onClick = { /* Acción de login */ },
                modifier = Modifier.fillMaxWidth(0.6f),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF001F3F))
            ) {
                Text("Entrar", color = Color.White)
            }
        }

        // Sección de botones con fondo gris limitado al 35% inferior
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.35f)
                .background(Color(0xFFE0E0E0), shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
                .padding(vertical = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                // Enlace para crear cuenta
                Row {
                    Text("Crear Cuenta", fontWeight = FontWeight.Bold, color = Color.Blue)
                }
                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "iniciar otro servicio",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    onClick = { /* Acción de login con Google */ },
                    modifier = Modifier.fillMaxWidth(0.8f),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF001F3F)),
                    shape = RoundedCornerShape(24.dp)
                ) {
                    Text("[Google Logo]", color = Color.White)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Continuar con Google", color = Color.White)
                }
                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    onClick = { /* Acción de login con Facebook */ },
                    modifier = Modifier.fillMaxWidth(0.8f),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF001F3F)),
                    shape = RoundedCornerShape(24.dp)
                ) {
                    Text("[Facebook Logo]", color = Color.White)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Continuar con Facebook", color = Color.White)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    PuntoDeVentaIaTheme {
        LoginScreen()
    }
}
