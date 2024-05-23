package com.example.work_flowapplication.ui.theme

import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun nav( context1: AppCompatActivity){
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = Screens.login.route
       ){
        composable(Screens.login.route){ loginsereen(navController = navController)}
        composable(Screens.home.route){ home(context1)}


}
    

}

/*
*   composable(Screens.login.route){ loginsereen()
*
*
*
* */