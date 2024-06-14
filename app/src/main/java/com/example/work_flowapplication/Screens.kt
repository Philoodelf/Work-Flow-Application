package com.example.work_flowapplication

//sealed class Screens(val screen: String) {
//  data class Home(val title: String = "Home") : Screens(title)
//  data class Requests(val title: String = "Requests") : Screens(title)
//  data class Dashboard(val title: String = "Dashboard") : Screens(title)
//  data class Report(val title: String = "Report") : Screens(title)
//  data class Profile(val title: String = "Profile") : Screens(title)
//}
sealed class Screens(val route: String) {
  object Home : Screens("Home")
  object Requests : Screens("Requests")
  object Dashboard : Screens("Dashboard")
  object Report : Screens("Report")
  object Profile : Screens("Profile")
  object SendAlert : Screens("Send Alert")
  object Search : Screens("Search")

  object admin: Screens("admin")

  object login: Screens("login")
  object SendAlertDestination : Screens("SendAlertDestination")


  object Addemployee: Screens("Addemployee")
  object Editeployee: Screens("Editeployee")

  object Timetrack: Screens("Timetrack")

  object CreateTask: Screens("CreateTask")
  object location: Screens("location")
  object employee: Screens("employee")

}

