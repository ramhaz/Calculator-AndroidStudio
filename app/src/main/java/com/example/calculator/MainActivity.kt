package com.example.calculator

import android.os.Bundle
import android.webkit.WebSettings
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                Column  (
                    modifier = Modifier
                        .padding(innerPadding)
                        .padding(16.dp)
                )
                {
                     extracted(innerPadding) // your existing content


                    ColumnButton()

                    // now safely inside the Scaffold
                }
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(text = "$name", modifier = modifier, fontSize = 50.sp)

}

@Composable
private fun extracted(innerPadding: PaddingValues) {
    Column(modifier = Modifier.padding(0.dp)) {
        com.example.calculator.Greeting(

            name = "CALCULATOR",
            modifier = Modifier.padding(30.dp)
        )
    }
}


@Composable
fun ColumnButton() {
    var number1 by rememberSaveable { mutableStateOf(0) }
    var number2 by rememberSaveable { mutableStateOf(0) }
    var sum by rememberSaveable { mutableStateOf(number1 + number2) } // this is a way of making variabls

    Column {
        Row {
            OutlinedTextField(
                value = number1.toString(), onValueChange = { number1 = it.toIntOrNull() ?: 0 },
                label = { Text("number1", modifier = Modifier.padding(10.dp), fontSize = 20.sp) }
            )

        }
    }
    Column {
        Row {
            OutlinedTextField(
                value = number2.toString(), onValueChange = { number2 = it.toIntOrNull() ?: 0 },
                label = { Text("number2", modifier  = Modifier.padding(10.dp), fontSize = 20.sp) }
            )
        }


        Row {
            Button(onClick = { sum = number1 + number2 }) { Text("+") }
            Button(onClick = { sum = number1 - number2 }) { Text("-") }
            Button(onClick = { sum = number1 * number2 }) { Text("*") }
            Button(onClick = { sum = number1 / number2 }) { Text("%") }


        }
    }
    Column {
        Row {
            OutlinedTextField(
                value = sum.toString(), onValueChange = { sum = it.toIntOrNull() ?: 0 },
                label = { Text("SUM", modifier = Modifier.padding(10.dp), fontSize = 20.sp) }
            )
        }
    }
}