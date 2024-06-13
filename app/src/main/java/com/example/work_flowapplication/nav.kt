//package com.example.work_flowapplication
//
//import com.example.work_flowapplication.ui.theme.Screen_employee
//import com.example.work_flowapplication.ui.theme.editProfilePage
//import com.example.work_flowapplication.ui.theme.home
//import com.example.work_flowapplication.ui.theme.loginsereen
//
//import androidx.appcompat.app.AppCompatActivity
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.platform.LocalContext
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.rememberNavController
//import com.example.work_flowapplication.Screens
//import com.example.work_flowapplication.buttonnav
//
//@Composable
//fun nav( ){
//    val context = LocalContext.current.applicationContext
//    val navController = rememberNavController()
//    NavHost(navController = navController,
//        startDestination = Screen_employee.login.route
//    ){
//        composable(Screens.editemployee.route) { editProfilePage(navController = navController) }
//
//
//
//    }
//
//
//}
//
///*
//*   composable(Screens.login.route){ loginsereen()
//*
//*
//*
//* */