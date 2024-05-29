package com.example.work_flowapplication.ui.theme

import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.work_flowapplication.buttonnav

@Composable
fun nav( context1: AppCompatActivity){
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = graph.auth , route = graph.root
       ){

        authnavgraph(navController)
        composable(route = graph.withoutpadding){ buttonnav(navController) }




       /* composable(Screen_employee.login.route){ loginsereen(navController = navController)}
        composable(Screen_employee.home.route){ home(context1)}
        composable(Screens.Home.route){ buttonnav()}

        */


}
    

}
object graph{
    const val root ="Root"
    const val auth ="auth"
    const val withpadding ="withpadding"
    const val withoutpadding ="withoutpadding"


}
/*
*   composable(Screens.login.route){ loginsereen()
*
*
*
* */