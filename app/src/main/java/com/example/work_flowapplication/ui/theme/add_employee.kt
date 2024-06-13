package com.example.work_flowapplication.ui.theme

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.example.work_flowapplication.R
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEmployee(navController: NavHostController) {
    val context = LocalContext.current.applicationContext


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(graycolour),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ConstraintLayout(
            modifier = Modifier
                .height(200.dp)
                .clip(RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp))
                .background(bluecolour)
        ) {
            val (topImg, profile, title, back, pen) = createRefs()
            Image(painter = painterResource(id = R.drawable.proprofile), contentDescription = "",
                Modifier
                    .fillMaxWidth()
                    .height(130.dp)
                    .constrainAs(profile) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)

                    }
            )
            Text(
                text = "  Create User",
                fontSize = 28.sp,
                color = white,
                modifier = Modifier.constrainAs(title) {
                    top.linkTo(parent.top, margin = 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            )
            TextButton(onClick = { navController.popBackStack() },) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    tint = Color.White,
                    contentDescription = "Back",
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .size(25.dp)

                )
            }


        }
        Column {
            Spacer(modifier = Modifier.height(16.dp))
            text(text1 = "Name")
            var text by remember { mutableStateOf("") }
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
            var text1 by remember { mutableStateOf("") }
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
            var text2 by remember { mutableStateOf("") }
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
            var text3 by remember { mutableStateOf("") }
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
            var text4 by remember { mutableStateOf("") }
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
                    DatePickerDialog(onDismissRequest = { /*TODO*/ }, confirmButton = {
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
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row (){


        TextButton(
            onClick = {
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



