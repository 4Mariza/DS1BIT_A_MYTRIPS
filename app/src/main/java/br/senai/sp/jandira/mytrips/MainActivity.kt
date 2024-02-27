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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
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
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(460.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
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
                    .offset(x = -22.dp, y = 104.dp),
                shape = RoundedCornerShape(topEnd = 30.dp, bottomStart = 30.dp)
            ){}
        }
    }
}

@Composable
fun SignUpLayout() {
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
    Column {

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    MyTripsTheme {
        Greeting()
    }
}

@Preview
@Composable
fun SignUp() {
    MyTripsTheme {
        SignUpLayout()
    }
}
