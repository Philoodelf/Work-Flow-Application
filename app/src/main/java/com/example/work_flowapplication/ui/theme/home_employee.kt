@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.work_flowapplication.ui.theme

import android.annotation.SuppressLint
import android.net.Uri
import android.util.Log
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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
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
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.example.work_flowapplication.ui.api.Alltaskrespond
import com.example.work_flowapplication.ui.api.ApiManger
import com.example.work_flowapplication.ui.localdata.getToken
import retrofit2.Call
import retrofit2.Response
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
    var selectedBox by remember { mutableStateOf(0)}
    var selectedtext by remember { mutableStateOf("Remotly")}
    var selectedstartdate by remember { mutableStateOf("")}

    var selectfile by remember {
        mutableStateOf(false)
    }

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
                    IconButton(onClick = { /*TODO*/ }) {
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

                    IconButton(onClick = { /*TODO*/ }) {
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
                        ApiManger.getapiservices().getalltask(getToken(context))
                            .enqueue(object : retrofit2.Callback<Alltaskrespond> {
                                override fun onResponse(
                                    p0: Call<Alltaskrespond>,
                                    p1: Response<Alltaskrespond>
                                ) {
                                    val body = p1.body()


                                    Log.e(
                                        "tag",
                                        "onResponse: getalltask successful, token: ${p1.body()?.message}"
                                    )
                                    Log.e(
                                        "tag",
                                        "onResponse:  getalltask successful, token: ${p1.body()?.result}"
                                    )


                                }

                                override fun onFailure(p0: Call<Alltaskrespond>, p1: Throwable) {
                                    Log.e(
                                        "tag",
                                        "onResponse:  getalltask notsuccessful, token: ${p1}"
                                    )
                                }


                            })


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




            /* item.forEachIndexed { index, item ->
    NavigationBarItem(selected =selecteditemindex==index
        , onClick = { selecteditemindex=index
                   }
        , icon = { Icon(painter = painterResource(item.selectedicon) , contentDescription = "", modifier = Modifier.size(25.dp),
            tint = if(selecteditemindex==index) bluecolour
else lightbluecolour
        )},
        label = { Text(item.title)}
        )}*/

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
            composable(Screen_employee.Report.route) { Report() }
            composable(Screen_employee.Profile.route) { }
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
                        var text2 by remember {
                            mutableStateOf("")
                        }
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
                                    .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
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
                                    modifier = Modifier.padding(start = 179.dp), color = bluecolour
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
                                                selectedtext = "Vacation"
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
                                                text = "Vacation",
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
                                                selectedtext = "Sick Leave"
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
                                                selectedtext = "Remotly"
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
                                .clickable { showDatePicker = true
                                           calendercolour=false
                                           },
                            colors = CardDefaults.cardColors(containerColor = white),
                            border = BorderStroke(2.dp, textfieldcolour)
                        ) {


                            Row(
                                modifier = Modifier
                                    .padding(top = 16.dp)
                                    .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
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
                                    modifier = Modifier.width(97.dp).height(20.dp), color = black
                                )
                                Icon(
                                    painter = painterResource(id = R.drawable.calendaricon),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .width(25.dp)
                                        .height(25.dp),
                                    tint = if(calendercolour) bluecolour
                                    else{
                                        black}
                                )


                            }
                            val dateFormatter = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                            if (showDatePicker) {
                                DatePickerDialog(onDismissRequest = { /*TODO*/ }, confirmButton = {
                                    TextButton(onClick =

                                    {

                                        showDatePicker = false
                                        val selectedDate = Calendar.getInstance().apply {
                                            timeInMillis = datePickerState.selectedDateMillis!!
                                        }
                                        selectedstartdate =
                                            "${dateFormatter.format(selectedDate.time)}"

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
                        var selectedtenddate by remember { mutableStateOf("") }
                        var calendercolur2 by remember { mutableStateOf(true) }
                        Spacer(modifier = Modifier.height(25.dp))
                        Card(
                            Modifier
                                .fillMaxWidth()
                                .height(55.dp)
                                .clickable { showDatePickerEndDate = true
                                           calendercolur2=false
                                           },
                            colors = CardDefaults.cardColors(containerColor = white),
                            border = BorderStroke(2.dp, textfieldcolour)
                        ) {


                            Row(
                                modifier = Modifier
                                    .padding(top = 16.dp)
                                    .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
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
                                    modifier = Modifier.width(97.dp).height(20.dp), color = black
                                )
                                Icon(
                                    painter = painterResource(id = R.drawable.calendaricon),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .width(25.dp)
                                        .height(25.dp),
                                    tint = if(calendercolur2) bluecolour
                                    else{
                                        black}
                                )


                            }
                            val dateFormatte = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                            if (showDatePickerEndDate) {
                                DatePickerDialog(onDismissRequest = { /*TODO*/ }, confirmButton = {
                                    TextButton(onClick =

                                    {


                                        val SelectedDatee = Calendar.getInstance().apply {
                                            timeInMillis = datePickerState.selectedDateMillis!!
                                        }
                                        selectedtenddate =
                                            "${dateFormatte.format(SelectedDatee.time)}"
                                        showDatePickerEndDate = false
                                    }) {
                                        Text(text = "OK")
                                    }

                                },

                                    dismissButton = {
                                        TextButton(onClick = { showDatePickerEndDate = false }) {
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
                                    .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
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
                        val result = remember { mutableStateOf<Uri?>(null) }
                        val launcher =
                            rememberLauncherForActivityResult(ActivityResultContracts.PickVisualMedia()) {
                                result.value = it
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
                ){
                TextButton(
                    onClick = {}, modifier = Modifier
                        .width(160.dp)
                        .height(60.dp)
                        .clip(RoundedCornerShape(1.dp)),
                    colors = ButtonDefaults.buttonColors(containerColor =Color(0xFFFF7F74))
                ) {

                    Text(
                        text = "Cancel",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = white
                    )

                }
                    Spacer(modifier = Modifier.width(24.dp))
                    TextButton(
                        onClick = {










                        }, modifier = Modifier
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


    }













@Composable



@Preview
 fun home_employeepreview(){

 }

