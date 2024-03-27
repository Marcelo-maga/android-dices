package com.marcelomaga.dados

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.marcelomaga.dados.ui.theme.DadosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DadosTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppDado()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppDado() {
    DadosTheme {
        DadosComBotao(
            Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center))
    }
}

@Composable
fun DadosComBotao(modifier: Modifier = Modifier) {
    var result by remember {
        mutableIntStateOf(1)
    }

    val idImage = when (result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    Column(modifier = modifier) {
        Image(
            painter = painterResource(id = idImage),
            contentDescription = "1",
        )
        Button(
            onClick = {
                val interval = 1..6
                result = interval.random()
            }
        ) {
            Text(
                text = "Rolar o Dado",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
