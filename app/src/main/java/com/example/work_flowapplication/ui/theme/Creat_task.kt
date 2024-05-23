package com.example.work_flowapplication.ui.theme

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.work_flowapplication.R
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun moadlbottomsheettask(){
    var imageid = arrayOf(

        R.drawable.personimage,
        R.drawable.personimage,
        R.drawable.personimage,
        R.drawable.personimage

    )
    var name= listOf(
        "Mohamed",
        "Ahmed",
        "Esmail",
        "Esmail"
    )

    var description = arrayOf(
        "UI-UV DEsigner",
        "UI-UV DEsigner",
        "UI-UV DEsigner",
        "UI-UV DEsigner"
    )

    val context = LocalContext.current.applicationContext

    Box(modifier = Modifier
        .fillMaxSize()
        .background(white)) {

        Column(
            modifier = Modifier
                .background(graycolour)
                .fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(32.dp))
            Row(
                modifier = Modifier

                    .fillMaxWidth()
                    .height(30.dp), verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.arrow_logo), contentDescription = "",
                    modifier = Modifier
                        .width(30.dp)
                        .height(20.dp)
                        .padding(start = 10.dp), tint = black
                )

                Spacer(modifier = Modifier.width(110.dp))
                Text(
                    text = "Create Task",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,

                    )


            }
            Spacer(modifier = Modifier.height(32.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .height(500.dp)
                    .clip(
                        shape = RoundedCornerShape(25.dp)
                    )
                    .background(white)
            ) {
                Column {

                    var text1 by remember {
                        mutableStateOf("")
                    }
                    var assignto by remember {
                        mutableStateOf("")
                    }
                    var expanded by remember { mutableStateOf(false) }

                    Box(modifier = Modifier.fillMaxWidth()) {

                        var selectedIndex by remember { mutableStateOf(-1) }
                        LargeDropdownMenu(
                            label = "Sample",
                            items = name,
                            selectedIndex = selectedIndex,
                            onItemSelected = { index, _ -> selectedIndex = index },
                            images = imageid,
                            descriptions = description,
                            names = name
                        )


                    }
                    var text2 by remember {
                        mutableStateOf("")
                    }
                    OutlinedTextField(
                        value = text1,
                        onValueChange = { text1 = it },
                        modifier = Modifier
                            .padding(top = 20.dp)
                            .fillMaxWidth()
                            .height(55.dp),
                        shape = RoundedCornerShape(10.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedBorderColor = textfieldcolour,
                            focusedLabelColor = textfieldcolour,
                            focusedTextColor = black
                        ),
                        placeholder = {
                            Text(
                                text = "task1",
                                fontSize = 15.sp
                            )
                        },
                        label = { Text(text = "Title",  fontSize = 15.sp,
                            fontWeight = FontWeight.Bold) },
                    )
                    OutlinedTextField(value = text2,
                        onValueChange = { text2 = it },
                        modifier = Modifier
                            .padding(top = 20.dp)
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
                        label = { Text(text = "Description",  fontSize = 15.sp,
                            fontWeight = FontWeight.Bold) }

                    )
                    var expandedState by remember { mutableStateOf(false) }

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

                    }
                    var datePickerState = rememberDatePickerState()
                    var showDatePicker by remember { mutableStateOf(false) }
                    var calendercolour by remember { mutableStateOf(true) }
                    var selectedstartdate by remember { mutableStateOf("") }
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
                                tint = if (calendercolour) bluecolour
                                else {
                                    black
                                }
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
                }
            }



            Spacer(modifier = Modifier.height(32.dp))
            TextButton(
                onClick = {


                }, modifier = Modifier
                    .width(320.dp)
                    .height(60.dp)
                    .clip(RoundedCornerShape(1.dp)),
                colors = ButtonDefaults.buttonColors(containerColor = bluecolour)
            ) {

                Text(
                    text = "Apply",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = white
                )

            }

            Spacer(modifier = Modifier.height(25.dp))
            TextButton(
                onClick = {}, modifier = Modifier
                    .width(320.dp)
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







@Composable
fun <T> LargeDropdownMenu(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    label: String,
    notSetLabel: String? = null,
    items: List<T>,
    selectedIndex: Int = -1,
    onItemSelected: (index: Int, item: T) -> Unit,
    selectedItemToString: (T) -> String = { it.toString() },
    images: Array<Int>,
    descriptions: Array<String>,
    names: List<String>,
    drawItem: @Composable (Int, Array<Int>, Array<String>,List<String>, Boolean, Boolean, () -> Unit) -> Unit = { index, image, description, name, selected, itemEnabled, onClick ->
        LargeDropdownMenuItem(
            indexItem = index,
            image = image,
            description = description,
            name = name,
            selected = selected,
            enabled = itemEnabled,
            onClick = onClick,
        )
    },
) {
    var expanded by remember { mutableStateOf(false) }

    Box(modifier = modifier.height(IntrinsicSize.Min)) {
        OutlinedTextField(
            label = { Text("Assign To",  fontSize = 15.sp,
                fontWeight = FontWeight.Bold) },
            value = items.getOrNull(selectedIndex)?.let { selectedItemToString(it) } ?: "",
            enabled = enabled,
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth()
                .height(65.dp),
            shape = RoundedCornerShape(10.dp),

            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = textfieldcolour,
                focusedLabelColor = textfieldcolour,
                focusedTextColor = black
            )
            ,
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = "Drop down",
                    tint = Color.Blue,
                    modifier = Modifier
                        .size(25.dp)
                        .clickable {
                            expanded = !expanded
                        }
                )
            },
            onValueChange = { },
            readOnly = true,
        )

        // Transparent clickable surface on top of OutlinedTextField
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 8.dp)
                .clip(MaterialTheme.shapes.extraSmall)
                .clickable(enabled = enabled) { expanded = true },
            color = Color.Transparent,
        ) {}
    }

    if (expanded) {
        Dialog(
            onDismissRequest = { expanded = false },
        ) {
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = Color.White
            ) {
                val listState = rememberLazyListState()
                if (selectedIndex > -1) {
                    LaunchedEffect("ScrollToSelected") {
                        listState.scrollToItem(index = selectedIndex)
                    }
                }

                val maxVisibleItems = 7 // Maximum number of visible items in the dropdown

                LazyColumn(
                    modifier = Modifier.fillMaxWidth(),
                    state = listState
                ) {
                    if (notSetLabel != null) {
                        item {
                            LargeDropdownMenuItem(
                                indexItem = -1,
                                image = images,
                                description = descriptions,
                                name = names,
                                selected = false,
                                enabled = false,
                                onClick = { },
                            )
                        }
                    }
                    val itemCount = items.size.coerceAtMost(maxVisibleItems)
                    itemsIndexed(items.subList(0, itemCount)) { index, item ->
                        val selectedItem = index == selectedIndex
                        drawItem(
                            index,
                            images,
                            descriptions,
                            names,
                            selectedItem,
                            true
                        ) {
                            onItemSelected(index, item)
                            expanded = false
                        }

                        if (index < itemCount - 1) {
                            Divider(modifier = Modifier.padding(horizontal = 16.dp))
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun LargeDropdownMenuItem(
    indexItem: Int,
    image: Array<Int>,
    description: Array<String>,
    name: List<String> ,
    selected: Boolean,
    enabled: Boolean,
    onClick: () -> Unit,
) {
    CompositionLocalProvider() {
        Card(
            modifier = Modifier
                .clickable(enabled) { onClick() }
                .width(350.dp)

                .padding(16.dp)
                .clip(RoundedCornerShape(10.dp)),
            elevation = CardDefaults.cardElevation(15.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top = 10.dp, start = 10.dp)
            ) {
                Image(
                    painter = painterResource(image[indexItem]),
                    contentDescription = "",
                    modifier = Modifier
                        .size(48.dp)
                        .clip(shape = CircleShape)
                )
                Spacer(modifier = Modifier.width(20.dp))
                Column {
                    Text(
                        text = name[indexItem],
                        fontSize = 18.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Medium,
                        maxLines = 1
                    )
                    Text(
                        text = description[indexItem],
                        fontSize = 14.sp,
                        color = Color.Gray,
                        maxLines = 1,
                    )
                }
            }
        }
    }
}

@Composable

@Preview
fun creattaskpreview(){
    moadlbottomsheettask()

}


