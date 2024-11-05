package com.example.jetbackcomposetask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BuildCircle
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.QuestionMark
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetbackcomposetask.Screans.ConnectScrean
import com.example.jetbackcomposetask.Screans.HomeScrean
import com.example.jetbackcomposetask.Screans.OveralScrean
import com.example.jetbackcomposetask.Screans.QuestionsScrean
import com.example.jetbackcomposetask.ui.theme.JetbackComposeTaskTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetbackComposeTaskTheme {
                MainScreen( )
                OveralScrean()
               // myApp()
                // A surface container using the 'background' color from the theme
            }
        }
    }
}






@Composable
fun MainScreen() {
    val navController = rememberNavController()
    var showTooltip by remember { mutableStateOf(true) }

    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            AppNavHost(navController)

            // Tooltip overlay
                   }
    }
}
@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { 5 }
    )
    val coroutineScope = rememberCoroutineScope()
    val loadedData = remember { mutableStateMapOf<Int, Boolean>() }
    val tooltipVisibility = remember { mutableStateMapOf<Int, Boolean>() } // للحفاظ على حالة ظهور الـ Tooltip

    // أسماء الأيقونات
    val tabs = listOf("Home", "Search", "Profile", "Settings", "More")
    val icons = listOf(
        Icons.Default.Home,
        Icons.Default.Chat,
        Icons.Default.QuestionMark,
        Icons.Default.BuildCircle,
        Icons.Default.Face
    )

    Scaffold(
        bottomBar = {
            BottomNavigation(backgroundColor = Color.White) {
                tabs.forEachIndexed { index, title ->
                    BottomNavigationItem(
                        selected = pagerState.currentPage == index,
                        onClick = {
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(index)
                                tooltipVisibility[index] = true // إظهار الـ Tooltip عند الضغط
                            }
                        },
                        icon = {
                            Box(
                                modifier = Modifier
                                    .size(48.dp)
                                    .background(Color.Transparent)
                                    .shadow(4.dp, CircleShape)
                            ) {
                                Icon(
                                    imageVector = icons[index],
                                    contentDescription = title,
                                    modifier = Modifier.align(Alignment.Center)
                                )

                                // Tooltip يظهر عند الضغط
                                if (tooltipVisibility[index] == true) {
                                    Popup(
                                        alignment = Alignment.TopCenter,
                                        offset = IntOffset(x=10, y = -60),
                                        onDismissRequest = { tooltipVisibility[index] = false }
                                    ) {
                                        Column(
                                            horizontalAlignment = Alignment.CenterHorizontally,
                                            modifier = Modifier.padding(bottom = 8.dp)
                                        ) {
                                            Box(
                                                modifier = Modifier
                                                    .background(Color.White,
                                                        shape = RoundedCornerShape(8.dp))
                                                    .border(BorderStroke(1.dp, Color.Gray),
                                                        shape = RoundedCornerShape(8.dp))
                                                    .padding(8.dp)
                                            ) {
                                                Text(
                                                    text = "This is $title",
                                                    color = Color.Black,
                                                    style = MaterialTheme.typography.bodyMedium
                                                )
                                            }

                                        }
                                    }
                                }
                            }
                        },
                        label = { Text(title, fontSize = 8.sp) }
                    )
                }
            }
        }
    ) { innerPadding ->
        // صفحات المحتوى
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding) // يضمن عدم تداخل المحتوى مع شريط التنقل السفلي
        ) { page ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFF0F0F0))
                    .padding(16.dp)
            ) {
                ContentForPage(page, navController)
            }
        }
    }

    // تحميل البيانات عند تغيير الصفحة
    LaunchedEffect(pagerState.currentPage) {
        if (loadedData[pagerState.currentPage] != true) {
            loadDataForPage(pagerState.currentPage)
            loadedData[pagerState.currentPage] = true
        }
    }
}

//@Composable
fun loadDataForPage(page: Int) {
    // اكتب هنا منطق تحميل البيانات لكل صفحة حسب page
}
data class NavItem(val label: String, val icon: ImageVector,val tooltip: String)
@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController, startDestination = "Home") {
        composable("Home") {  }
        composable("Connect") {  }
        composable("Questions") {  }
        composable("Tools") {  }
        composable("Profile") {  }
    }
}






@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainScreen()
}
@Composable
fun ContentForPage(page: Int,navController: NavHostController) {
    when (page) {
        0 -> HomeScrean(navController )
        1 -> ConnectScrean(navController)
        2 -> QuestionsScrean(navController)
        3 -> SettingsGrid()
        4 -> MoreGrid()
        else -> {
            Box(modifier = Modifier.fillMaxSize().padding(8.dp)) {
                Text("Invalid page", modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}




@Composable
fun SettingsGrid() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(10.dp)
    ) {
        items(5) { index ->
            Text("Settings Item $index", modifier = Modifier.padding(8.dp))
        }
    }
}

@Composable
fun MoreGrid() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(4),
        contentPadding = PaddingValues(10.dp)
    ) {
        items(8) { index ->
            Text("More Item $index", modifier = Modifier.padding(8.dp))
        }
    }
}


// @Preview لإظهار التصميم في المعاينة
@Composable
fun PreviewBottomNavigationBar(navController: NavHostController) {
    BottomNavigationBar(navController )
}