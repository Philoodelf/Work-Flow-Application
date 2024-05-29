package com.example.work_flowapplication.ui.theme

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.authnavgraph(navController: NavController){

navigation(route=graph.auth, startDestination = auth_Screens.login.route){
    composable(route = auth_Screens.login.route){ loginsereen(navController = navController)}

}

}
sealed class auth_Screens(val route:String){

    object home:auth_Screens("home")
    object login:auth_Screens("login")
    object Home : auth_Screens("Home")



}




