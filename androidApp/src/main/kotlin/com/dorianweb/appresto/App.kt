package com.dorianweb.appresto


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
@Preview
fun App() {
    MaterialTheme {
        var  showContent by remember { mutableStateOf(false) }
        Surface(
            modifier = Modifier.fillMaxWidth().statusBarsPadding().navigationBarsPadding(),
            color = MaterialTheme.colorScheme.onBackground
        ){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                    HeaderSection("Le Petit Bistro", "🍽️")
                    Illustration()
                    Presentation("Une cuisine maison, des produits frais et une ambiance conviviale.")
                    val plat1 = Plat("Burger maison", 14)
                    val plat2 = Plat("Salade végétarienne", 11)
                    val plat3 = Plat("Tarte aux pommes", 6)
                    Menu(listOf(plat1,plat2,plat3))
                    Info()
            }
        }
    }
}


@Composable
fun HeaderSection(
    restoName : String,
    emoji : String)
{
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.onSurface
        )
    ) {
        Row(
        modifier = Modifier.fillMaxWidth().padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
            Text(
                text = restoName,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White
            )
            Text(
                text = emoji,
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }
}


@Composable
fun Presentation(
    presentation : String
) {
Card(
    modifier = Modifier.fillMaxWidth(),
    colors = CardDefaults.cardColors(
        containerColor = MaterialTheme.colorScheme.onBackground)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Text(
                text = presentation,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.SemiBold,
                fontStyle = FontStyle.Italic,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun Menu(
    menu : List<Plat>
) {
    Card(
    modifier = Modifier.fillMaxWidth(),
    colors = CardDefaults.cardColors(
        containerColor = MaterialTheme.colorScheme.onSurfaceVariant)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
            text = "Les plats du moment :",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
            Row(
                modifier = Modifier.fillMaxWidth().padding(10.dp, 20.dp),
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 15.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    for (plat in menu) {
                        Row(
                            modifier = Modifier.fillMaxWidth().padding(5.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                            text = "${plat.name} : ",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White
                        )
                            Text(
                                text = "${plat.price}€",
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.White
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Info() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.onBackground)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(10.dp).padding(horizontal = 5.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row() {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Adresse : ",
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White
                    )
                    Text(
                        text = "86 rue aux arènes, 57000 Metz",
                        style = MaterialTheme.typography.labelLarge,
                        color = Color.White
                    )
                }
            }

            Row() {
                Column(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Horaires :",
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White
                    )
                    Text(
                        text = "du lundi au samedi,",
                        style = MaterialTheme.typography.labelLarge,
                        color = Color.White
                    )
                    Text(
                        text = "de 12h à 14h et de 19h à 22h",
                        style = MaterialTheme.typography.labelLarge,
                        color = Color.White
                    )
                }

            }
        }
    }
}

@Composable
fun Illustration() {
    Image(
        painter = painterResource(id = R.drawable.restaurant),
        contentDescription = "Mon restaurant",
        modifier = Modifier.fillMaxWidth().height(250.dp)
    )
}

data class Plat(
    val name : String,
    val price : Int
)
