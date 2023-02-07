package com.alvarogm.apisremotas.ui.theme.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.alvarogm.apisremotas.data.JokeClass


@Composable
fun JokeCell(joke: JokeClass) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {

            if (joke.type == "twopart") {
                Text(
                    text = joke.lang + " - " + joke.category,
                    style = TextStyle(color = Color(0xFF87CEFA))
                )
                Text(text = joke.setup)//pregunta
                Text(text = joke.delivery, style = TextStyle(color = Color.Red))//respuesta
            } else {
                Text(
                    text = joke.lang + " - " + joke.category,
                    style = TextStyle(color = Color(0xFF87CEFA))
                )
                Text(text = joke.joke)
            }

            /*  Text(text = joke.category)
                Text(text = joke.lang, style = TextStyle(color = Color.LightGray))*/
            //Text(text = joke.toString(), fontWeight = FontWeight.Bold)
            //Text(text = joke.setup.toString(), fontWeight = FontWeight.Bold)
        }
    }
}