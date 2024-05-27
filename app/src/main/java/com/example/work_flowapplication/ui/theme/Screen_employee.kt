package com.example.work_flowapplication.ui.theme

import com.example.work_flowapplication.Screens

sealed class Screen_employee(val route:String){
 object home:Screen_employee("home")
 object Request:Screen_employee("Request")
 object  Task:Screen_employee("Task")
 object Report:Screen_employee("Report")
 object Profile:Screen_employee("Profile")
 object clockin:Screen_employee("clockin")

 object login:Screen_employee("login")
 object editemployee: Screen_employee("editemployee")
}
