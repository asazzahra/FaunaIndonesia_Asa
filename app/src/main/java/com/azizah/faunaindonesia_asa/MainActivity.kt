package com.azizah.faunaindonesia_asa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.azizah.faunaindonesia_asa.ui.theme.FaunaIndonesia_AsaTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FaunaIndonesia_AsaTheme {
                MainScreen()
            }
        }
    }
}

