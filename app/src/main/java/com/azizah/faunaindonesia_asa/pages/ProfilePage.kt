package com.azizah.faunaindonesia_asa.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutPage(
    image: Painter,
    name: String,
    role: String,
    program: String,
    email: String,
    university: String,
    department: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFD0FFD2))
            .padding(30.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CenterAlignedTopAppBar(
            title = { Text(
                text = "About",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            )},

            colors = androidx.compose.material3.TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = (Color(0xFFD0FFD2)),
                titleContentColor = (Color(0xFF00A600))
            )
        )


        Spacer(modifier = Modifier.height(20.dp))

        AboutImage(image = image)

        Spacer(modifier = Modifier.height(20.dp))

        AboutInfo(text = name)
        AboutInfo(text = role)
        AboutInfo(text = program)
        AboutInfo(text = email)
        AboutInfo(text = university)
        AboutInfo(text = department)
    }
}

@Composable
fun AboutImage(image: Painter) {
    Box(
        modifier = Modifier
            .size(150.dp)
            .background(Color(0xFF00A600), CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = image,
            contentDescription = "Profile Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(145.dp)
                .clip(CircleShape)
                .background(Color.White, CircleShape)
        )
    }
}

@Composable
fun AboutInfo(text: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp)
    ) {
        Text(
            text = text,
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Justify,
            color = (Color(0xFF303030)),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(4.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color(0xFF00A600))
        )
    }
}
