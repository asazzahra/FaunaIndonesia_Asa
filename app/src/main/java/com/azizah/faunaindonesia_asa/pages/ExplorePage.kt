package com.azizah.faunaindonesia_asa.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.azizah.faunaindonesia_asa.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExplorePage(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFD0FFD2))
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = "Explore",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                )
            },
            colors = androidx.compose.material3.TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = (Color(0xFFD0FFD2)),
                titleContentColor = Color(0xFF00A600)
            )
        )

        Spacer(modifier = Modifier.height(10.dp))

        SearchBar()

        Spacer(modifier = Modifier.height(20.dp))

        ImageGrid()
    }
}

@Composable
fun SearchBar() {
    OutlinedTextField(
        value = "",
        onValueChange = { },
        placeholder = { Text("Search") },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search Icon"
            )
        },
        shape = RoundedCornerShape(25.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
    )
}

@Composable
fun ImageGrid() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 16.dp)
    ) {
        items(10) { index ->
            val resourceId = when (index % 10) {
                0 -> R.drawable.gambar1
                1 -> R.drawable.gambar2
                2 -> R.drawable.gambar3
                3 -> R.drawable.gambar4
                4 -> R.drawable.gambar5
                5 -> R.drawable.gambar6
                6 -> R.drawable.gambar7
                7 -> R.drawable.gambar8
                8 -> R.drawable.gambar9
                else -> R.drawable.gambar10
            }
            val description = when (index % 10) {
                0 -> "Burung Jalak Putih"
                1 -> "Orang Utan"
                2 -> "Burung Cendrawasih"
                3 -> "Badak Cula Satu"
                4 -> "Komodo"
                5 -> "Harimau"
                6 -> "Burung Maleo"
                7 -> "Tarsius Kerdil"
                8 -> "Monyet Hitam"
                else -> "Gajah"
            }
            ImageItem(resourceId = resourceId, description = description)
        }
    }
}

@Composable
fun ImageItem(resourceId: Int, description: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(8.dp)

    ) {
        Image(
            painter = painterResource(id = resourceId),
            contentDescription = description,
            modifier = Modifier
                .size(120.dp)
                .clip(RoundedCornerShape(0.dp))
        )
        Text(
            text = description,
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

