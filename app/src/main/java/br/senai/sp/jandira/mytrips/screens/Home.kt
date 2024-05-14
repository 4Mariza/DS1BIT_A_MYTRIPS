package br.senai.sp.jandira.mytrips.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
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
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.mytrips.R
import br.senai.sp.jandira.mytrips.repository.CategoriaRepository
import br.senai.sp.jandira.mytrips.repository.UsuarioRepository
import br.senai.sp.jandira.mytrips.repository.ViagemRepository
import br.senai.sp.jandira.mytrips.simplificarData
import br.senai.sp.jandira.mytrips.ui.theme.MyTripsTheme

@Composable
fun Home(controleDeNavegacao: NavHostController) {
    val viagens = ViagemRepository().listarTodasAsViagens()

    val categorias = CategoriaRepository().listarTodasAsCategorias()

    val cr = UsuarioRepository(LocalContext.current)

    var cardColor by remember { mutableStateOf(Color(0x88CF06F0)) }

    var searchState = remember {
        mutableStateOf("")
    }

    MyTripsTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFF6F6F6))
            ) {
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
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Button(
                                onClick = {
                                    controleDeNavegacao.navigate("login")
                                },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.Transparent
                                ),
                                contentPadding = PaddingValues(0.dp)
                            ) {
                                Image(
                                    imageVector = Icons.Filled.ArrowBackIosNew,
                                    contentDescription = "Seta para voltar",
                                    colorFilter = ColorFilter.tint(Color.White)
                                )
                            }
                            Column(
                                horizontalAlignment = Alignment.End
                            ) {
                                Card(
                                    modifier = Modifier
                                        .size(height = 80.dp, width = 80.dp),
                                    colors = CardDefaults.cardColors(
                                        containerColor = Color(0xFF2A6391)
                                    ),
                                    elevation = CardDefaults.cardElevation(5.dp),
                                    shape = CircleShape,
                                    border = BorderStroke(width = 2.dp, color = Color.White)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.susannahoffs),
                                        contentDescription = "Foto de Perfil"
                                    )
                                }
                                Row {
                                    Text(
                                        text = "Susanna Hoffs",
                                        color = Color.White
                                    )
                                }
                            }
                        }
                        Column(
                            modifier = Modifier
                                .fillMaxSize(),
                            verticalArrangement = Arrangement.Center
                        ) {
                            Column {
                                Row {
                                    Image(
                                        imageVector = Icons.Filled.LocationOn,
                                        contentDescription = "Icon de localização",
                                        colorFilter = ColorFilter.tint(
                                            Color.White
                                        )
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
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .padding(horizontal = 15.dp),
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
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
                    ) {
                        items(categorias) {
                            Card(
                                modifier = Modifier
                                    .width(125.dp)
                                    .height(80.dp)
                                    .clickable {
                                        cardColor = if (cardColor == Color(0x88CF06F0)) {
                                            Color(0xFFCF06F0)
                                        } else {
                                            Color(0x88CF06F0)
                                        }
                                    },
                                colors = CardDefaults.cardColors(
                                    containerColor = cardColor,
                                ),
                                shape = RoundedCornerShape(10.dp)
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize(),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    Image(
                                        painter = if(it.icone == null) painterResource(id = R.drawable.no_icon) else it.icone!!,
                                        contentDescription = "",
                                        modifier = Modifier.height(40.dp)
                                    )
                                    Text(text = it.categoria, color = Color.White)
                                }
                            }
                            Spacer(modifier = Modifier.width(10.dp))
                        }
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    OutlinedTextField(
                        value = searchState.value,
                        onValueChange = {
                            searchState.value = it
                        },
                        label = {
                            Text(
                                text = "Search your destiny",
                                color = Color(0xFFA09C9C)
                            )
                        },
                        trailingIcon = {
                            Icon(
                                imageVector = Icons.Outlined.Search,
                                contentDescription = "",
                                tint = Color.Gray
                            )
                        },
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
                    LazyColumn() {
                        items(viagens) {
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
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(horizontal = 8.dp),
                                    verticalArrangement = Arrangement.SpaceEvenly
                                )
                                {
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(130.dp)
                                    ) {
                                        Card {
                                            Image(
                                                painter = if(it.imagem == null) painterResource(id = R.drawable.no_image) else it.imagem!!,
                                                contentDescription = "Imagem Do Destino",
                                                contentScale = ContentScale.Crop
                                            )
                                        }
                                    }
                                    Row(modifier = Modifier.fillMaxWidth()) {
                                        Text(
                                            text = "${it.destino}, ${it.dataChegada.year}",
                                            fontSize = 20.sp,
                                            fontWeight = FontWeight.Medium,
                                            color = Color(0xFFCF06F0)
                                        )
                                    }
                                    Text(
                                        text = it.descricao,
                                        lineHeight = 16.sp,
                                        fontSize = 13.sp
                                    )
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth(),
                                        horizontalArrangement = Arrangement.End
                                    ) {
                                        Text(
                                            text = "${simplificarData(it.dataChegada)} - ${simplificarData(it.dataPartida)}",
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
}

@Preview(showSystemUi = true, showBackground =true)
@Composable
fun HomePreview() {
    MyTripsTheme {
        Surface (
            modifier = Modifier.fillMaxSize()
        ){}
    }
}