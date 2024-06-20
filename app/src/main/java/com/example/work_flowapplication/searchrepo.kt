package com.example.work_flowapplication

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
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
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.work_flowapplication.ui.api.ApiManger
import com.example.work_flowapplication.ui.api.Searchname
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun searchelrepo(navController:NavHostController) {
    val textstate = remember {
        mutableStateOf(TextFieldValue(""))
    }

    val searchtext = textstate.value.text

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
            TextButton(
                onClick = { navController.navigate(Screens.Dashboard.route) },
                //  contentPadding = PaddingValues(0.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(start = 16.dp, top = 16.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        tint = Color(0xFF029DF0),
                        contentDescription = "Back",
                        modifier = Modifier.size(32.dp)
                        //   .padding(top = 16.dp, start = 16.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp)) // Add space between the icon and the text
                    Text(
                        text = "Back",
                        color = Color(0xFF029DF0),
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                }
            }

            Box(
                modifier = Modifier.padding(start = 12.dp, top = 4.dp, end = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                //   searchbar()
                Searchview2(state = textstate, placeholder = "Search here... ", modifier = Modifier)
            }

            //  empl(searchtext = searchtext)
           // employye(searchtext = searchtext)
            employeee(navController = navController, searchtext =searchtext )

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Searchview2(state: MutableState<TextFieldValue>, placeholder: String, modifier: Modifier = Modifier) {




    TextField(
        value = state.value,
        onValueChange = { value ->
            state.value = value
        },
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 12.dp, top = 20.dp, end = 8.dp, bottom = 12.dp)
            .clip(RoundedCornerShape(25.dp))
            .border(2.dp, Color.DarkGray, RoundedCornerShape(30.dp)),
        placeholder = {
            Text(placeholder)
        },
        maxLines = 1,
        singleLine = true,
        textStyle = TextStyle(
            color = Color.Black, fontSize = 20.sp
        ),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.White
        )

    )




}



@Composable
fun employeee(navController: NavHostController, searchtext:String) {
    val context = LocalContext.current.applicationContext
    val items= listOf(
        theitems("Jane Hawkins", "front end developer", R.drawable.reportprofile!!),
        theitems("Brooklen Semoons", "back end developer", R.drawable.proprofile!!),
        theitems("Leslie Alexander", "mobile developer", R.drawable.requestprofile!!),
        theitems("Philopater Odolf", "mobile developer", R.drawable.philo!!),
        theitems("Michael Magdy", "full stak developer",R.drawable.michael!!),
        theitems("Esmail Farid", "full stak developer", R.drawable.esmail!!),
        theitems("cristaion ronaldo", "full stak developer", R.drawable.requestprofile!!),
        theitems("cristaion ronaldo", "full stak developer",R.drawable.requestprofile!!),
    )
    val filteredItems = items.filter {
        it.name.contains(searchtext, ignoreCase = true) ||
                it.job.contains(searchtext,
                    ignoreCase = true) }

    LazyColumn(){
        items(items = filteredItems){
                (name, job, profile ) ->
            ElevatedCard(elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                modifier = Modifier
                    .size(width = 380.dp, height = 110.dp)
                    .padding(start = 22.dp, top = 16.dp)
                    .clickable {
                        navController.navigate(Screens.Report.route)
                    },
                colors = CardDefaults.cardColors(Color.White)) {
                //image + name + job
                Row(modifier = Modifier) {
                    Image(
                        painter = painterResource(id = profile),
                        contentDescription = "Profile Picture",
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

//@Composable
//fun searchbar(modifier: Modifier = Modifier,
//              hint: String = " Name here ",
//              onSearch: (String) -> Unit = {}
//) {
//    var searchInput by remember {
//        mutableStateOf("")
//    }
//
//
//    var isHintDisplayed by remember {
//        mutableStateOf(hint != "")
//    }
//    Box(modifier = modifier) {
//
//        //card
//        OutlinedCard(
//            colors = CardDefaults.cardColors(
//                containerColor = Color.Transparent,
//            ),
//            border = BorderStroke(1.dp, Color.Black),
//            modifier = Modifier
//                .size(width = 400.dp, height = 40.dp)
//        ) {
//            Row(verticalAlignment = Alignment.CenterVertically) {
//
//                // Search icon
//                Box(
//                    modifier = Modifier
//                        .padding(start = 8.dp)
//                        .clickable {
//                            ApiManger
//                                .getapiservices()
//                                .searchn("philo")
//                                .enqueue(object : Callback<Searchname> {
//
//                                    override fun onResponse(
//                                        p0: Call<Searchname>,
//                                        p1: Response<Searchname>
//                                    ) {
//                                        val body = p1.body()
//                                        if (p1.isSuccessful && body != null) {
//                                        }
//                                        Log.e("tag", "onResponse: yep, token: ${body?.message}")
//                                        Log.e("tag", "onResponse: yes, token: ${body?.result}")
//                                    }
//
//                                    override fun onFailure(p0: Call<Searchname>, p1: Throwable) {
//                                        Log.e("tag", "onResponse: fail search")
//                                    }
//                                })
//                        } // Make the icon clickable
//                ) {
//                    Icon(
//                        imageVector = Icons.Default.Search,
//                        contentDescription = "Search",
//                        tint = Color.Black.copy(alpha = 0.5f), // Make the icon transparent
//                        modifier = Modifier.padding(start = 8.dp)
//                    )
//                }
//                BasicTextField(
//                    value = searchInput,
//                    onValueChange = {
//                        searchInput = it
//                        onSearch(it)
//                    },
//                    maxLines = 1,
//                    singleLine = true,
//                    textStyle = TextStyle(
//                        color = Color.Black,
//                        fontSize = 18.sp,
//                        //  fontFamily = Fonts.lexendDeca,
//                        fontWeight = FontWeight.W400
//                    ),
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(start = 8.dp, top = 4.dp)
//                        .onFocusChanged {
//                            isHintDisplayed = !it.isFocused
//                        }
//                )
//
//                if (isHintDisplayed) {
//                    Text(
//                        text = hint,
//                        color = Color(0xFF029DF0)
//                    )
//                }
//            }
//        }
//    }
//}

data class employeeItem2(
    val name: String,
    val job: String,
    val profile: Int,

    )


