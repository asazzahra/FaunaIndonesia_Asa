package com.azizah.faunaindonesia_asa

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.azizah.faunaindonesia_asa.pages.AboutPage
import com.azizah.faunaindonesia_asa.pages.ExplorePage
import com.azizah.faunaindonesia_asa.pages.HomePage


@Composable
fun MainScreen() {

    val navItemList = listOf(
        NavItem("Home", Icons.Default.Home, 0),
        NavItem("Explore", Icons.Default.Search, 5),
        NavItem("About", Icons.Default.Person, 0),
    )

    var selectedIndex by remember { mutableIntStateOf(0) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
            ) {
                NavigationBar {
                    navItemList.forEachIndexed { index, navItem ->
                        NavigationBarItem(
                            selected = selectedIndex == index,
                            onClick = {
                                selectedIndex = index
                            },
                            icon = {
                                BadgedBox(badge = {
                                    if (navItem.badgeCount > 0)
                                        Badge {
                                            Text(text = navItem.badgeCount.toString())
                                        }
                                }) {
                                    Icon(
                                        imageVector = navItem.icon,
                                        contentDescription = "Icon"
                                    )
                                }
                            },
                            label = {
                                Text(
                                    text = navItem.label,
                                    color = if (selectedIndex == index) Color(0xFF00A600) else Color.Gray
                                )
                            },
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = Color(0xFF00A600),
                                unselectedIconColor = Color.Gray
                            )
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        ContentScreen(
            modifier = Modifier.padding(innerPadding),
            selectedIndex = selectedIndex
        )
    }
}

@Composable
fun ContentScreen(modifier: Modifier = Modifier, selectedIndex: Int) {
    when (selectedIndex) {
        0 -> HomePage()
        1 -> ExplorePage()
        2 -> AboutPage(
            image = painterResource(id = R.drawable.foto),
            name = "Azizah Sophia Azzahra",
            program = "Android Mobile Development & UIUX Designer",
            role = "Mentee Infinite Learning Batch 7",
            email = "asophiazzahra@gmail.com",
            university = "Universitas Muhammadiyah Sidoarjo",
            department = "Informatika"
        )
    }
}

