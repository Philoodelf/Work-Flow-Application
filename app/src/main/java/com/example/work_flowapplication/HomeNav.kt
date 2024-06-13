package com.example.work_flowapplication

//import androidx.compose.foundation.layout.ColumnScopeInstance.weight
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.work_flowapplication.ui.location.location
import com.example.work_flowapplication.ui.theme.AddEmployee
import com.example.work_flowapplication.ui.theme.WorkFlowApplicationTheme
import com.example.work_flowapplication.ui.theme.calender
import com.example.work_flowapplication.ui.theme.editProfilePage
import com.example.work_flowapplication.ui.theme.ll
import com.example.work_flowapplication.ui.theme.moadlbottomsheettask
import kotlinx.coroutines.launch

class HomeNav : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WorkFlowApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background

                ) {



                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun buttonnav() {

    val navigationController = rememberNavController()
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    var title=""
    val context = LocalContext.current.applicationContext
//    val selected = remember {
//        mutableStateOf(Icons.Default.Home)
//    }

    Scaffold(
        topBar = {
            val navBackStackEntry by navigationController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            if (currentRoute == Screens.Home.route ||
                currentRoute == Screens.Requests.route ||
                currentRoute==Screens.Report.route||
                currentRoute==Screens.Profile.route||
                currentRoute==Screens.Dashboard.route
            ) {

            val title = remember { mutableStateOf("Home") }

            when (currentRoute) {
                Screens.Home.route -> title.value = "Home"
                Screens.Requests.route -> title.value = "Requests"
                Screens.Dashboard.route -> title.value = "Dashboard"
                Screens.Report.route -> title.value = "Report"
                Screens.Profile.route -> title.value = "Profile"
                Screens.SendAlert.route -> title.value = "Send Alert"
                Screens.Search.route -> title.value = "Search"
                else -> title.value = "Home" // Default title
            }

            TopAppBar(
                title = {
                    Box(modifier = Modifier.fillMaxWidth(),
                        Alignment.Center){
                        Text(text = title.value,textAlign = TextAlign.Center, color = Color.White ,
                            fontWeight = FontWeight.Bold, fontFamily = FontFamily.Default
                        )
                    }
                   },
               modifier = Modifier
                   .padding(horizontal = 16.dp, vertical = 10.dp)
                   .clip(shape = RoundedCornerShape(16.dp))
                   .shadow(elevation = 8.dp)
                   .fillMaxWidth(),

                  // .background(color = Color(0xFF029DF0)) ,
                navigationIcon = {
                    //menu

                    IconButton(onClick = {
                       scope.launch {
                            drawerState.open()
                        }
                       // drawer()
                    }) {
                        Icon(imageVector = Icons.Default.Menu, contentDescription = "Icon", tint = Color.White,
                            modifier = Modifier.size(40.dp)
                        )
                   }

               },

                colors = TopAppBarDefaults.mediumTopAppBarColors(Color(0xFF029DF0),
                    contentColorFor(backgroundColor = Color(0xFFFFFFFF))
                    ),
                //notification
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.Notifications, contentDescription =null
                            ,tint = Color.White
                            , modifier = Modifier.size(32.dp)
                        )
                    }


                }

                )}
        },

        bottomBar = {
            val navBackStackEntry by navigationController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            if (currentRoute == Screens.Home.route ||
                currentRoute == Screens.Requests.route ||
                currentRoute==Screens.Report.route||
                currentRoute==Screens.Profile.route||
                currentRoute==Screens.Dashboard.route

                ) {
            bottombar(navigationController)}

        }

    )

    { paddingValues ->
        NavHost(
            navController = navigationController,
            startDestination = Screens.Home.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(route = Screens.Home.route){ Home()}
            composable(route=Screens.Requests.route){ Request() }
            composable(route=Screens.Dashboard.route){ Dashboard(navigationController)}
            composable(route=Screens.Report.route){ com.example.work_flowapplication.Report() }
            composable(route=Screens.Profile.route){ Profile() }
            composable(route = Screens.SendAlert.route){ SendAlert(navigationController) }
            composable(route = Screens.Search.route){ Search(navigationController) }
            composable(route = Screens.Addemployee.route){ AddEmployee(navigationController) }
            composable(route = Screens.Editeployee.route){ editProfilePage(navigationController) }
            composable(route = Screens.Timetrack.route){ calender(navigationController) }
            composable(route = Screens.CreateTask.route){ moadlbottomsheettask(navigationController) }
            composable(route = Screens.location.route){ location(navigationController) }

        }
      /* navwitpadding(navController,modifier = Modifier.padding(paddingValues))*/

    }}
@Composable
fun bottombar (navController: NavController){
    var selected by remember {
        mutableStateOf("home")
    }
    NavigationBar(containerColor = Color.White) {
        val iconcolour = Color(0xFF1E7DFF)

        NavigationBarItem(selected = selected == "home",
            onClick = {
                selected = "home"
                navController.navigate(Screens.Home.route) {

                }
            },
            icon = {

                Icon(
                    painter = painterResource(R.drawable.home_logo),
                    contentDescription = "",
                    modifier = Modifier
                        .size(25.dp),
                    tint = if (selected == "home") Color(0xFF1E7DFF) else ll
                )


            }, colors = androidx.compose.material3.NavigationBarItemDefaults.colors(

                indicatorColor = Color.White
            ), label = {
                Text(
                    text = "Home",
                    color = if (selected == "home") iconcolour else ll, fontSize = 10.sp
                )
            }, modifier = Modifier.weight(1f)


        )
        NavigationBarItem(selected = selected == "request",
            onClick = {
                selected = "request"
                navController.navigate(Screens.Requests.route) {
                    popUpTo(0)
                }

            },
            icon = {
                Icon(
                    painter = painterResource(R.drawable.requests),
                    contentDescription = "",
                    modifier = Modifier.size(25.dp),


                    tint = if (selected == "request") iconcolour else ll
                )
            }, colors = androidx.compose.material3.NavigationBarItemDefaults.colors(

                indicatorColor = Color.White
            ),

            label = {
                Text(
                    text = "Request",
                    color = if (selected == "request") iconcolour else ll, fontSize = 10.sp
                )
            }, modifier = Modifier.weight(1f))


        NavigationBarItem(selected = selected == "Dashboard",
            onClick = {
                selected = "Dashboard"
                navController.navigate(Screens.Dashboard.route) {
                    popUpTo(0)
                }

            },
            icon = {
                Icon(
                    painter = painterResource(R.drawable.dashboard),
                    contentDescription = "",
                    modifier = Modifier.size(25.dp),
                    tint = if (selected == "Task") iconcolour else ll
                )
            }, colors = androidx.compose.material3.NavigationBarItemDefaults.colors(

                indicatorColor = Color.White
            ), label = {
                Text(
                    text = "Dashboard",
                    color = if (selected == "Dashboard") iconcolour else ll ,
                    fontSize = 10.sp,
                    maxLines = 1

                )
            }, modifier = Modifier.weight(1f))


        NavigationBarItem(selected = selected == "Report",
            onClick = {


                selected = "Report"
                navController.navigate(Screens.Report.route) {
                    popUpTo(0)
                }
            },
            icon = {
                Icon(
                    painter = painterResource(R.drawable.report),
                    contentDescription = "",
                    modifier = Modifier.size(25.dp),
                    tint = if (selected == "Report") iconcolour else ll
                )
            }, colors = androidx.compose.material3.NavigationBarItemDefaults.colors(

                indicatorColor = Color.White
            ), label = {
                Text(
                    text = "Report",
                    color = if (selected == "Report") iconcolour else ll, fontSize = 10.sp
                )
            }, modifier = Modifier.weight(1f))


        NavigationBarItem(selected = selected == "Profile",
            onClick = {
                selected = "Profile"
                navController.navigate(Screens.Profile.route) {
                    popUpTo(0)
                }

            },
            icon = {
                Icon(
                    painter = painterResource(R.drawable.profile),
                    contentDescription = "",
                    modifier = Modifier.size(25.dp),
                    tint = if (selected == "Profile") iconcolour else ll
                )
            }, colors = androidx.compose.material3.NavigationBarItemDefaults.colors(

                indicatorColor = Color.White
            ), label = {
                Text(
                    text = "Profile",
                    color = if (selected == "Profile") iconcolour else ll, fontSize = 10.sp
                )
            }, modifier = Modifier.weight(1f))

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun drawer(drawerState: DrawerState) {

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(drawerContent = {
        ModalDrawerSheet {

            Column {
                Text(text = "Settings", Modifier.padding(16.dp))

                Row {
                    Text(text = "Logout", Modifier.padding(16.dp))
                }
                Row {
                    Text(text = "Change Password", Modifier.padding(16.dp))
                }
            }
        }
    }, drawerState = drawerState) {

    }
}



