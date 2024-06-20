@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.work_flowapplication.ui.theme

import android.annotation.SuppressLint
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.HeadsetMic
import androidx.compose.material.icons.filled.LockReset
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.work_flowapplication.R
import com.example.work_flowapplication.ui.api.ApiManger
import com.example.work_flowapplication.ui.api.Logoutrequest
import com.example.work_flowapplication.ui.api.Logoutrespond
import com.example.work_flowapplication.ui.api.Vacationrequest
import com.example.work_flowapplication.ui.api.Vacationrespond
import com.example.work_flowapplication.ui.localdata.getEmail
import com.example.work_flowapplication.ui.localdata.getToken
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import java.net.MalformedURLException
import java.net.URL
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api

data class bottomnavigationitem(

    val title:String,
    val selectedicon:Int,

)

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable




fun home( context1:AppCompatActivity) {
    var selectedBox by remember { mutableStateOf(0) }
    var selectedtext by remember { mutableStateOf("Remotly") }
    var selectedstartdate by remember { mutableStateOf("") }
    var selectedtenddate by remember { mutableStateOf("") }
    var selectfile by remember {
        mutableStateOf(false)
    }
    var navigate by remember {
        mutableStateOf(false)
    }

    var text2 by remember {
        mutableStateOf("")
    }
    val result = remember { mutableStateOf<Uri?>(null) }
    val urlResult = remember { mutableStateOf<URL?>(null) }
    val item = listOf(
        bottomnavigationitem(
            title = "home",
            selectedicon = R.drawable.home_logo

        ),
        bottomnavigationitem(
            title = "Request",
            selectedicon = R.drawable.request
        ),
        bottomnavigationitem(
            title = "Task",
            selectedicon = R.drawable.notepad

        ), bottomnavigationitem(
            title = "Report",
            selectedicon = R.drawable.notepencil
        ), bottomnavigationitem(
            title = "Profile",
            selectedicon = R.drawable.cardprofile


        )

    )


    val context = LocalContext.current.applicationContext


    var selected by remember {
        mutableStateOf("home")
    }
    val navigationController = rememberNavController()
    val sheetstate = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    var issheetopen by rememberSaveable {
        mutableStateOf(false)
    }

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerState = drawerState,
        //  gesturesEnabled = false,
        drawerContent = {
            ModalDrawerSheet(modifier = Modifier.width(260.dp)) {
                Row {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "setting",
                        Modifier.padding(start = 16.dp, top = 16.dp)
                    )
                    Text(
                        "Settings ",
                        modifier = Modifier.padding(
                            end = 16.dp,
                            top = 16.dp,
                            bottom = 16.dp,
                            start = 12.dp
                        ),
                        fontSize = 20.sp
                    )
                }
                Divider()

                Column {
                    // Text(text = "Settings", Modifier.padding(16.dp))


                    Box(modifier = Modifier.clickable { }) {
                        Row {
                            Icon(
                                imageVector = Icons.Default.LockReset,
                                contentDescription = "change pass",
                                Modifier.padding(start = 16.dp, top = 16.dp)
                            )
                            Text(
                                text = "Change Password",
                                modifier = Modifier.padding(
                                    end = 16.dp,
                                    top = 16.dp,
                                    bottom = 16.dp,
                                    start = 12.dp
                                )
                            )
                        }
                    }
                    Box(modifier = Modifier.clickable {
                        Toast.makeText(
                            context,
                            "We will call you on your private number Sir",
                            Toast.LENGTH_LONG
                        ).show()
                    }) {
                        Row {
                            Icon(
                                imageVector = Icons.Default.HeadsetMic,
                                contentDescription = "support",
                                Modifier.padding(start = 16.dp, top = 16.dp)
                            )
                            Text(
                                text = "Support",
                                modifier = Modifier.padding(
                                    end = 16.dp,
                                    top = 16.dp,
                                    bottom = 16.dp,
                                    start = 12.dp
                                )
                            )
                        }
                    }


val email=Logoutrequest(getEmail(context1))
                    Box(modifier = Modifier.clickable {
                        ApiManger.getapiservices().logout(email)
                            .enqueue(object : retrofit2.Callback<Logoutrespond> {
                                override fun onResponse(
                                    p0: Call<Logoutrespond>,
                                    p1: Response<Logoutrespond>
                                ) {
                                    val body = p1.body()
                                    if (p1.isSuccessful && body != null) {

navigate=true

                                    }
                                }

                                override fun onFailure(p0: Call<Logoutrespond>, p1: Throwable) {
                                    TODO("Not yet implemented")
                                }
                            })

                    }) {
                        Row {
                            Icon(
                                imageVector = Icons.Default.Logout,
                                contentDescription = "logout",
                                Modifier.padding(start = 16.dp, top = 16.dp)
                            )
                            Text(
                                text = "Logout",
                                modifier = Modifier.padding(
                                    end = 16.dp,
                                    top = 16.dp,
                                    bottom = 16.dp,
                                    start = 12.dp
                                )
                            )
                        }
                    }


                }

            }
        },
    )
    {
        Scaffold(
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.smallTopAppBarColors(
                        containerColor = bluecolour,
                        titleContentColor = white,
                        actionIconContentColor = white,
                        navigationIconContentColor = white
                    ),

                    navigationIcon = {
                        IconButton(onClick = { scope.launch {
                            drawerState.apply {
                                if (isClosed) open() else close()
                            }
                        }

                        }) {
                            Icon(
                                painter = painterResource(R.drawable.sidemeanue_logo),
                                contentDescription = "",
                                modifier = Modifier
                                    .width(25.dp)
                                    .height(20.dp)
                            )
                        }
                    },
                    title = {
                        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center)
                        { Text(text = "Home", fontSize = 23.sp, fontWeight = FontWeight.SemiBold,) }
                    },
                    actions = {

                        IconButton(onClick = {navigationController.navigate(Screen_employee.notification.route)}) {
                            Icon(
                                painter = painterResource(id = R.drawable.notification_logo),
                                contentDescription = "", modifier = Modifier
                                    .width(20.dp)
                                    .height(23.dp)
                            )
                        }
                    }

                )
            },
            bottomBar = {

                NavigationBar(containerColor = white) {
                    val iconcolour = Color(0xFF1E7DFF)

                    NavigationBarItem(selected = selected == "home",
                        onClick = {
                            selected = "home"
                            navigationController.navigate(Screen_employee.clockin.route) {

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

                            indicatorColor = white
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
                            issheetopen = true
                        },
                        icon = {
                            Icon(
                                painter = painterResource(R.drawable.request),
                                contentDescription = "",
                                modifier = Modifier.size(25.dp),


                                tint = if (selected == "request") iconcolour else ll
                            )
                        }, colors = androidx.compose.material3.NavigationBarItemDefaults.colors(

                            indicatorColor = white
                        ),

                        label = {
                            Text(
                                text = "Request",
                                color = if (selected == "request") iconcolour else ll
                            )
                        })


                    NavigationBarItem(selected = selected == "Task",
                        onClick = {
                            selected = "Task"
                            navigationController.navigate(Screen_employee.Task.route) {
                                popUpTo(0)
                            }

                        },
                        icon = {
                            Icon(
                                painter = painterResource(R.drawable.notepad),
                                contentDescription = "",
                                modifier = Modifier.size(25.dp),
                                tint = if (selected == "Task") iconcolour else ll
                            )
                        }, colors = androidx.compose.material3.NavigationBarItemDefaults.colors(

                            indicatorColor = white
                        ), label = {
                            Text(
                                text = "Task",
                                color = if (selected == "Task") iconcolour else ll
                            )
                        })


                    NavigationBarItem(selected = selected == "Report",
                        onClick = {
                            selected = "Report"
                            navigationController.navigate(Screen_employee.Report.route) {
                                popUpTo(0)
                            }
                        },
                        icon = {
                            Icon(
                                painter = painterResource(R.drawable.notepencil),
                                contentDescription = "",
                                modifier = Modifier.size(25.dp),
                                tint = if (selected == "Report") iconcolour else ll
                            )
                        }, colors = androidx.compose.material3.NavigationBarItemDefaults.colors(

                            indicatorColor = white
                        ), label = {
                            Text(
                                text = "Report",
                                color = if (selected == "Report") iconcolour else ll
                            )
                        })


                    NavigationBarItem(selected = selected == "Profile",
                        onClick = {
                            selected = "Profile"
                            navigationController.navigate(Screen_employee.Profile.route) {
                                popUpTo(0)
                            }

                        },
                        icon = {
                            Icon(
                                painter = painterResource(R.drawable.cardprofile),
                                contentDescription = "",
                                modifier = Modifier.size(25.dp),
                                tint = if (selected == "Profile") iconcolour else ll
                            )
                        }, colors = androidx.compose.material3.NavigationBarItemDefaults.colors(

                            indicatorColor = white
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
                startDestination = Screen_employee.clockin.route,
                modifier = Modifier.padding(paddingValues)
            ) {
                composable(Screen_employee.clockin.route) { clockin(context1) }
                composable(Screen_employee.Task.route) { app() }
                composable(Screen_employee.Report.route) { com.example.work_flowapplication.Report() }
                composable(Screen_employee.Profile.route) { }
                composable(Screen_employee.notification.route) {Notifications(navigationController)}
            }

        }
        if (issheetopen) {
            ModalBottomSheet(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(900.dp),
                shape = RectangleShape,
                containerColor = graycolour,
                sheetState = sheetstate,

                onDismissRequest = { issheetopen = false }) {
                Column(
                    modifier = Modifier
                        .background(graycolour)
                        .fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier
                            .padding(top = 16.dp)
                            .fillMaxWidth()
                            .height(35.dp), verticalAlignment = Alignment.CenterVertically
                    ) {

                        Icon(
                            painter = painterResource(id = R.drawable.arrow_logo),
                            contentDescription = "",
                            modifier = Modifier
                                .width(30.dp)
                                .height(20.dp)
                                .padding(start = 10.dp),
                            tint = black
                        )
                        Text(
                            text = "Create Request",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(start = 91.dp)
                        )


                    }
                    Spacer(modifier = Modifier.height(25.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(0.9f)
                            .height(580.dp)
                            .clip(
                                shape = RoundedCornerShape(25.dp)
                            )
                            .background(white)
                    ) {
                        Column {

                            OutlinedTextField(value = text2,
                                onValueChange = { text2 = it },
                                modifier = Modifier
                                    .padding(top = 30.dp)
                                    .fillMaxWidth()
                                    .height(95.dp),
                                shape = RoundedCornerShape(10.dp),

                                colors = OutlinedTextFieldDefaults.colors(
                                    unfocusedBorderColor = textfieldcolour,
                                    focusedLabelColor = textfieldcolour,
                                    focusedTextColor = black
                                ),
                                placeholder = {
                                    Text(
                                        text = "Tomorrow a plumber will come to my\n" +
                                                "house , so I need to be at home", fontSize = 15.sp
                                    )
                                },
                                label = { Text(text = "Description") }

                            )

                            var expandedState by remember { mutableStateOf(false) }
                            val rotationState by animateFloatAsState(
                                targetValue = if (expandedState) 180f else 0f
                            )


                            Spacer(modifier = Modifier.height(25.dp))
                            Card(
                                Modifier
                                    .fillMaxWidth()
                                    .animateContentSize(
                                        animationSpec = tween(
                                            durationMillis = 300,
                                            easing = LinearOutSlowInEasing
                                        )
                                    )
                                    .clickable {},
                                colors = CardDefaults.cardColors(containerColor = white),
                                border = BorderStroke(2.dp, textfieldcolour)

                            ) {


                                Row(
                                    modifier = Modifier
                                        .padding(top = 16.dp, bottom = 16.dp)
                                        .fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {

                                    Text(
                                        text = "Type",
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(start = 10.dp)
                                    )


                                    Text(
                                        text = selectedtext,
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight.Normal,
                                        modifier = Modifier.padding(start = 179.dp),
                                        color = bluecolour
                                    )
                                    IconButton(modifier = Modifier
                                        .width(30.dp)
                                        .height(20.dp)
                                        .rotate(rotationState)
                                        .padding(start = 5.dp),

                                        onClick = { expandedState = !expandedState }) {
                                        Icon(
                                            painter = painterResource(id = R.drawable.uparrow_logo),
                                            contentDescription = "",
                                            modifier = Modifier
                                                .width(10.dp)
                                                .height(15.dp),
                                            tint = bluecolour
                                        )

                                    }

                                }
                                if (expandedState) {


                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Box(
                                            modifier = Modifier
                                                .width(100.dp)
                                                .height(95.dp)
                                                .padding(start = 24.dp, top = 17.dp)
                                                .clip(RoundedCornerShape(10.dp))
                                                .background(if (selectedBox == 1) bluecolour else graycolour)
                                                .clickable {
                                                    selectedBox = 1
                                                    selectedtext = "vacation"
                                                }

                                        ) {
                                            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                                                Icon(
                                                    painter = painterResource(id = R.drawable.vacation_icon),
                                                    contentDescription = "",
                                                    modifier = Modifier
                                                        .width(35.dp)
                                                        .height(30.dp)
                                                        .padding(start = 10.dp, top = 10.dp),
                                                    tint = if (selectedBox == 1) white else bluecolour
                                                )
                                                Text(
                                                    text = "vacation",
                                                    fontSize = 12.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    modifier = Modifier.padding(start = 8.dp)
                                                )
                                                Text(
                                                    text = "7",
                                                    fontSize = 10.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    modifier = Modifier.padding(start = 5.dp)
                                                )

                                            }


                                        }
                                        Spacer(modifier = Modifier.width(10.dp))
                                        Box(
                                            modifier = Modifier
                                                .width(100.dp)
                                                .height(95.dp)
                                                .padding(start = 16.dp, top = 17.dp)
                                                .clip(RoundedCornerShape(10.dp))
                                                .background(if (selectedBox == 2) bluecolour else graycolour)
                                                .clickable {
                                                    selectedBox = 2
                                                    selectedtext = "sick Leave"
                                                }

                                        ) {
                                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                                Icon(
                                                    painter = painterResource(id = R.drawable.heartbeat_icon),
                                                    contentDescription = "",
                                                    modifier = Modifier
                                                        .width(35.dp)
                                                        .height(30.dp)
                                                        .padding(start = 16.dp, top = 10.dp),
                                                    tint = if (selectedBox == 2) white else bluecolour
                                                )
                                                Text(
                                                    text = "Sick Leave",
                                                    fontSize = 12.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    modifier = Modifier.padding(start = 8.dp)
                                                )
                                                Text(
                                                    text = "7",
                                                    fontSize = 10.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    modifier = Modifier.padding(start = 5.dp)
                                                )

                                            }


                                        }
                                        Spacer(modifier = Modifier.width(10.dp))
                                        Box(
                                            modifier = Modifier
                                                .width(100.dp)
                                                .height(95.dp)
                                                .padding(start = 16.dp, top = 17.dp)
                                                .clip(RoundedCornerShape(10.dp))
                                                .background(if (selectedBox == 3) bluecolour else graycolour)
                                                .clickable {
                                                    selectedBox = 3
                                                    selectedtext = "remotly"
                                                }
                                        ) {
                                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                                Icon(
                                                    painter = painterResource(id = R.drawable.remote_icon),
                                                    contentDescription = "",
                                                    modifier = Modifier
                                                        .width(35.dp)
                                                        .height(30.dp)
                                                        .padding(start = 10.dp, top = 10.dp),
                                                    tint = if (selectedBox == 3) white else bluecolour
                                                )
                                                Text(
                                                    text = "Remotly",
                                                    fontSize = 12.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    modifier = Modifier.padding(start = 8.dp)
                                                )
                                                Text(
                                                    text = "7",
                                                    fontSize = 10.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    modifier = Modifier.padding(start = 5.dp)
                                                )

                                            }


                                        }

                                    }

                                    Spacer(modifier = Modifier.height(25.dp))
                                }
                            }

                            var datePickerState = rememberDatePickerState()
                            var showDatePicker by remember { mutableStateOf(false) }
                            var calendercolour by remember { mutableStateOf(true) }

                            Spacer(modifier = Modifier.height(25.dp))
                            Card(
                                Modifier
                                    .fillMaxWidth()
                                    .height(55.dp)
                                    .clickable {
                                        showDatePicker = true
                                        calendercolour = false
                                    },
                                colors = CardDefaults.cardColors(containerColor = white),
                                border = BorderStroke(2.dp, textfieldcolour)
                            ) {
                                Row(
                                    modifier = Modifier
                                        .padding(top = 16.dp)
                                        .fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = "Start Date",
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(start = 10.dp)
                                    )

                                    Spacer(modifier = Modifier.width(110.dp))
                                    Text(
                                        text = selectedstartdate,
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight.Normal,
                                        modifier = Modifier
                                            .width(97.dp)
                                            .height(20.dp), color = black
                                    )
                                    Icon(
                                        painter = painterResource(id = R.drawable.calendaricon),
                                        contentDescription = "",
                                        modifier = Modifier
                                            .width(25.dp)
                                            .height(25.dp),
                                        tint = if (calendercolour) bluecolour else black
                                    )
                                }

                                val dateFormatter =
                                    SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                                if (showDatePicker) {
                                    DatePickerDialog(
                                        onDismissRequest = { /*TODO*/ },
                                        confirmButton = {
                                            TextButton(onClick = {
                                                showDatePicker = false
                                                val selectedDate = Calendar.getInstance().apply {
                                                    timeInMillis =
                                                        datePickerState.selectedDateMillis!!
                                                }
                                                selectedstartdate =
                                                    dateFormatter.format(selectedDate.time)
                                            }) {
                                                Text(text = "OK")
                                            }
                                        },
                                        dismissButton = {
                                            TextButton(onClick = { showDatePicker = false }) {
                                                Text(text = "Cancel")
                                            }
                                        }) {
                                        DatePicker(state = datePickerState)
                                    }
                                }
                            }

                            var datePickerState2 = rememberDatePickerState()
                            var showDatePickerEndDate by remember { mutableStateOf(false) }
                            var calendercolur2 by remember { mutableStateOf(true) }

                            Spacer(modifier = Modifier.height(25.dp))
                            Card(
                                Modifier
                                    .fillMaxWidth()
                                    .height(55.dp)
                                    .clickable {
                                        showDatePickerEndDate = true
                                        calendercolur2 = false
                                    },
                                colors = CardDefaults.cardColors(containerColor = white),
                                border = BorderStroke(2.dp, textfieldcolour)
                            ) {
                                Row(
                                    modifier = Modifier
                                        .padding(top = 16.dp)
                                        .fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = "End Date",
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(start = 10.dp)
                                    )

                                    Spacer(modifier = Modifier.width(120.dp))
                                    Text(
                                        text = selectedtenddate,
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight.Normal,
                                        modifier = Modifier
                                            .width(97.dp)
                                            .height(20.dp), color = black
                                    )
                                    Icon(
                                        painter = painterResource(id = R.drawable.calendaricon),
                                        contentDescription = "",
                                        modifier = Modifier
                                            .width(25.dp)
                                            .height(25.dp),
                                        tint = if (calendercolur2) bluecolour else black
                                    )
                                }

                                val dateFormatte =
                                    SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                                if (showDatePickerEndDate) {
                                    DatePickerDialog(
                                        onDismissRequest = { /*TODO*/ },
                                        confirmButton = {
                                            TextButton(onClick = {
                                                val selectedDatee = Calendar.getInstance().apply {
                                                    timeInMillis =
                                                        datePickerState2.selectedDateMillis!!
                                                }
                                                selectedtenddate =
                                                    dateFormatte.format(selectedDatee.time)
                                                showDatePickerEndDate = false
                                            }) {
                                                Text(text = "OK")
                                            }
                                        },
                                        dismissButton = {
                                            TextButton(onClick = {
                                                showDatePickerEndDate = false
                                            }) {
                                                Text(text = "Cancel")
                                            }
                                        }) {
                                        DatePicker(state = datePickerState2)
                                    }
                                }
                            }

                            Spacer(modifier = Modifier.height(25.dp))
                            Card(
                                Modifier
                                    .fillMaxWidth()
                                    .height(55.dp)
                                    .clickable { },
                                colors = CardDefaults.cardColors(containerColor = white),
                                border = BorderStroke(2.dp, textfieldcolour)
                            ) {
                                Row(
                                    modifier = Modifier
                                        .padding(top = 16.dp)
                                        .fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = "Attach file",
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(start = 10.dp)
                                    )

                                    Spacer(modifier = Modifier.width(190.dp))


                                    IconButton(
                                        onClick = {
                                            selectfile = !selectfile

                                        }
                                    ) {
                                        Icon(
                                            painter = painterResource(id = R.drawable.attatchfileicon),
                                            contentDescription = "",
                                            modifier = Modifier
                                                .width(25.dp)
                                                .height(25.dp),
                                            tint = bluecolour
                                        )

                                    }
                                }


                            }

                            val launcher =
                                rememberLauncherForActivityResult(ActivityResultContracts.PickVisualMedia()) {
                                    result.value = it
                                    urlResult.value = it?.let { uri -> uriToUrl(uri) }
                                }

                            Column {
                                if (selectfile)

                                    launcher.launch(
                                        PickVisualMediaRequest(mediaType = ActivityResultContracts.PickVisualMedia.ImageOnly)
                                    )

                                result.value?.let { image ->

                                    val painter = rememberAsyncImagePainter(
                                        ImageRequest
                                            .Builder(LocalContext.current)
                                            .data(data = image)
                                            .build()
                                    )
                                    Image(
                                        painter = painter,
                                        contentDescription = null,
                                        modifier = Modifier
                                            .size(150.dp, 150.dp)
                                            .padding(16.dp)
                                    )


                                }


                            }
                            selectfile = false


                        }


                    }
                    Row(
                        modifier = Modifier
                            .padding(top = 39.dp, start = 24.dp)
                            .fillMaxWidth()
                            .height(70.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        TextButton(
                            onClick = {}, modifier = Modifier
                                .width(160.dp)
                                .height(60.dp)
                                .clip(RoundedCornerShape(1.dp)),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF7F74))
                        ) {

                            Text(
                                text = "Cancel",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = white
                            )

                        }
                        val reson = selectedtext
                        val description = text2
                        val startdate = selectedstartdate
                        val enddate = selectedtenddate
                        val status = "accepted"
                        val file = result.value.toString()
                        val send =
                            Vacationrequest(reson, file, enddate, description, startdate, status)
                        Spacer(modifier = Modifier.width(24.dp))
                        fun handleApiError(response: Response<Vacationrespond>) {
                            when (response.code()) {
                                401 -> {
                                    // Handle Unauthorized - token may be invalid or expired
                                    Log.e(
                                        "tag",
                                        "onResponse: unauthorized, token might be expired or invalid"
                                    )
                                    // You can prompt the user to login again or refresh the token
                                }

                                429 -> {
                                    // Handle Too Many Requests - rate limiting
                                    Log.e(
                                        "tag",
                                        "onResponse: too many requests, retry after some time"
                                    )
                                    // You can implement a retry mechanism with exponential backoff
                                }

                                400 -> {
                                    // Handle Bad Request
                                    val errorBody = response.errorBody()?.string()
                                    Log.e("tag", "onResponse: bad request, error: $errorBody")
                                }

                                500 -> {
                                    // Handle Internal Server Error
                                    val errorBody = response.errorBody()?.string()
                                    Log.e("tag", "onResponse: server error, error: $errorBody")
                                }

                                else -> {
                                    // Handle other status codes
                                    val errorBody = response.errorBody()?.string()
                                    Log.e(
                                        "tag",
                                        "onResponse: error, code: ${response.code()}, error: $errorBody"
                                    )
                                }
                            }
                        }
                        TextButton(
                            onClick = {
                                val token =
                                    "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1lIjoiYWhtZWQiLCJ1c2VybGQiOiI2NjYwYWRhNGU5NTc5YTk2N2QwNjNmMjAiLCJyb2xlIjoidXNlciIsImlhdCI6MTcxNzYyNDM3Nn0.DJs8Okc7tMCpMde2W71SoUAF-aN7M_0O0JwIgvDnUxE"


                                Log.e("tag", "API start...")

                                ApiManger.getapiservices().createvacation(getToken(context), send)
                                    .enqueue(object : retrofit2.Callback<Vacationrespond> {
                                        override fun onResponse(
                                            call: Call<Vacationrespond>,
                                            response: Response<Vacationrespond>
                                        ) {
                                            val body = response.body()
                                            if (response.isSuccessful && body != null) {
                                                Log.e(
                                                    "tag",
                                                    "onResponse: create vacation successful"
                                                )
                                                Log.e("tag", "onResponse: message: ${body.message}")
                                                Log.e("tag", "onResponse: result: ${body.result}")
                                            } else {
                                                handleApiError(response)
                                            }
                                        }

                                        override fun onFailure(
                                            call: Call<Vacationrespond>,
                                            t: Throwable
                                        ) {
                                            Log.e(
                                                "tag",
                                                "onFailure: create vacation not successful, error: ${t.message}",
                                                t
                                            )
                                        }
                                    })
                            },
                            modifier = Modifier
                                .width(160.dp)
                                .height(60.dp)
                                .clip(RoundedCornerShape(1.dp)),
                            colors = ButtonDefaults.buttonColors(containerColor = bluecolour)
                        ) {
                            Text(
                                text = "Apply",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = white
                            )
                        }


                    }
                }
            }
        }
        if(navigate==true){
            NavHostSetup(context1)
        }

    }

}

fun uriToUrl(uri: Uri): URL? {
    return try {
        URL(uri.toString())
    } catch (e: MalformedURLException) {
        e.printStackTrace()
        null
    }
}




@Composable



@Preview
 fun home_employeepreview(){

 }

