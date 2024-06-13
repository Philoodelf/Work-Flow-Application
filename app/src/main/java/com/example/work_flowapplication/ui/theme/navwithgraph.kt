package com.example.work_flowapplication.ui.theme

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.work_flowapplication.Search
import com.example.work_flowapplication.SendAlert
import com.example.work_flowapplication.ui.location.location

@Composable
/*
fun navwitpadding(navController: NavHostController,modifier: Modifier){

    NavHost(navController = navController, startDestination =Screens.login.route , route =Screens.admin.route  ){
        composable( Screens.login.route) { loginsereen(navController) }

composable(route = Screens.Home.route){ Home(modifier = modifier)}
composable(route=Screens.Requests.route){ Request(modifier = modifier) }
composable(route=Screens.Dashboard.route){ Dashboard(modifier = modifier,navController)}
        composable(route=Screens.Report.route){ com.example.work_flowapplication.Report(modifier = modifier) }
        composable(route=Screens.Profile.route){ Profile(modifier = modifier) }
       /* navwithoutpadding(navController)*/
    }
    }*/

fun NavGraphBuilder.navwithoutpadding(navController: NavHostController){


navigation(startDestination = SecondScreen.login.route, route =SecondScreen.SendAlertDestination.route){
    composable( route=SecondScreen.login.route) { loginsereen(navController) }

    composable(route = SecondScreen.SendAlert.route){ SendAlert(navController) }
    composable(route = SecondScreen.Search.route){ Search(navController) }
    composable(route = SecondScreen.Addemployee.route){ AddEmployee(navController) }
    composable(route = SecondScreen.Editeployee.route){ editProfilePage(navController) }
    composable(route = SecondScreen.Timetrack.route){ calender(navController) }
    composable(route = SecondScreen.CreateTask.route){ moadlbottomsheettask(navController) }
    composable(route = SecondScreen.location.route){ location(navController) }



}

}
sealed class SecondScreen(val route:String){
    object SendAlertDestination : SecondScreen("SendAlertDestination")
    object SendAlert :SecondScreen ("Send Alert")
    object Search : SecondScreen("Search")

    object Addemployee: SecondScreen("Addemployee")
    object Editeployee: SecondScreen("Editeployee")

    object Timetrack: SecondScreen("Timetrack")

    object CreateTask: SecondScreen("CreateTask")
    object location: SecondScreen("location")

    object login: SecondScreen("login")
    object homeadmine: SecondScreen("homeadmine")

}










