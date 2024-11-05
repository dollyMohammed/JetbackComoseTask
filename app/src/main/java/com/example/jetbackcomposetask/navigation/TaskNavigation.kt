package com.example.jetbackcomposetask.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetbackcomposetask.Screans.ConnectScrean
import com.example.jetbackcomposetask.Screans.HomeScrean
import com.example.jetbackcomposetask.Screans.QuestionsScrean

@Composable
fun TaskNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = TaskScreans.HomeScrean.name) {
        composable(TaskScreans.HomeScrean.name){
            HomeScrean(navController = navController)
        }
        composable(TaskScreans.ConnectorScrean.name){
            ConnectScrean(navController = navController)
        }
        composable(TaskScreans.QuestionsScrean.name){
            QuestionsScrean(navController = navController)
        }



    }
}