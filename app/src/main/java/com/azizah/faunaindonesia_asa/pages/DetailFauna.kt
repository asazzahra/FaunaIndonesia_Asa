package com.azizah.faunaindonesia_asa.pages

import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.azizah.faunaindonesia_asa.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailFaunaScreen() {
    val backDispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Detail Fauna")
                },
                navigationIcon = {
                    IconButton(onClick = { backDispatcher?.onBackPressed() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Kembali")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF6200EE),
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                )
            )
        }
    ) { paddingValues ->
        DetailFauna(Modifier.padding(paddingValues))
    }
}

@Composable
fun DetailFauna(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Image(
            painter = painterResource(id = R.drawable.gambar1),
            contentDescription = "Burung Jalak Bali",
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .padding(bottom = 16.dp)
        )

        // Judul dan detail informasi
        Text(
            text = "Burung Jalak Bali (Leucopsar rothschildi)",
            style = MaterialTheme.typography.headlineMedium,
            color = Color(0xFF4A148C),
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Text(
            text = "Habitat: Endemik Bali, terutama ditemukan di Taman Nasional Bali Barat",
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Ciri Fisik:",
            style = MaterialTheme.typography.bodyLarge,
            color = Color(0xFF8E24AA)
        )
        Text(
            text = "• Bulu putih bersih dengan ujung sayap dan ekor berwarna hitam",
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            text = "• Kulit biru cerah di sekitar mata",
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Kemampuan:",
            style = MaterialTheme.typography.bodyLarge,
            color = Color(0xFF8E24AA)
        )
        Text(
            text = "Mampu meniru suara burung lain, dengan vokalisasi yang beragam",
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Status Konservasi:",
            style = MaterialTheme.typography.bodyLarge,
            color = Color(0xFF8E24AA)
        )
        Text(
            text = "Hampir punah dan termasuk hewan yang dilindungi",
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Ancaman Utama:",
            style = MaterialTheme.typography.bodyLarge,
            color = Color(0xFF8E24AA)
        )
        Text(
            text = "• Perburuan liar\n• Hilangnya habitat",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

