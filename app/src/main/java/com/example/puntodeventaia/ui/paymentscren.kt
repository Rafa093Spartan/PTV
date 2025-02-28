import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.SignalWifi4Bar

@Composable
fun PaymentScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TopBar()
        Spacer(modifier = Modifier.height(16.dp))
        PaymentContent()
        Spacer(modifier = Modifier.weight(1f))
        BackButton()
    }
}

@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF2C3E50))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.AccountCircle,
            contentDescription = "Profile",
            tint = Color.White
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "Bienvenido\nSarah", color = Color.White, fontSize = 16.sp)
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            imageVector = Icons.Default.Menu,
            contentDescription = "Menu",
            tint = Color.White
        )
    }
}

@Composable
fun PaymentContent() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF2C3E50), shape = RoundedCornerShape(16.dp))
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Por favor, acerque su tarjeta al dispositivo",
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))
        Icon(
            imageVector = Icons.Default.SignalWifi4Bar,
            contentDescription = "Contactless Payment",
            tint = Color.White,
            modifier = Modifier.size(100.dp)
        )
    }
}

@Composable
fun BackButton() {
    Button(
        onClick = { /* Acción de regreso */ },
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF2C3E50))
    ) {
        Text("← Regresar", color = Color.White, fontSize = 16.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPaymentScreen() {
    PaymentScreen()
}
