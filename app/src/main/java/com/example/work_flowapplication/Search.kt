package com.example.work_flowapplication

import android.graphics.drawable.Drawable
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.navigation.NavHostController


@Composable
fun Search(  navController: NavHostController
) {
    Box(Modifier.background(Color.White)) {
//    TextButton(onClick = { navController.popBackStack() },) {
//        Icon(
//            imageVector = Icons.Default.ArrowBack,
//            tint = Color(0xFF029DF0),
//            contentDescription = "Back",
//            modifier = Modifier
//                .padding(top = 16.dp)
//                .size(25.dp)
//
//        )
//    }
        Column {


            Box(
                modifier = Modifier.padding(start = 12.dp, top = 4.dp, end = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                searchbar()
            }

            employye()
        }
    }
}

@Composable
fun employye() {
    val context = LocalContext.current.applicationContext
    val items= listOf(
        employeeItem("Jane Hawkins", "front end developer", ContextCompat.getDrawable(context, R.drawable.reportprofile)!!),
        employeeItem("Brooklen Semoons", "back end developer",ContextCompat.getDrawable(context, R.drawable.proprofile)!!),
        employeeItem("Leslie Alexander", "mobile developer developer",ContextCompat.getDrawable(context, R.drawable.requestprofile)!!),
        employeeItem("cristaion ronaldo", "full stak developer",ContextCompat.getDrawable(context, R.drawable.requestprofile)!!),
        employeeItem("cristaion ronaldo", "full stak developer",ContextCompat.getDrawable(context, R.drawable.requestprofile)!!),
        employeeItem("cristaion ronaldo", "full stak developer",ContextCompat.getDrawable(context, R.drawable.requestprofile)!!),
        employeeItem("cristaion ronaldo", "full stak developer",ContextCompat.getDrawable(context, R.drawable.requestprofile)!!),
    )
    LazyColumn(){
        items(items){
                (name, job, profile ) ->
    ElevatedCard(elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        modifier = Modifier
            .size(width = 380.dp, height = 110.dp)
            .padding(start = 22.dp, top = 16.dp)
            .clickable { "to do" },
        colors = CardDefaults.cardColors(Color.White)) {
        //image + name + job
        Row(modifier = Modifier) {
            Image(
                painter = painterResource(id = R.drawable.requestprofile),
                contentDescription = "des",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .padding(start = 15.dp, top = 15.dp)
            )
            Column(modifier = Modifier.padding(15.dp)) {
                Text(name, fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
                Text(job, fontSize = 15.sp)
            }
        }
    }
}
    }
}

@Composable
fun searchbar(modifier: Modifier = Modifier,
              hint: String = " Name here ",
              onSearch: (String) -> Unit = {}
) {
    var searchInput by remember {
        mutableStateOf("")
    }

    var isHintDisplayed by remember {
        mutableStateOf(hint != "")
    }
    Box(modifier = modifier) {

        //card
        OutlinedCard(
            colors = CardDefaults.cardColors(
                containerColor = Color.Transparent,
            ),
            border = BorderStroke(1.dp, Color.Black),
            modifier = Modifier
                .size(width = 400.dp, height = 40.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {

                // Search icon
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search",
                    tint = Color.Black.copy(alpha = 0.5f), // Make the icon transparent
                    modifier = Modifier.padding(start = 8.dp)
                )
                BasicTextField(
                    value = searchInput,
                    onValueChange = {
                        searchInput = it
                        onSearch(it)
                    },
                    maxLines = 1,
                    singleLine = true,
                    textStyle = TextStyle(
                        color = Color.Black,
                        fontSize = 18.sp,
                        //  fontFamily = Fonts.lexendDeca,
                        fontWeight = FontWeight.W400
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp, top = 4.dp)
                        .onFocusChanged {
                            isHintDisplayed = !it.isFocused
                        }
                )

                if (isHintDisplayed) {
                    Text(
                        text = hint,
                        color = Color(0xFF029DF0)
                    )
                }
            }
        }
    }
}


data class employeeItem(
    val name: String,
    val job: String,
    val profile: Drawable,

    )