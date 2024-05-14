package br.senai.sp.jandira.mytrips.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.mytrips.R
import br.senai.sp.jandira.mytrips.model.Usuario
import br.senai.sp.jandira.mytrips.repository.UsuarioRepository
import br.senai.sp.jandira.mytrips.ui.theme.MyTripsTheme

@Composable
fun SignUp(controleDeNavegacao: NavHostController) {

    val cr = UsuarioRepository(LocalContext.current)

    var nomeState = remember {
        mutableStateOf("")
    }

    var emailState = remember {
        mutableStateOf("")
    }

    var phoneState = remember {
        mutableStateOf("")
    }

    var passwordState = remember {
        mutableStateOf("")
    }

    var showPassword by remember {
        mutableStateOf(false)
    }

    var checkState = remember {
        mutableStateOf(false)
    }

    var mensagemErroState = remember {
        mutableStateOf("")
    }

    var isErrorState = remember {
        mutableStateOf(false)
    }

    MyTripsTheme {
        Surface (
            modifier = Modifier
                .fillMaxSize()
        ){
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
                        text = stringResource(id = R.string.signUp_title),
                        fontSize = 38.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFFBB00FF)
                    )
                    Text(
                        text = stringResource(id = R.string.signUp_phrase),
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
                    Text(text = mensagemErroState.value, color = Color.Red,  modifier = Modifier.padding(start = 28.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(270.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        OutlinedTextField(
                            value = nomeState.value,
                            onValueChange = {
                                nomeState.value = it
                            },
                            leadingIcon = { Icon(imageVector = Icons.Filled.Person, contentDescription ="", tint = Color(0xFFBB00FF) ) },
                            label = {
                                Text(text = stringResource(id = R.string.signUp_username))
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
                            value = phoneState.value,
                            onValueChange = {
                                phoneState.value = it
                            },
                            leadingIcon = { Image(painter = painterResource(id = R.drawable.phone), contentDescription = "") },
                            label = {
                                Text(text = stringResource(id = R.string.signUp_phone))
                            },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
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
                            value = emailState.value,
                            onValueChange = {
                                emailState.value = it
                            },
                            leadingIcon = { Icon(imageVector = Icons.Filled.Email, contentDescription ="", tint = Color(0xFFBB00FF)) },
                            label = {
                                Text(text = "Email")
                            },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
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
                                Text(text = stringResource(id = R.string.signUp_password))
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
                            Checkbox(checked = checkState.value,
                                onCheckedChange ={
                                    checkState.value = it
                                },
                                colors = CheckboxDefaults.
                                colors(
                                    uncheckedColor = Color(0xFFBB00FF)
                                ))
                            Text(text = stringResource(id = R.string.signUp_is_over_18))
                        }
                        Row (
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ){
                            Button(
                                onClick = {
                                    if (nomeState.value == "" || phoneState.value == "" || emailState.value == "" || passwordState.value == ""){
                                        isErrorState.value = true
                                        mensagemErroState.value = "Campos não foram preenchidos corretamente!"
                                    } else {
                                        //Criar um objetom Usuario

                                        val usuario = Usuario (
                                                nome = nomeState.value,
                                                email = emailState.value,
                                                telefone = phoneState.value,
                                                isMaior = checkState.value,
                                                senha =  passwordState.value
                                                )

                                        cr.salvar(usuario = usuario)
                                        controleDeNavegacao.navigate("home")
                                    }
                                },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFFBB00FF)
                                ),
                                modifier = Modifier
                                    .width(340.dp)
                                    .height(50.dp),
                                shape = RoundedCornerShape(20.dp)
                            ) {
                                Text(
                                    text = stringResource(id = R.string.signUp_button),
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
                                text = stringResource(id = R.string.signUp_already_has_account),
                                color = Color(0XFFA09C9C)
                            )
                            Text(
                                text = stringResource(id = R.string.signUp_login_text),
                                fontSize = 16.sp,
                                color = Color(0xFFBB00FF),
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .height(22.dp)
                                    .clickable {
                                        controleDeNavegacao.navigate("login")
                                    }
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
                                    .height(50.dp)
                                    .offset(x = -22.dp, y = 15.dp),
                                shape = RoundedCornerShape(topEnd = 30.dp, bottomStart = 30.dp)
                            ){}
                        }
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun SignUpPreview() {
    MyTripsTheme {
        Surface (
            modifier = Modifier
                .fillMaxSize()
        ){}
    }
}