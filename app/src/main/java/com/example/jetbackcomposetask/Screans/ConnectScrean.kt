package com.example.jetbackcomposetask.Screans

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cake
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Female
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jetbackcomposetask.R

@Composable
fun ConnectScrean(navController: NavController){
    SearchGrid(navController)

}
@Composable
fun SearchGrid(navController: NavController) {
    Column {
        Text(text = "Suggested Study Partener:",
            fontWeight = FontWeight.Bold, color = Color.Black,
            modifier = Modifier.padding(10.dp))
        ProfileList(navController)




    }

}
@Composable
fun ProfileList(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        // قائمة البروفايل
        Column(modifier = Modifier) {
            ProfileCard()
            Spacer(modifier = Modifier.height(10.dp))

        }

    }
}
@Composable
fun ProfileCard() {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        // elevation = 4.dp,
        colors = CardDefaults.cardColors(colorResource(id = R.color.white))
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.img), // ضع الصورة هنا
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    text = "Reem Ahmed",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleLarge
                )

                // اللغات
                Row(modifier = Modifier.padding(top = 4.dp)) {
                    Text(text = "English", modifier = Modifier.padding(end = 8.dp))
                    Text(text = "Arabic", modifier = Modifier.padding(end = 8.dp))
                    Text(text = "French")
                }

                // الأيقونات
                Row(modifier = Modifier.padding(top = 8.dp)) {
                    Icon(Icons.Filled.LocationOn, contentDescription = "Location", modifier = Modifier.size(20.dp))
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(Icons.Filled.Cake, contentDescription = "Birthday", modifier = Modifier.size(20.dp))
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(Icons.Filled.Female, contentDescription = "Gender", modifier = Modifier.size(20.dp))
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(Icons.Filled.DateRange, contentDescription = "Date", modifier = Modifier.size(20.dp))
                }
            }
        }
        Spacer(modifier = Modifier.height(4.dp))

        Card(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            // elevation = 4.dp,
            colors = CardDefaults.cardColors(colorResource(id = R.color.white))
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img), // ضع الصورة هنا
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .size(64.dp)
                        .clip(CircleShape)
                )

                Spacer(modifier = Modifier.width(16.dp))

                Column {
                    Text(
                        text = "Reem Ahmed",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleLarge
                    )

                    // اللغات
                    Row(modifier = Modifier.padding(top = 4.dp)) {
                        Text(text = "English", modifier = Modifier.padding(end = 8.dp))
                        Text(text = "Arabic", modifier = Modifier.padding(end = 8.dp))
                        Text(text = "French")
                    }

                    // الأيقونات
                    Row(modifier = Modifier.padding(top = 8.dp)) {
                        Icon(Icons.Filled.LocationOn, contentDescription = "Location", modifier = Modifier.size(20.dp))
                        Spacer(modifier = Modifier.width(8.dp))
                        Icon(Icons.Filled.Cake, contentDescription = "Birthday", modifier = Modifier.size(20.dp))
                        Spacer(modifier = Modifier.width(8.dp))
                        Icon(Icons.Filled.Female, contentDescription = "Gender", modifier = Modifier.size(20.dp))
                        Spacer(modifier = Modifier.width(8.dp))
                        Icon(Icons.Filled.DateRange, contentDescription = "Date", modifier = Modifier.size(20.dp))
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(4.dp))

        Card(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            // elevation = 4.dp,
            colors = CardDefaults.cardColors(colorResource(id = R.color.white))
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img), // ضع الصورة هنا
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .size(64.dp)
                        .clip(CircleShape)
                )

                Spacer(modifier = Modifier.width(16.dp))

                Column {
                    Text(
                        text = "Reem Ahmed",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleLarge
                    )

                    // اللغات
                    Row(modifier = Modifier.padding(top = 4.dp)) {
                        Text(text = "English", modifier = Modifier.padding(end = 8.dp))
                        Text(text = "Arabic", modifier = Modifier.padding(end = 8.dp))
                        Text(text = "French")
                    }

                    // الأيقونات
                    Row(modifier = Modifier.padding(top = 8.dp)) {
                        Icon(Icons.Filled.LocationOn, contentDescription = "Location", modifier = Modifier.size(20.dp))
                        Spacer(modifier = Modifier.width(8.dp))
                        Icon(Icons.Filled.Cake, contentDescription = "Birthday", modifier = Modifier.size(20.dp))
                        Spacer(modifier = Modifier.width(8.dp))
                        Icon(Icons.Filled.Female, contentDescription = "Gender", modifier = Modifier.size(20.dp))
                        Spacer(modifier = Modifier.width(8.dp))
                        Icon(Icons.Filled.DateRange, contentDescription = "Date", modifier = Modifier.size(20.dp))
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(4.dp))

        Card(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            // elevation = 4.dp,
            colors = CardDefaults.cardColors(colorResource(id = R.color.white))
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img), // ضع الصورة هنا
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .size(64.dp)
                        .clip(CircleShape)
                )

                Spacer(modifier = Modifier.width(16.dp))

                Column {
                    Text(
                        text = "Reem Ahmed",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleLarge
                    )

                    // اللغات
                    Row(modifier = Modifier.padding(top = 4.dp)) {
                        Text(text = "English", modifier = Modifier.padding(end = 8.dp))
                        Text(text = "Arabic", modifier = Modifier.padding(end = 8.dp))
                        Text(text = "French")
                    }

                    // الأيقونات
                    Row(modifier = Modifier.padding(top = 8.dp)) {
                        Icon(Icons.Filled.LocationOn, contentDescription = "Location", modifier = Modifier.size(20.dp))
                        Spacer(modifier = Modifier.width(8.dp))
                        Icon(Icons.Filled.Cake, contentDescription = "Birthday", modifier = Modifier.size(20.dp))
                        Spacer(modifier = Modifier.width(8.dp))
                        Icon(Icons.Filled.Female, contentDescription = "Gender", modifier = Modifier.size(20.dp))
                        Spacer(modifier = Modifier.width(8.dp))
                        Icon(Icons.Filled.DateRange, contentDescription = "Date", modifier = Modifier.size(20.dp))
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(4.dp))



    }
}



