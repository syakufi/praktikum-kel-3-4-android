package com.app.latihan_jetpack

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
import com.app.latihan_jetpack.ui.theme.LatihanJetpackTheme


/*
* Main Activity For a Develop Apps (Application Entry Point)
 */
class MainActivity : ComponentActivity() {

    /*
    * Function unutk mengonveride function onCreate pada Parents, untuk mengisi ui maupun logic aplikasi
     */
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
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
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
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}


//Menerapkan Mode Preview
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LatihanJetpackTheme {
        Greeting("Android")
    }
}