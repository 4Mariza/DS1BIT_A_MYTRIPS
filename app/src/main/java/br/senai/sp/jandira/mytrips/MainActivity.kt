package br.senai.sp.jandira.mytrips

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
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
                }
                SignUpLayout()

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
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
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
                        .height(70.dp)
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
                        .height(70.dp)
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
                        .height(70.dp)
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
                        .height(70.dp)
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
                        .height(70.dp)
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
                        .height(70.dp)
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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    MyTripsTheme {
        Greeting()
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun SignUp() {
    MyTripsTheme {
        SignUpLayout()
    }
}
