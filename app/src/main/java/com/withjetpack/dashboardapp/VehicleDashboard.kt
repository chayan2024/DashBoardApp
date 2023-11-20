package com.withjetpack.dashboardapp

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class DashboardItem(val icon: ImageVector, val title: String)

val dashboardItems = listOf(
    DashboardItem(Icons.Default.Sensors, "Sensor"),
    DashboardItem(Icons.Default.Speed, "Speed"),
    DashboardItem(Icons.Default.Thermostat, "Temperature"),
    DashboardItem(Icons.Default.Timer, "Timer"),
    DashboardItem(Icons.Default.Water, "Water Level"),
    DashboardItem(Icons.Default.WbSunny, "Light"),
    DashboardItem(Icons.Default.Wifi, "Wi-Fi"),
    DashboardItem(Icons.Default.WifiOff, "No Wi-Fi"),
    // Add more items as needed
)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun VehicleDashboard() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Vehicle Dashboard",
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyVerticalGrid(
            cells = GridCells.Fixed(2), // Set the number of columns in the grid
            modifier = Modifier.fillMaxSize(),
            content = {
                items(dashboardItems) { item ->
                    DashboardItemCard(item)
                }
            }
        )
    }
}

@Composable
fun DashboardItemCard(item: DashboardItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(8.dp), // Add padding for spacing between items
        elevation = 8.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null,
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colors.primary)
                    .padding(8.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = item.title,
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
            )
        }
    }
}

@Preview
@Composable
fun VehicleDashboardPreview() {
    VehicleDashboard()
}