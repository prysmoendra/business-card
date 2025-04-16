package edu.dakode.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import edu.dakode.businesscard.ui.theme.BusinessCardTheme

import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.graphics.graphicsLayer


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BusinessCardScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun BusinessCardScreen(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.bg_businesscard),
            contentDescription = "Background",
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer(alpha = 0.5f), // 60% transparent (0.6 = 60%)
            contentScale = ContentScale.Crop
        )
        // Main content overlay on top of the background image.
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LogoNameTitleSection()
            ContactInformationSection()
        }
    }
}

@Composable
fun Surface(
    modifier: Modifier = Modifier,
    color: Color = Color.White,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier.background(color)
    ) {
        content()
    }
}

@Composable
fun LogoNameTitleSection() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Image logo
        Image(
            painter = painterResource(id = R.drawable.randomfoto),
            contentDescription = "Logo",
            modifier = Modifier
                .size(150.dp)
                .padding(bottom = 16.dp)
        )
        // Name Text
        Text(
            text = "Kris Mahendra",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 8.dp)
        )
        // Title Text
        Text(
            text = "Amateure Android Developer",
            fontSize = 18.sp,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

@Composable
fun ContactInformationSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 24.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        ContactInfoRow(icon = Icons.Default.Phone, infoText = "+62 812-3456-7890")
        ContactInfoRow(icon = Icons.Default.Share, infoText = "@dakode.id")
        ContactInfoRow(icon = Icons.Default.Email, infoText = "maskrismo@dakode.com")
    }
}


@Composable
fun ContactInfoRow(icon: ImageVector, infoText: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(8.dp)
    ) {
        CustomIcon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier,
            tint = Color(0xFF1755B4)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = infoText,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium // Apply font weight
        )
    }
}

@Composable
fun CustomIcon(
    imageVector: ImageVector,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified
) {
    Image(
        painter = rememberVectorPainter(image = imageVector), // convert ImageVector to Painter
        contentDescription = contentDescription,
        modifier = modifier,
        colorFilter = if (tint != Color.Unspecified) ColorFilter.tint(tint) else null
    )
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun BusinessCardScreenPreview() {
    BusinessCardTheme {
        BusinessCardScreen()
    }
}