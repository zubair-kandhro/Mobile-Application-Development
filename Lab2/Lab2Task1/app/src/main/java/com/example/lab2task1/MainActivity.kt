package com.example.lab2task1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab2task1.ui.theme.Lab2Task1Theme
import androidx.compose.runtime.*
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab2Task1Theme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Hello()
                }
            }
        }
    }
}

@Composable
fun Hello() {
    var buttonClicked by remember { mutableStateOf(false) }
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Button(
            onClick = { buttonClicked = !buttonClicked },
            modifier = Modifier
                .height(45.dp)
                .width(120.dp),
            colors = ButtonDefaults.buttonColors(if (buttonClicked) Color.Green else Color.Red),
            shape = RoundedCornerShape(8.dp)
            ) {
            Text(text = "Click Me", fontSize = 18.sp, color = Color.Black)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HelloPreview() {
    Lab2Task1Theme {
        Column (modifier = Modifier.fillMaxSize()){
            Hello()
        }
    }
}