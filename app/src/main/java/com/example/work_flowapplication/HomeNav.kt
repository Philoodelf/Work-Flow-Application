package com.example.work_flowapplication

import android.os.Bundle
import android.text.style.BackgroundColorSpan
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.ColumnScopeInstance.weight
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ElevatedCard
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
import androidx.compose.material3.TopAppBarColors
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
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.work_flowapplication.ui.theme.WorkFlowApplicationTheme
import com.example.work_flowapplication.ui.theme.blue
import com.example.work_flowapplication.ui.theme.ll
import com.joelkanyi.horizontalcalendar.HorizontalCalendarView
import kotlinx.coroutines.launch

class HomeNav : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WorkFlowApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background

                ) {
                    Greeting("Android")
                    buttonnav()


                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun buttonnav() {
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
 val navigationController = rememberNavController()
    var title=""
    val context = LocalContext.current.applicationContext
//    val selected = remember {
//        mutableStateOf(Icons.Default.Home)
//    }
    var selected by remember {
        mutableStateOf("home")
    }
    Scaffold(

        topBar = {


            val navBackStackEntry by navigationController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
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

                )
        },

//        bottomBar ={
//        BottomAppBar(containerColor = Color(0xFF029DF0), modifier = Modifier
//            .padding(horizontal = 5.dp)
//            .clip(shape = RoundedCornerShape(16.dp)),
//
//        ){
//        bottomBar = {
//
//            NavigationBar(containerColor = Color.White) {
//                val iconcolour=Color(0xFF1E7DFF)
//
//
//
//                    }
//            // Home
//            IconButton(onClick = {
//                selected.value=Icons.Default.Home
//                navigationController.navigate(Screens.Home.route){
//                    popUpTo(0)
//                }
//            },
//                modifier = Modifier
//                 //   .weight(1f)
//                ) {
//                Icon( Icons.Default.Home , contentDescription = null, modifier = Modifier.size(32.dp),
//
//                   tint = if(selected.value== Icons.Default.Home) Color.White else Color(0xFF016DA8))
//                    Text(text = "Home", fontWeight = FontWeight.SemiBold, modifier=Modifier.padding(top = 23.dp))
//            }
//                //Requests
//            IconButton(onClick = {
//                selected.value=Icons.Default.Star
//                navigationController.navigate(Screens.Requests.route){
//                    popUpTo(0)
//                }
//            },
//           //     modifier = Modifier.weight(1f)
//            ) {
//               // Icon(imageVector = R.drawable., contentDescription =null )
//                Image(
//                    painter = painterResource(id = R.drawable.requests), contentDescription = null, modifier = Modifier.size(32.dp),
//                   colorFilter = ColorFilter.tint( if(selected.value== Icons.Default.Star) Color.White else Color(0xFF016DA8)))
//                Text(text = "Request", fontWeight = FontWeight.SemiBold, modifier=Modifier.padding(top = 23.dp))
//
//            }
//               //Dashboard
//            IconButton(onClick = {
//                selected.value=Icons.Default.DateRange
//                navigationController.navigate(Screens.Dashboard.route){
//                    popUpTo(0)
//                }
//            },
//              //  modifier = Modifier.weight(1f)
//            ) {
//                Image(
//                    painter = painterResource(id = R.drawable.dashboard), contentDescription = null, modifier = Modifier.size(32.dp),
//                    colorFilter = ColorFilter.tint(if(selected.value== Icons.Default.DateRange) Color.White else Color(0xFF016DA8)))
//                Text(text = "Dashboard", fontWeight = FontWeight.SemiBold, modifier=Modifier.padding(top = 23.dp))
//
//
//            }
//            //Report
//            IconButton(onClick = {
//                selected.value=Icons.Default.Warning
//                navigationController.navigate(Screens.Report.route){
//                    popUpTo(0)
//                }
//            },
//              //  modifier = Modifier.weight(1f)
//            ) {
//                Image(
//                    painter = painterResource(id = R.drawable.report), contentDescription = null, modifier = Modifier.size(32.dp),
//                    colorFilter = ColorFilter.tint(if(selected.value== Icons.Default.Warning) Color.White else Color(0xFF016DA8)))
//                Text(text = "Report", fontWeight = FontWeight.SemiBold, modifier=Modifier.padding(top = 23.dp))
//
//
//            }
//            // profile
//            IconButton(onClick = {
//                selected.value=Icons.Default.AccountCircle
//                navigationController.navigate(Screens.Profile.route){
//                    popUpTo(0)
//                }
//            },
//              //  modifier = Modifier.weight(1f)
//            ) {
//
//               // Icon( Icons.Default.AccountCircle ,
//                Image(
//                    painter = painterResource(id = R.drawable.profile), contentDescription = null, modifier = Modifier.size(32.dp),
//                    colorFilter = ColorFilter.tint(if(selected.value== Icons.Default.AccountCircle) Color.White else Color(0xFF016DA8)))
//                Text(text = "Profile", fontWeight = FontWeight.SemiBold, modifier=Modifier.padding(top = 23.dp))
//
//
//            }
//
//
//
//
//    } ) {

        bottomBar = {

            NavigationBar(containerColor = Color.White) {
                val iconcolour = Color(0xFF1E7DFF)

                NavigationBarItem(selected = selected == "home",
                    onClick = {
                        selected = "home"
                        navigationController.navigate(Screens.Home.route) {

                        }
                    },
                    icon = {


                        /*if (selected == "home") {
                            Box(
                                modifier = Modifier
                                    .width(48.dp)
                                     // Align to top

                            ) {
                            Divider(
                                color = red,
                                thickness = 8.dp,
                                modifier = Modifier.width(50.dp)
                                    .clip( shape = RoundedCornerShape(bottomEnd = 10.dp, bottomStart = 10.dp))
                                // Align to bottom
                            )}
                        }*/

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
                            color = if (selected == "home") iconcolour else ll
                        )
                    }


                )
                NavigationBarItem(selected = selected == "request",
                    onClick = {
                        selected = "request"
                        navigationController.navigate(Screens.Requests.route) {
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
                            color = if (selected == "request") iconcolour else ll
                        )
                    })


                NavigationBarItem(selected = selected == "Dashboard",
                    onClick = {
                        selected = "Dashboard"
                        navigationController.navigate(Screens.Dashboard.route) {
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
                            color = if (selected == "Dashboard") iconcolour else ll
                        )
                    })


                NavigationBarItem(selected = selected == "Report",
                    onClick = {


                        selected = "Report"
                        navigationController.navigate(Screens.Report.route) {
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
                            color = if (selected == "Report") iconcolour else ll
                        )
                    })


                NavigationBarItem(selected = selected == "Profile",
                    onClick = {
                        selected = "Profile"
                        navigationController.navigate(Screens.Profile.route) {
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
                            color = if (selected == "Profile") iconcolour else ll
                        )
                    })

            }
        }

    )
    { paddingValues ->
        NavHost(
            navController = navigationController,
            startDestination = Screens.Home.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(Screens.Home.route) { Home() }
            composable(Screens.Requests.route) { Request() }
            composable(Screens.Dashboard.route) { Dashboard(navController = navigationController) }
            composable(Screens.Report.route) { Report() }
            composable(Screens.Profile.route) { Profile() }
            composable(Screens.SendAlert.route) {
                SendAlert(
                    // navController = navigationController
                    navController = navigationController
                )
            }
            composable(Screens.Search.route) { Search(navController = navigationController) }
        }
    }}



                @Preview(showBackground = true)
                @Composable
                fun GreetingPreview3() {
                    WorkFlowApplicationTheme {
                        Greeting("Android")
                        buttonnav()

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



