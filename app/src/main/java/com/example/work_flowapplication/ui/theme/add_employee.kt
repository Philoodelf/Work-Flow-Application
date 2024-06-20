package com.example.work_flowapplication.ui.theme

import android.annotation.SuppressLint
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CameraEnhance
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.work_flowapplication.R
//import com.example.work_flowapplication.ui.api.AddemployeeRequest
//import com.example.work_flowapplication.ui.api.AddemployeeRespond
import com.example.work_flowapplication.ui.api.ApiManger
import retrofit2.Call
import retrofit2.Response
import java.net.MalformedURLException
import java.net.URL
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEmployee(navController: NavHostController) {
    val context = LocalContext.current.applicationContext
    val result = remember { mutableStateOf<Uri?>(null) }
    val urlResult = remember { mutableStateOf<URL?>(null) }
    var selectfile by remember {
        mutableStateOf(false)
    }
    val launcher =
        rememberLauncherForActivityResult(ActivityResultContracts.PickVisualMedia()) {
            result.value = it
            urlResult.value = it?.let { uri -> uriToUrl(uri) }
            selectfile = false
        }

    var text by remember { mutableStateOf("") }
    var text1 by remember { mutableStateOf("") }
    var text2 by remember { mutableStateOf("") }
    var text3 by remember { mutableStateOf("") }
    var text4 by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(graycolour),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp)),
            colors = CardDefaults.cardColors(containerColor = bluecolour)
        ) {
            Spacer(modifier = Modifier.height(32.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    tint = Color.White,
                    contentDescription = "Back",
                    modifier = Modifier
                        .padding( start = 16.dp)
                        .size(25.dp)
                        .clickable {
                            navController.popBackStack()
                        })

                Spacer(modifier = Modifier.width(8.dp)) // Add space between the icon and the text
                Text(
                    text = "Back",
                    color = Color(0xFF029DF0),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )

            //    Spacer(modifier = Modifier.width(80.dp))
                Text(
                    text = "  Create User",
                    fontSize = 28.sp,
                    color = white,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 20.dp,)
                )
            }
          //  Spacer(modifier = Modifier.height(60.dp))
            Spacer(modifier = Modifier.height(60.dp))

            if (selectfile) {
                // Trigger the image picker
                LaunchedEffect(Unit) {
                    launcher.launch(
                        PickVisualMediaRequest(mediaType = ActivityResultContracts.PickVisualMedia.ImageOnly)
                    )
                }
            }

            result.value?.let { image ->
                val painter = rememberAsyncImagePainter(
                    ImageRequest
                        .Builder(LocalContext.current)
                        .data(data = image)
                        .build()
                )

//                Box(
//                    modifier = Modifier
//                        .fillMaxHeight() // Make the Box fill the available space
//                        .padding(16.dp) // Optional: Add padding if needed
//                ) {
//                    Image(
//                        painter = painter,
//                        contentDescription = "",
//                      //  contentScale = ContentScale.Crop, // Crop the image to fill its bounds
//                        modifier = Modifier
//                            .size(600.dp) // Set the desired size for the image
//                            .align(Alignment.Center) // Center the image within the Box
//                            .clip(RoundedCornerShape(16.dp)) // Apply rounded corners
//                    )
//                }

                Box(
                    modifier = Modifier
                        .width(400.dp)
                        .height(500.dp)
                ) {
                    Image(
                        painter = painter,
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(100.dp) // Set the desired size for the image
                             .align(Alignment.Center) // Center the image within the Box
                               .clip(RoundedCornerShape(48.dp)) // Apply rounded corners
                    )
                }
            } ?: run {
//                Box(
//                    modifier = Modifier
//                        .width(400.dp)
//                        .height(500.dp)
//                        .background(Color.LightGray) // Optional: for visualization
              //  ) {
//                    Image(
//                        painter = painterResource(id = R.drawable.proprofile),
//                        contentDescription = "",
//                        contentScale = ContentScale.Crop,
//                        modifier = Modifier
//                            .size(300.dp) // Set size to ensure it fits well within the Box
//                            .align(Alignment.Center)
//                            .clip(RoundedCornerShape(16.dp))
//                    )


                IconButton(
                        onClick = { selectfile = true },
                        modifier = Modifier
                            .size(40.dp)
                            .background(Color.White, shape = RoundedCornerShape(20.dp))
                    ) {
                        Icon(
                            imageVector = Icons.Default.CameraEnhance,
                            contentDescription = "Add",
                            tint = bluecolour
                        )
                    }
                }
            }
        //}


        Column {
            Spacer(modifier = Modifier.height(16.dp))
            text(text1 = "Name")

            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                modifier = Modifier
                    .padding(top = 4.dp)
                    .fillMaxWidth(0.9f)
                    .height(55.dp),
                shape = RoundedCornerShape(10.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = textfieldcolour,
                    focusedLabelColor = textfieldcolour,
                    focusedTextColor = black
                ),
                placeholder = {
                    Text(
                        text = "Name",
                        fontSize = 15.sp
                    )
                },

                )
            text(text1 = "Email")

            OutlinedTextField(
                value = text1,
                onValueChange = { text1 = it },
                modifier = Modifier
                    .padding(top = 4.dp)
                    .fillMaxWidth(0.9f)
                    .height(55.dp),
                shape = RoundedCornerShape(10.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = textfieldcolour,
                    focusedLabelColor = textfieldcolour,
                    focusedTextColor = black
                ),
                placeholder = {
                    Text(
                        text = "New Email",
                        fontSize = 15.sp
                    )
                },

                )
            text(text1 = "Phone")

            OutlinedTextField(
                value = text2,
                onValueChange = { text2 = it },
                modifier = Modifier
                    .padding(top = 4.dp)
                    .fillMaxWidth(0.9f)
                    .height(55.dp),
                shape = RoundedCornerShape(10.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = textfieldcolour,
                    focusedLabelColor = textfieldcolour,
                    focusedTextColor = black
                ),
                placeholder = {
                    Text(
                        text = "New Phone",
                        fontSize = 15.sp
                    )
                },

                )
            text(text1 = "Position")

            OutlinedTextField(
                value = text3,
                onValueChange = { text3 = it },
                modifier = Modifier
                    .padding(top = 4.dp)
                    .fillMaxWidth(0.9f)
                    .height(55.dp),
                shape = RoundedCornerShape(10.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = textfieldcolour,
                    focusedLabelColor = textfieldcolour,
                    focusedTextColor = black
                ),
                placeholder = {
                    Text(
                        text = "New Position",
                        fontSize = 15.sp
                    )
                },

                )
            text(text1 = "Address")

            OutlinedTextField(
                value = text4,
                onValueChange = { text4 = it },
                modifier = Modifier
                    .padding(top = 4.dp)
                    .fillMaxWidth(0.9f)
                    .height(55.dp),
                shape = RoundedCornerShape(10.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = textfieldcolour,
                    focusedLabelColor = textfieldcolour,
                    focusedTextColor = black
                ),
                placeholder = {
                    Text(
                        text = "Alex",
                        fontSize = 15.sp
                    )
                },

                )
            Spacer(modifier = Modifier.height(20.dp))
            var datePickerState2 = rememberDatePickerState()
            var showDatePickerEndDate by remember { mutableStateOf(false) }
            var selectedtenddate by remember { mutableStateOf("") }
            var calendercolur2 by remember { mutableStateOf(true) }
            Card(
                Modifier
                    .fillMaxWidth(0.9f)
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
                        .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Birth Date",
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
                        tint = if (calendercolur2) bluecolour
                        else {
                            black
                        }
                    )
                }
                val dateFormatte = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                if (showDatePickerEndDate) {
                    DatePickerDialog(onDismissRequest = { }, confirmButton = {
                        TextButton(onClick =
                        {
                            val SelectedDatee = Calendar.getInstance().apply {
                                timeInMillis = datePickerState2.selectedDateMillis!!
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

                }


            }


        }
        Spacer(modifier = Modifier.height(10.dp))
        Row() {
            val name: String? = text
            val email: String? = text1
            val phone: String? = text2
            val position: String? = text3
            val address: String? = text4
            val fingerprint = "fingerprint"
            val socialstatue = "single"
            val gender = "male"
            val role = "user"
            val password = "000000"
            val image = result.value.toString()
            val birthdate = "11-9-2002"
            //   val data =AddemployeeRequest(image,password, address, role, gender, phone,name,socialstatue,birthdate,position,email)
            TextButton(
                onClick = {
//                    ApiManger.getapiservices().addemployee(data).enqueue(object :retrofit2.Callback<AddemployeeRespond>{
//                        override fun onResponse(
//                            p0: Call<AddemployeeRespond>,
//                            p1: Response<AddemployeeRespond>
//                        ) {
//
//                        }
//
//                        override fun onFailure(p0: Call<AddemployeeRespond>, p1: Throwable) {
//
//                        }
//                    })


                    Toast
                        .makeText(context, "User Created", Toast.LENGTH_SHORT)
                        .show()

                }, modifier = Modifier
                    .width(150.dp)
                    .height(60.dp)
                    .clip(RoundedCornerShape(1.dp)),
                colors = ButtonDefaults.buttonColors(containerColor = bluecolour)
            ) {

                Text(
                    text = "Create",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = white
                )

            }
            Spacer(modifier = Modifier.width(50.dp))
            TextButton(
                onClick = {}, modifier = Modifier
                    .width(150.dp)
                    .height(60.dp)
                    .clip(RoundedCornerShape(1.dp)),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF7F74))
            ) {

                Text(
                    text = "Cancel",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = white
                )

            }
        }
    }


}

    fun uriToUrl(uri: Uri): URL? {
        return try {
            URL(uri.toString())
        } catch (e: MalformedURLException) {
            e.printStackTrace()
            null
        }}