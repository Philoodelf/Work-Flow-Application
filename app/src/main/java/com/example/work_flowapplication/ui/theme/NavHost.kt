package com.example.work_flowapplication.ui.theme

import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.work_flowapplication.Screens
import com.example.work_flowapplication.buttonnav

@Composable
fun nav( context1: AppCompatActivity){
    val context = LocalContext.current.applicationContext
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = Screen_employee.login.route
       ){
        composable(Screen_employee.login.route){ loginsereen(navController = navController)}
        composable(Screen_employee.home.route){ home(context1)}
        composable(Screens.Home.route){ buttonnav(context1)}
        composable(Screen_employee.editemployee.route) { editProfilePage(navController = navController) }


}
    

}

/*
*   composable(Screens.login.route){ loginsereen()
*
*
*
* */