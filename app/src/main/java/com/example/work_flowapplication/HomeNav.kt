package com.example.work_flowapplication

import android.os.Bundle
import android.text.style.BackgroundColorSpan
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.work_flowapplication.ui.theme.WorkFlowApplicationTheme
import com.example.work_flowapplication.ui.theme.blue
import com.joelkanyi.horizontalcalendar.HorizontalCalendarView

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
 val navigationController = rememberNavController()
    val context = LocalContext.current.applicationContext
    val selected = remember {
        mutableStateOf(Icons.Default.Home)
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(modifier = Modifier.fillMaxWidth(),
                        Alignment.Center){
                        Text(text = "Home",textAlign = TextAlign.Center, color = Color.White ,
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
                    IconButton(onClick = { /*TODO*/ }) {
                        
                    }

                    Icon(imageVector = Icons.Default.Menu, contentDescription = "Icon", tint = Color.White,
                        modifier = Modifier.size(40.dp)
                        )
                }, colors = TopAppBarDefaults.mediumTopAppBarColors(Color(0xFF029DF0),
                    contentColorFor(backgroundColor = Color(0xFFFFFFFF))
                    ),
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                    }
                    Icon(imageVector = Icons.Default.Notifications, contentDescription =null
                        ,tint = Color.White
                    , modifier = Modifier.size(32.dp)
                    )

                }

                )
        },

        bottomBar ={
        BottomAppBar(containerColor = Color(0xFF029DF0), modifier = Modifier
            .padding(horizontal = 5.dp)
            .clip(shape = RoundedCornerShape(16.dp))
        ){
            // Home
            IconButton(onClick = {
                selected.value=Icons.Default.Home
                navigationController.navigate(Screens.Home.route){
                    popUpTo(0)
                }
            },
                modifier = Modifier
                    .weight(1f)
                ) {
                Icon( Icons.Default.Home , contentDescription = null, modifier = Modifier.size(32.dp),

                   tint = if(selected.value== Icons.Default.Home) Color.White else Color(0xFF016DA8))
                    Text(text = "Home", fontWeight = FontWeight.SemiBold, modifier=Modifier.padding(top = 23.dp))
            }
                //Requests
            IconButton(onClick = {
                selected.value=Icons.Default.Star
                navigationController.navigate(Screens.Requests.route){
                    popUpTo(0)
                }
            },
                modifier = Modifier.weight(1f)
            ) {
               // Icon(imageVector = R.drawable., contentDescription =null )
                Icon( Icons.Default.Star , contentDescription = null, modifier = Modifier.size(32.dp),
                    tint = if(selected.value== Icons.Default.Star) Color.White else Color(0xFF016DA8))
                Text(text = "Request", fontWeight = FontWeight.SemiBold, modifier=Modifier.padding(top = 23.dp))

            }
               //Dashboard
            IconButton(onClick = {
                selected.value=Icons.Default.DateRange
                navigationController.navigate(Screens.Dashboard.route){
                    popUpTo(0)
                }
            },
                modifier = Modifier.weight(1f)
            ) {
                Icon( Icons.Default.DateRange , contentDescription = null, modifier = Modifier.size(32.dp),
                    tint = if(selected.value== Icons.Default.DateRange) Color.White else Color(0xFF016DA8))
                Text(text = "Dashboard", fontWeight = FontWeight.SemiBold, modifier=Modifier.padding(top = 23.dp))


            }
            //Report
            IconButton(onClick = {
                selected.value=Icons.Default.Warning
                navigationController.navigate(Screens.Report.route){
                    popUpTo(0)
                }
            },
                modifier = Modifier.weight(1f)
            ) {
                Icon( Icons.Default.Warning , contentDescription = null, modifier = Modifier.size(32.dp),
                    tint = if(selected.value== Icons.Default.Warning) Color.White else Color(0xFF016DA8))
                Text(text = "Report", fontWeight = FontWeight.SemiBold, modifier=Modifier.padding(top = 23.dp))


            }
            // profile
            IconButton(onClick = {
                selected.value=Icons.Default.AccountCircle
                navigationController.navigate(Screens.Profile.route){
                    popUpTo(0)
                }
            },
                modifier = Modifier.weight(1f)
            ) {

                Icon( Icons.Default.AccountCircle , contentDescription = null, modifier = Modifier.size(32.dp),
                    tint = if(selected.value== Icons.Default.AccountCircle) Color.White else Color(0xFF016DA8))
                Text(text = "Profile", fontWeight = FontWeight.SemiBold, modifier=Modifier.padding(top = 23.dp))


            }



        }
    } ) {paddingValues ->
    NavHost(navController = navigationController,
        startDestination = Screens.Home.route,
        modifier = Modifier.padding(paddingValues)){
        composable(Screens.Home.route){ Home()}
        composable(Screens.Requests.route){ Request() }
        composable(Screens.Dashboard.route){ Dashboard() }
        composable(Screens.Report.route){ Report() }
        composable(Screens.Profile.route){ Profile() }
    }



        // card + calendar
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(vertical = 64.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            HorizontalCalendarView(
                modifier = Modifier.border(1.dp, Color.Gray, shape = RoundedCornerShape(16.dp)),
                selectedTextColor = Color.White,
                unSelectedTextColor = Color.Black,
                selectedCardColor = Color(0xFF029DF0),
                unSelectedCardColor = Color.White,
                onDayClick = { day ->
                    Toast.makeText(context, day.toString(), Toast.LENGTH_SHORT).show()
                })
            //big card
            ElevatedCard(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp
                ),
                modifier = Modifier
                    .size(width = 350.dp, height = 620.dp)
                    .padding(vertical = 4.dp)
                , shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(Color.White)


                ) {
                Text(
                    text = "Today Attendance",
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .padding(16.dp),
                    textAlign = TextAlign.Center,
                )




                Column(
                    modifier = Modifier.padding(16.dp), // Apply padding to the entire column
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        //inner cards
                        //small card
                        ElevatedCard(elevation = CardDefaults.cardElevation(
                            defaultElevation = 6.dp
                        ),
                            modifier = Modifier.size(width = 160.dp, height = 120.dp)
                                .padding(12.dp).clickable { Toast.makeText(context, "present 23", Toast.LENGTH_SHORT).show() },
                            colors = CardDefaults.cardColors(Color(0xFFE0EBF4))
                        ) {
                            Column {
                                Text("Present", fontSize = 25.sp, fontWeight = FontWeight.SemiBold)
                                Text("23", fontSize = 25.sp, color = Color(0xFF45A6F5))
                        }

                        }
                        //second
                        ElevatedCard(elevation = CardDefaults.cardElevation(
                            defaultElevation = 6.dp
                        ),
                            modifier = Modifier.size(width = 160.dp, height = 120.dp)
                                .padding(12.dp).clickable { Toast.makeText(context, "Late in 23", Toast.LENGTH_SHORT).show() },
                            colors = CardDefaults.cardColors(Color(0xFFF5EBD7))
                        ) {

                            Column {
                                Text("Late In",fontSize = 25.sp, fontWeight = FontWeight.SemiBold)
                                Text("23",fontSize = 25.sp, color = Color(0xFFF09E07))
                            }
                        }
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        //third
                        ElevatedCard(elevation = CardDefaults.cardElevation(
                            defaultElevation = 6.dp
                        ),
                            modifier = Modifier.size(width = 160.dp, height = 120.dp)
                                .padding(12.dp).clickable { Toast.makeText(context, "early leave 23", Toast.LENGTH_SHORT).show() },
                            colors = CardDefaults.cardColors(Color(0xFFA7D5C9))
                        ) {

                            Column {
                                Text("Early Leave",fontSize = 25.sp, fontWeight = FontWeight.SemiBold)
                                Text("23",fontSize = 25.sp, color = Color(0xFF05B279))
                            }
                        }
                            //fourth

                        ElevatedCard(elevation = CardDefaults.cardElevation(
                            defaultElevation = 6.dp
                        ),
                            modifier = Modifier.size(width = 160.dp, height = 120.dp)
                                .padding(12.dp).clickable { Toast.makeText(context, "Absents 23", Toast.LENGTH_SHORT).show() },
                            colors = CardDefaults.cardColors(Color(0xFFED9BA4))
                        ) {

                            Column {
                                Text("Absents",fontSize = 25.sp, fontWeight = FontWeight.SemiBold)
                                Text("23",fontSize = 25.sp, color = Color(0xFFF75262))
                            }
                        }

                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        //fifth
                        ElevatedCard(elevation = CardDefaults.cardElevation(
                            defaultElevation = 6.dp
                        ),
                            modifier = Modifier.size(width = 160.dp, height = 120.dp)
                                .padding(12.dp).clickable { Toast.makeText(context, "Vacation 23", Toast.LENGTH_SHORT).show() },
                            colors = CardDefaults.cardColors(Color(0xFFE5E5F5))
                        ) {

                            Column {
                                Text("Vacation",fontSize = 25.sp, fontWeight = FontWeight.SemiBold)
                                Text("23",fontSize = 25.sp, color = Color(0xFFAEAEE0))
                            }
                        }
                            //sixth
                        ElevatedCard(elevation = CardDefaults.cardElevation(
                            defaultElevation = 6.dp
                        ),
                            modifier = Modifier.size(width = 160.dp, height = 120.dp)
                                .padding(12.dp).clickable { Toast.makeText(context, "Deadline 23", Toast.LENGTH_SHORT).show() },
                            colors = CardDefaults.cardColors(Color(0xFFF6E5DE))
                        ) {

                            Column {
                                Text("Deadline Task",fontSize = 25.sp, fontWeight = FontWeight.SemiBold)
                                Text("23",fontSize = 25.sp, color = Color(0xFFE6B6A2))
                            }
                        }

                    }

                }
            }

        }

}
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    WorkFlowApplicationTheme {
        Greeting("Android")
        buttonnav()

    }
}