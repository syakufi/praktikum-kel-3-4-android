package com.app.latihan_jetpack

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.latihan_jetpack.ui.theme.LatihanJetpackTheme


/*
* Main Activity For a Develop Apps (Application Entry Point)
 */
class MainActivity : ComponentActivity() {

    /*
    * Function unutk mengonveride function onCreate pada Parents, untuk mengisi ui maupun logic aplikasi
     */
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        /*
            SetContent di gunakan untuk menyeting tampilan UI
         */
        setContent {

            /*
            Latihan JetpackComposeTheme adalah Tema yang telah kita buat sebelumnya
             */
            LatihanJetpackTheme {

                /*
                *
                    Scaffold di Jetpack Compose adalah komponen layout bawaan dari Material Design yang menyusun kerangka dasar tampilan aplikasi. Fungsinya mirip seperti ConstraintLayout, CoordinatorLayout, atau DrawerLayout di XML, tapi khusus dibuat untuk Compose.
                *
                 */
                Scaffold(
                    modifier = Modifier.fillMaxSize()) {
                    WelcomeScreen()
                }
            }
        }
    }
}

/*
* Function Greating sebuah fucntion berisi layout untuk menampikan Text
* Memiliki Parameter Name dengan value String, dan Modifier untuk membuat styling
 */
@Composable //Di gunakan menandai sebuah fungsi yang digunakan untuk membangun UI dengan Jetpack Compose
fun WelcomeScreen() {
    val context = LocalContext.current

    var name by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically)
    ) {

        // Teks Selamat Datang
        Text(
            text = "Selamat datang di Mobile Device Programming!",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF512DA8),
        )

        // Inputan Nama
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Masukkan Nama") },
            modifier = Modifier.fillMaxWidth()
        )

        // Tombol Custom
        Button(
            onClick = {
                Toast.makeText(context, "Halo, $name", Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF512DA8),
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("Tampilkan Toast", fontSize = 16.sp, fontWeight = FontWeight.Medium)
        }
    }
}


//Menerapkan Mode Preview
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LatihanJetpackTheme {
        WelcomeScreen()
    }
}