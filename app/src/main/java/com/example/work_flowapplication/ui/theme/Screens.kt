package com.example.work_flowapplication.ui.theme

sealed class Screens(val route:String){
 object home:Screens("home")
 object Request:Screens("Request")
 object  Task:Screens("Task")
 object Report:Screens("Report")
 object Profile:Screens("Profile")
 object clockin:Screens("clockin")

 object login:Screens("login")
}
