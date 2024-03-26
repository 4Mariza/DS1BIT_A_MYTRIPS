package br.senai.sp.jandira.mytrips

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Landscape
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.mytrips.ui.theme.MyTripsTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTripsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                    SignUpLayout()
                    HomeLayout()
                }

            }
        }
    }
}

@Composable
fun Greeting() {
    Row {
        Card (
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFBB00FF)
            ),
            modifier = Modifier
                .width(170.dp)
                .height(50.dp)
                .offset(x = 250.dp, y = 0.dp),
            shape = RoundedCornerShape(topEnd = 30.dp, bottomStart = 30.dp)
        ){}
    }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Card (
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFBB00FF)
            ),
            modifier = Modifier
                .width(110.dp)
                .height(110.dp)
                .align(alignment = Alignment.CenterHorizontally),
            //.offset(x = 100.dp, y = 50.dp),
            shape = RoundedCornerShape(size = 100.dp)
        ){}
        Spacer(modifier = Modifier.height(35.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(110.dp)
                    .padding(start = 28.dp),
            ) {
                Text(
                    text = "Login",
                    color = Color(0xFFBB00FF),
                    fontSize = 50.sp,
                    fontWeight = FontWeight.ExtraBold
                )
                Text(
                    text = "Please sign in to continue.",
                    color = Color(0xFFA09C9C)
                )
            }
            Spacer(modifier = Modifier.height(30.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround
            ) {
                OutlinedTextField(
                    value = "",
                    onValueChange = { },
                    leadingIcon = {Icon(imageVector = Icons.Filled.Email, contentDescription ="", tint = Color(0xFFBB00FF))},
                    label = {
                        Text(text = "Email")
                    },
                    colors = OutlinedTextFieldDefaults
                        .colors(
                            unfocusedBorderColor = Color(0xFFBB00FF)
                        ),
                    shape = RoundedCornerShape(18.dp),
                    modifier = Modifier
                        .width(340.dp)
                        .height(65.dp)
                )
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    leadingIcon = { Icon(imageVector = Icons.Filled.Lock, contentDescription ="", tint = Color(0xFFBB00FF) )},
                    label = {
                        Text(text = "Password")
                    },
                    colors = OutlinedTextFieldDefaults
                        .colors(
                            unfocusedBorderColor = Color(0xFFBB00FF)
                        ),
                    shape = RoundedCornerShape(18.dp),
                    modifier = Modifier
                        .width(340.dp)
                        .height(65.dp)
                )
            }
            Spacer(modifier = Modifier.height(18.dp))
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 28.dp),
                horizontalArrangement = Arrangement.End
            ){
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFBB00FF)
                    ),
                    modifier = Modifier
                        .width(150.dp)
                        .height(50.dp),
                    shape = RoundedCornerShape(size = 16.dp)
                ) {
                    Row (
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ){
                        Text(
                            text = "SIGN IN",
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 18.sp
                        )
                        Icon(imageVector = Icons.Outlined.ArrowForward, contentDescription ="" )
                    }
                }
            }
            Spacer(modifier = Modifier.height(18.dp))
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 28.dp),
                horizontalArrangement = Arrangement.End
            ){
                Text(
                    text = "Don’t have an account?",
                    color = Color(0xFFA09C9C)
                )
                Text(
                    text = "Sign up",
                    color = Color(0xFFBB00FF),
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Row {
            Card (
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFBB00FF)
                ),
                modifier = Modifier
                    .width(170.dp)
                    .height(50.dp)
                    .offset(x = -22.dp, y = 70.dp),
                shape = RoundedCornerShape(topEnd = 30.dp, bottomStart = 30.dp)
            ){}
        }
    }
}

@Composable
fun SignUpLayout() {
    Row(
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth()
    )
    {
        Card (
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFBB00FF)
            ),
            modifier = Modifier
                .width(170.dp)
                .height(50.dp)
                .offset(x = 250.dp, y = 0.dp),
            shape = RoundedCornerShape(topEnd = 30.dp, bottomStart = 30.dp)
        ){}
    }
    Column (
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Column (
            modifier = Modifier
                .height(250.dp)
                .padding(top = 42.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = "Sign Up",
                fontSize = 38.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color(0xFFBB00FF)
            )
            Text(
                text = "Create a new account",
                color = Color(0xFFA09C9C),
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(15.dp))
            Card (
                modifier = Modifier
                    .size(height = 110.dp, width = 110.dp)
                    .align(Alignment.CenterHorizontally),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF6F6F6)),
                shape = CircleShape,
                border = BorderStroke(
                    width = 2.dp,
                    brush = Brush.horizontalGradient(
                        0.0f to Color(0xFFBB00FF),
                        0.5f to Color(0xFFDB8FF7),
                        0.8f to Color(0xFFE7BBF7),
                        1.2f to Color(0x80FFFFFF),
                        startX = 0.0f,
                        endX = 300.0f
                    )
                )
            ){
                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp),
                    verticalArrangement = Arrangement.Center
                ){
                    Image(painter = painterResource(id = R.drawable.profile), contentDescription = "",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(65.dp),
                        colorFilter =  ColorFilter.tint(Color(0xFFDE4FEE))
                    )
                }
            }
        }
        Image(painter = painterResource(id = R.drawable.addphoto), contentDescription = "",
            modifier = Modifier
                .width(40.dp)
                .height(34.dp)
                .offset(x = 40.dp, y = -35.dp)
        )
        Column (
            modifier = Modifier
                .offset(x = 0.dp, y = -15.dp)
                .fillMaxHeight()
        ){
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(290.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    leadingIcon = { Icon(imageVector = Icons.Filled.Person, contentDescription ="", tint = Color(0xFFBB00FF) )},
                    label = {
                        Text(text = "Username")
                    },
                    colors = OutlinedTextFieldDefaults
                        .colors(
                            unfocusedBorderColor = Color(0xFFBB00FF)
                        ),
                    shape = RoundedCornerShape(18.dp),
                    modifier = Modifier
                        .width(340.dp)
                        .height(65.dp)
                )
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    leadingIcon = {Image(painter = painterResource(id = R.drawable.phone), contentDescription = "")},
                    label = {
                        Text(text = "Phone")
                    },
                    colors = OutlinedTextFieldDefaults
                        .colors(
                            unfocusedBorderColor = Color(0xFFBB00FF)
                        ),
                    shape = RoundedCornerShape(18.dp),
                    modifier = Modifier
                        .width(340.dp)
                        .height(65.dp)
                )
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    leadingIcon = { Icon(imageVector = Icons.Filled.Email, contentDescription ="", tint = Color(0xFFBB00FF))},
                    label = {
                        Text(text = "Email")
                    },
                    colors = OutlinedTextFieldDefaults
                        .colors(
                            unfocusedBorderColor = Color(0xFFBB00FF)
                        ),
                    shape = RoundedCornerShape(18.dp),
                    modifier = Modifier
                        .width(340.dp)
                        .height(65.dp)
                )
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    leadingIcon = { Icon(imageVector = Icons.Filled.Lock, contentDescription ="", tint = Color(0xFFBB00FF) )},
                    label = {
                        Text(text = "Password")
                    },
                    colors = OutlinedTextFieldDefaults
                        .colors(
                            unfocusedBorderColor = Color(0xFFBB00FF)
                        ),
                    shape = RoundedCornerShape(18.dp),
                    modifier = Modifier
                        .width(340.dp)
                        .height(65.dp)
                )
            }
            Column (
                modifier = Modifier
                    .height(220.dp),
                verticalArrangement = Arrangement.SpaceAround
            ){
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(start = 20.dp)
                ){
                    Checkbox(checked = false, onCheckedChange ={},
                        colors = CheckboxDefaults.
                        colors(
                            uncheckedColor = Color(0xFFBB00FF)
                        ))
                    Text(text = "Over 18?")
                }
                Row (
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ){
                    Button(
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFBB00FF)
                        ),
                        modifier = Modifier
                            .width(340.dp)
                            .height(50.dp),
                        shape = RoundedCornerShape(20.dp)
                    ) {
                        Text(
                            text = "CREATE ACCOUNT",
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 20.sp
                        )
                    }
                }
                Row (
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 26.dp)
                ){
                    Text(
                        text = "Already have an account?",
                        color = Color(0XFFA09C9C)
                    )
                    Text(
                        text = "Sign in",
                        color = Color(0xFFCF06F0),
                        fontWeight = FontWeight.Bold
                    )
                }
                Row (
                    modifier = Modifier
                        .height(50.dp)
                        .fillMaxWidth()
                        .fillMaxHeight()
                ){
                    Card (
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFFBB00FF)
                        ),
                        modifier = Modifier
                            .width(170.dp)
                            .height(40.dp)
                            .offset(x = -22.dp, y = 15.dp),
                        shape = RoundedCornerShape(topEnd = 30.dp, bottomStart = 30.dp)
                    ){}
                }
            }
        }
    }
}

data class TripModel (val name: String,val img: Int, val year: String, val description: String, val date: String)
    val tripsList = listOf(
        TripModel("Londres", R.drawable.london,"2019" , "London is the capital and largest city of  the United Kingdom, with a population of just under 9 million.", "18 Feb - 21 Feb"),
        TripModel("Porto", R.drawable.porto, "2022", "Porto is the second city in Portugal, the capital of the Oporto District, and one of the Iberian Peninsula`s major urban areas.", "18 Mar - 21 Apr")
    )




@Composable
fun HomeLayout(){
    var cardColor by remember { mutableStateOf(Color(0x88CF06F0)) }
    Surface(modifier = Modifier.fillMaxSize()) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF6F6F6))
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .paint(
                        painterResource(id = R.drawable.homebg),
                        contentScale = ContentScale.FillWidth
                    )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(15.dp)
                ) {
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        horizontalArrangement = Arrangement.End
                    ){
                        Column (
                            horizontalAlignment = Alignment.End
                        ){
                            Card(
                                modifier = Modifier
                                    .size(height = 80.dp, width = 80.dp),
                                colors = CardDefaults.cardColors(containerColor = Color(0xFF2A6391)
                                ),
                                elevation = CardDefaults.cardElevation(5.dp),
                                shape = CircleShape,
                                border = BorderStroke(width = 2.dp, color = Color.White)
                            ){
                                Image(painter = painterResource(id = R.drawable.susannahoffs) , contentDescription ="Foto de Perfil" )
                            }
                            Row {
                                Text(
                                    text = "Susanna Hoffs",
                                    color = Color.White
                                )
                            }
                        }
                    }
                    Column (
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center
                    ){
                        Column {
                            Row {
                                Image(
                                    imageVector = Icons.Filled.LocationOn,
                                    contentDescription ="Icon de localização",
                                    colorFilter = ColorFilter.tint(
                                        Color.White)
                                )
                                Text(
                                    text = "You're in Paris",
                                    color = Color.White,
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.W400
                                )
                            }
                            Row {
                                Text(
                                    text = "My Trips",
                                    color = Color.White,
                                    fontWeight = FontWeight.W800,
                                    fontSize = 28.sp
                                )
                            }
                        }
                    }
                }
            }
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .padding(horizontal = 15.dp),
                verticalArrangement = Arrangement.SpaceEvenly
            ){
                Spacer(modifier = Modifier.height(14.dp))
                Row {
                    Text(
                        text = "Categories",
                        color = Color(0xFF565454)
                    )
                }
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp),
                    horizontalArrangement = Arrangement.SpaceAround
                ){
                    items(5) { index ->
                        Card (
                            modifier = Modifier
                                .width(125.dp)
                                .height(80.dp)
                                .clickable {
                                    cardColor = if (cardColor == Color(0x88CF06F0)){
                                        Color(0xFFCF06F0)
                                    } else {
                                        Color(0x88CF06F0)
                                    }
                                },
                            colors = CardDefaults.cardColors(
                                containerColor = cardColor,
                            ),
                            shape = RoundedCornerShape(10.dp)
                        ){
                            Column (
                                modifier = Modifier
                                    .fillMaxSize(),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ){
                                Image(
                                    painter = painterResource(id = R.drawable.moutain_icon),
                                    contentDescription = "",
                                    modifier = Modifier.height(40.dp)
                                )
                                Text(text = "Mountain", color = Color.White)
                            }
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                    }
                }
            }
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                horizontalArrangement = Arrangement.Center
            ){
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    label = {
                        Text(
                            text = "Search your destiny",
                            color = Color(0xFFA09C9C)
                        )
                    },
                    trailingIcon = { Icon(imageVector = Icons.Outlined.Search, contentDescription = "", tint = Color.Gray)},
                    modifier = Modifier
                        .width(360.dp)
                        .align(Alignment.CenterVertically),
                    shape = RoundedCornerShape(20.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedContainerColor = Color.White,
                        unfocusedBorderColor = Color.Transparent
                    )
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 16.dp, top = 16.dp)
            ) {
                Row {
                    Text(
                        text = "Past Trips",
                        color = Color(0xFF565454)
                    )
                }
                LazyColumn(){ items(tripsList) {model ->
                    Card(
                        modifier = Modifier
                            .width(360.dp)
                            .height(280.dp)
                            .padding(vertical = 8.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        ),
                        elevation = CardDefaults.cardElevation(14.dp)
                    ) {
                        Column(modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 8.dp),
                            verticalArrangement = Arrangement.SpaceEvenly
                        )
                        {
                            Row (
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(130.dp)
                            ){
                                Card {
                                    Image(
                                        painter = painterResource(id = model.img),
                                        contentDescription ="",
                                        contentScale = ContentScale.Crop
                                    )
                                }
                            }
                            Row (modifier = Modifier.fillMaxWidth()) {
                                Text(
                                    text = model.name+", ",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Medium,
                                    color = Color(0xFFCF06F0)
                                )
                                Text(text = model.year,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Normal,
                                    color = Color(0xFFCF06F0)
                                )
                            }
                            Text(
                                text = model.description,
                                lineHeight = 16.sp,
                                fontSize = 13.sp
                            )
                            Row (
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.End
                            ){
                                Text(
                                    text = model.date,
                                    color = Color(0xFFCF06F0),
                                    fontSize = 13.sp
                                )
                            }
                        }

                    }
                }

                }
            }
        }

    }
}



//Card(
//modifier = Modifier
//.width(360.dp)
//.height(280.dp)
//.padding(vertical = 8.dp),
//colors = CardDefaults.cardColors(
//containerColor = Color.White
//),
//elevation = CardDefaults.cardElevation(14.dp)
//) {
//    Column(modifier = Modifier
//        .fillMaxSize()
//        .padding(horizontal = 8.dp),
//        verticalArrangement = Arrangement.SpaceEvenly
//    )
//    {
//        Row (
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(130.dp)
//        ){
//            Card {
//                Image(
//                    painter = painterResource(id = R.drawable.london),
//                    contentDescription ="Cidade de Londres",
//                    contentScale = ContentScale.Crop
//                )
//            }
//        }
//        Text(
//            text = "London, 2019",
//            fontSize = 20.sp,
//            fontWeight = FontWeight.SemiBold,
//            color = Color(0xFFCF06F0)
//        )
//        Text(
//            text = "London is the capital and largest city of  the United Kingdom, with a population of just under 9 million.",
//            lineHeight = 16.sp,
//            fontSize = 13.sp
//        )
//        Row (
//            modifier = Modifier
//                .fillMaxWidth(),
//            horizontalArrangement = Arrangement.End
//        ){
//            Text(
//                text = "18 Feb - 21 Feb",
//                color = Color(0xFFCF06F0),
//                fontSize = 13.sp
//            )
//        }
//    }
//
//}




@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    MyTripsTheme {
        Greeting()
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun SignUpPreview() {
    MyTripsTheme {
        SignUpLayout()
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun HomePreview() {
    MyTripsTheme {
        HomeLayout()
    }
}


