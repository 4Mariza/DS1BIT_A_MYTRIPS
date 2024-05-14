package br.senai.sp.jandira.mytrips.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowForward
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.mytrips.repository.UsuarioRepository
import br.senai.sp.jandira.mytrips.ui.theme.MyTripsTheme

@Composable
fun Login(controleDeNavegacao: NavHostController) {

    val cr = UsuarioRepository(LocalContext.current)
    val usuarios = cr.buscarTodosOsUsuarios()

    var nomeState = remember {
        mutableStateOf("")
    }

    var passwordState = remember {
        mutableStateOf("")
    }

    var showPassword by remember {
        mutableStateOf(false)
    }

    var mensagemErroState = remember {
        mutableStateOf("")
    }

    var isErrorState = remember {
        mutableStateOf(false)
    }

    MyTripsTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize()
        ){
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
                    shape = RoundedCornerShape(size = 100.dp)
                ){}
                Spacer(modifier = Modifier.height(35.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(420.dp)
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
                            value = nomeState.value,
                            onValueChange = {
                                nomeState.value = it
                            },
                            leadingIcon = { Icon(imageVector = Icons.Filled.Email, contentDescription ="", tint = Color(0xFFBB00FF)) },
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
                                .height(65.dp),
                            isError = isErrorState.value
                        )
                        OutlinedTextField(
                            value = passwordState.value,
                            onValueChange = {
                                passwordState.value = it
                            },
                            visualTransformation = if (showPassword){
                                VisualTransformation.None
                            }else{
                                PasswordVisualTransformation()
                            },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                            trailingIcon = {
                                if (showPassword) {
                                    IconButton(onClick = { showPassword = false }) {
                                        Icon(
                                            imageVector = Icons.Filled.Visibility,
                                            contentDescription = "hide_password"
                                        )
                                    }
                                } else {
                                    IconButton(
                                        onClick = { showPassword = true }) {
                                        Icon(
                                            imageVector = Icons.Filled.VisibilityOff,
                                            contentDescription = "hide_password"
                                        )
                                    }
                                }
                            },
                            leadingIcon = { Icon(imageVector = Icons.Filled.Lock, contentDescription ="", tint = Color(0xFFBB00FF) ) },
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
                                .height(65.dp),
                            isError = isErrorState.value
                        )
                    }

                    Spacer(modifier = Modifier.height(18.dp))
                    Text(
                        text = mensagemErroState.value,
                        color = Color.Red,
                        modifier = Modifier.padding(start = 28.dp)
                    )
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 28.dp),
                        horizontalArrangement = Arrangement.End
                    ){
                        Button(
                            onClick = {
                                for (user in usuarios){
                                    if(nomeState.value == user.email && passwordState.value == user.senha){
                                        controleDeNavegacao.navigate("home")
                                    } else {
                                        isErrorState.value = true
                                        mensagemErroState.value = "Usuário ou senha inválidos!"
                                    }
                                }
                            },
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
                                Icon(imageVector = Icons.AutoMirrored.Outlined.ArrowForward, contentDescription ="" )
                            }
                        }
                    }
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp)
                            .padding(end = 28.dp),
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.Bottom
                    ){
                        Text(
                            text = "Don’t have an account?",
                            color = Color(0xFFA09C9C)
                        )
                        Text(
                            text = "Sign up",
                            fontSize = 16.sp,
                            color = Color(0xFFBB00FF),
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .height(22.dp)
                                .clickable {
                                    controleDeNavegacao.navigate("signup")
                                }
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
                            .offset(x = -22.dp, y = 65.dp),
                        shape = RoundedCornerShape(topEnd = 30.dp, bottomStart = 30.dp)
                    ){}
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginPreview() {
    MyTripsTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize()
        ){}
    }
}