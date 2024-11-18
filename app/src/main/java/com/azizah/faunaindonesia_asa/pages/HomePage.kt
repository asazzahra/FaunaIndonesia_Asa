package com.azizah.faunaindonesia_asa.pages

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.azizah.faunaindonesia_asa.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(modifier: Modifier = Modifier) {
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
                text = "FaunaIndonesia",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            )},

            colors = androidx.compose.material3.TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = (Color(0xFFD0FFD2)),
                titleContentColor = (Color(0xFF00A600))
            )
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            Text("Hi, welcome to the world of fauna 👋", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = (Color(0xFF303030)))
            Text("Azizah, Informatika", fontSize = 14.sp, color = (Color(0xFF303030)))

            Spacer(modifier = Modifier.height(16.dp))

            Image(
                painter = painterResource(id = R.drawable.banner),
                contentDescription = "Pembuka",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(16.dp))


            Text("Indonesia has a variety of fauna", fontSize = 16.sp, fontWeight = FontWeight.SemiBold, color = (Color(
                0xFF303030
            )))
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(vertical = 8.dp)

            ) {
                val regions = listOf("Jawa", "Sumatra", "Kalimantan", "Bali", "Sulawesi", "Nusa Tenggara Timur", "Papua", "Aceh", "Lampung", "Bengkulu", "Maluku")
                items(regions.size) { index ->
                    Box(
                        modifier = Modifier
                            .background(
                                color = Color(0xFF00A600),
                                shape = RoundedCornerShape(0.dp)
                            )
                            .border(
                                BorderStroke(1.dp, Color.White),
                                shape = RoundedCornerShape(0.dp)
                            )
                            .padding(horizontal = 16.dp, vertical = 8.dp)
                    ) {
                        Text(
                            text = regions[index],
                            color = (Color(0xFFFFFFFF)),
                            textAlign = TextAlign.Center)
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text("Explore the fauna in Indonesia", fontSize = 16.sp, fontWeight = FontWeight.SemiBold, color = (Color(0xFF303030)))
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                val faunaList = listOf(
                    Triple(R.drawable.gambar6, "Harimau", "Jambi"),
                    Triple(R.drawable.gambar1, "Burung Jalak Bali", "Bali"),
                    Triple(R.drawable.gambar10, "Gajah", "Lampung"),
                    Triple(R.drawable.gambar2, "Orang Utan", "Nusa Tenggara Timur"),
                    Triple(R.drawable.gambar3, "Burung Cendrawasih", "Papua"),
                    Triple(R.drawable.gambar5, "Komodo", "Nusa Tenggara Timur"),
                    Triple(R.drawable.gambar8, "Tarsius Kerdil", "Sulawesi Tengah"),
                    Triple(R.drawable.gambar9, "Monyet Hitam", "Sulawesi Utara"),
                    Triple(R.drawable.gambar4, "Badak Cula Satu", "Banten"),
                    Triple(R.drawable.gambar11, "Anoa", "Sulawesi Tenggara"),
                    Triple(R.drawable.gambar12, "Beruang Madu", "Bengkulu"),
                    Triple(R.drawable.gambar7, "Burung Maleo", "Gorontalo dan Sulawesi Tengah")

                )

                items(faunaList.size) { index ->
                    val (imageResId, faunaName, faunaRegion) = faunaList[index]
                    FaunaItemCard(imageResId = imageResId, faunaName = faunaName, faunaRegion = faunaRegion)
                }
            }

        }
    }

}

@Composable
fun FaunaItemCard(imageResId: Int, faunaName: String, faunaRegion: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, shape = RoundedCornerShape(16.dp))
            .border(BorderStroke(2.dp, Color(0xFF00A600)), shape = RoundedCornerShape(0.dp))
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = faunaName,
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(0.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(faunaName, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color(0xFF303030))
                Text(faunaRegion, fontSize = 14.sp, color = Color.Gray)
                Text("Detail Info", fontSize = 14.sp, color = Color.Blue)
            }
        }
    }
}

