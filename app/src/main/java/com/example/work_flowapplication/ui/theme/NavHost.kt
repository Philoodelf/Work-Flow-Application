package com.example.work_flowapplication.ui.theme

import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.work_flowapplication.Screens
import com.example.work_flowapplication.buttonnav

@Composable
fun NavHostSetup(context1:AppCompatActivity) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.login.route,
    ) {

        composable( Screens.login.route) { loginsereen(navController) }
        composable( Screens.admin.route) { buttonnav() }
        composable( Screens.employee.route) { home(context1) }

       /* navwithoutpadding(navController)*/


       /*



        composable(Screen_employee.homeadmin.route) { buttonnav(navController) }

*/
    }
}
/*
object graph {
    const val root = "Root"
    const val auth = "auth"
    const val withpadding = "withpadding"
    const val withoutpadding = "withoutpadding"
    const val homm= "homm"
    const val login= "login"
}
*/