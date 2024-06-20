
//import com.example.work_flowapplication.ui.api.AddemployeeRequest
//import com.example.work_flowapplication.ui.api.AddemployeeRespond
import android.annotation.SuppressLint
import android.content.Context
import android.net.Uri
import android.util.Log
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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
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
import com.example.work_flowapplication.ui.api.AddemployeeRespond
import com.example.work_flowapplication.ui.api.ApiManger
import com.example.work_flowapplication.ui.localdata.getSecondToken
import com.example.work_flowapplication.ui.theme.black
import com.example.work_flowapplication.ui.theme.bluecolour
import com.example.work_flowapplication.ui.theme.graycolour
import com.example.work_flowapplication.ui.theme.text
import com.example.work_flowapplication.ui.theme.textfieldcolour
import com.example.work_flowapplication.ui.theme.white
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Response
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream
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

            selectfile = false
        }
    fun uploadImage( context: Context,
                     uri: Uri?,
                     name: String,
                     email: String,
                     phone: String,
                     password: String,
                     role: String,
                     gender: String,
                     address: String,
                     socialStatus: String,
                     birthDate: String,
                     fingerPrint: String,

    ){
        fun createTempFileFromInputStream(inputStream: InputStream?): File? {
            inputStream?.let {
                try {
                    val tempFile = File.createTempFile("temp_image", ".tmp")
                    FileOutputStream(tempFile).use { fileOut ->
                        inputStream.copyTo(fileOut)
                    }
                    return tempFile
                } catch (e: IOException) {
                    Log.e("tag", "Error creating temp file: ${e.message}")
                }
            }
            return null
        }

        fun uriToFile(uri: Uri?, context: Context): File? {
            uri?.let {
                try {
                    val inputStream: InputStream? = context.contentResolver.openInputStream(uri)
                    val tempFile = createTempFileFromInputStream(inputStream)
                    inputStream?.close()
                    return tempFile
                } catch (e: IOException) {
                    Log.e("tag", "Error converting uri to file: ${e.message}")
                }
            }
            return null
        }


        val imagePart: MultipartBody.Part? = uri?.let {
            val file = uriToFile(it, context)
            val validExtensions = listOf("jpg", "jpeg", "png")
            val fileExtension = file?.extension?.lowercase()

            if (fileExtension in validExtensions) {
                val requestFile =
                    file?.let { it1 -> RequestBody.create("image/*".toMediaTypeOrNull(), it1) }
                requestFile?.let { it1 ->
                    MultipartBody.Part.createFormData("image", file?.name,
                        it1
                    )
                }
            } else {
                Log.e("tag", "Invalid file extension: $fileExtension. Valid extensions are: $validExtensions")
                null
            }
        }

        val requestBodyMap = mutableMapOf<String, RequestBody>().apply {
            put("name", RequestBody.create("text/plain".toMediaTypeOrNull(), name))
            put("email", RequestBody.create("text/plain".toMediaTypeOrNull(), email))
            put("phone", RequestBody.create("text/plain".toMediaTypeOrNull(), phone))
            put("password", RequestBody.create("text/plain".toMediaTypeOrNull(), password))
            put("role", RequestBody.create("text/plain".toMediaTypeOrNull(), role))
            put("gender", RequestBody.create("text/plain".toMediaTypeOrNull(), gender))
            put("address", RequestBody.create("text/plain".toMediaTypeOrNull(), address))
            put("social_status", RequestBody.create("text/plain".toMediaTypeOrNull(), socialStatus))
            put("birthDate", RequestBody.create("text/plain".toMediaTypeOrNull(), birthDate))
            put("fingerPrint", RequestBody.create("text/plain".toMediaTypeOrNull(), fingerPrint))
        }
        ApiManger.getapiservices().addEmployee(getSecondToken(context),  image =imagePart,  data = requestBodyMap).enqueue(object :retrofit2.Callback<AddemployeeRespond>{
            override fun onResponse(
                p0: Call<AddemployeeRespond>,
                p1: Response<AddemployeeRespond>

            ) {
                val rspond = p1.body()
                if (p1.isSuccessful && rspond != null) {

                    Log.e("tag", "onResponse: message: ${rspond.message}")


                    Log.e("tag", "onResponse: message: ${rspond.add}")
                }
                else {
                    hndelerror(p1)
                }
            }
            private fun hndelerror(response:Response<AddemployeeRespond>) {
                when (response.code()) {
                    401 -> {
                        // Handle Unauthorized - token may be invalid or expired
                        Log.e("tag", "onResponse: unauthorized, token might be expired or invalid")
                        // You can prompt the user to login again or refresh the token
                    }
                    429 -> {
                        // Handle Too Many Requests - rate limiting
                        Log.e("tag", "onResponse: too many requests, retry after some time")
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
                        Log.e("tag", "onResponse: error, code: ${response.code()}, error: $errorBody")
                    }
                }
            }
            override fun onFailure(p0: Call<AddemployeeRespond>, p1: Throwable) {

            }
        })
    }






    var text by remember { mutableStateOf("") }
    var text1 by remember { mutableStateOf("") }
    var text2 by remember { mutableStateOf("") }
    var text3 by remember { mutableStateOf("") }
    var text4 by remember { mutableStateOf("") }
    fun uriToFile(uri: Uri, context: Context): File {
        val inputStream = context.contentResolver.openInputStream(uri)
        val file = File(context.cacheDir, "temp_image_file")
        file.outputStream().use {
            inputStream?.copyTo(it)
        }
        return file
    }

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
//
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





        }
        Spacer(modifier = Modifier.height(10.dp))
        Row() {





        }

            TextButton(
                onClick = { val name: String = text
                    val email: String = text1
                    val phone: String = text2
                    val position: String = text3
                    val address: String = text4
                    val socialstatue = "single"
                    val gender = "male"
                    val role = "user"
                    val password = "000000"
                    val birthdate = "11-9-2002"
                    uploadImage(context,result.value,name,email,phone,password,role,gender,address,socialstatue,birthdate,position,)


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


fun uriToFile(uri: Uri?, context: Context): File {
    val inputStream = uri?.let { context.contentResolver.openInputStream(it) }
    val tempFile = File.createTempFile("temp_image", null, context.cacheDir)
    tempFile.outputStream().use { outputStream ->
        inputStream?.copyTo(outputStream)
    }
    return tempFile
}
fun uriToUrl(uri: Uri?): URL? {
    return try {
        URL(uri.toString())
    } catch (e: MalformedURLException) {
        e.printStackTrace()
        null
    }}}