package com.example.lab2task3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab2task3.ui.theme.Lab2Task3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab2Task3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    View()
                }
            }
        }
    }
}

@Composable
fun View() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.LightGray)

    ) {
        Row (modifier = Modifier
            .height(120.dp)
            .padding(10.dp)
            .background(color = Color.White),

            ){

            Column(modifier = Modifier) {
                Image(
                    painter = painterResource(id = R.drawable.ironman),
                    contentDescription = null,
                    modifier = Modifier
                        .height(110.dp)
                        .padding(10.dp)
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 15.dp)

                ) {
                    Text(text = "Iron Man", fontSize = 26.sp, fontWeight = FontWeight.Bold, fontFamily = FontFamily.Serif)
                    Text(text = "Age: 43", fontWeight = FontWeight.Bold, fontFamily = FontFamily.Serif, color = Color.Gray)
            }
        }
        Row (modifier = Modifier
            .height(120.dp)
            .padding(10.dp)
            .background(color = Color.White),

            ){

            Column(modifier = Modifier) {
                Image(
                    painter = painterResource(id = R.drawable.hulk),
                    contentDescription = null,
                    modifier = Modifier
                        .height(110.dp)
                        .padding(10.dp)
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 15.dp)

                ) {
                Text(text = "Hulk", fontSize = 26.sp, fontWeight = FontWeight.Bold, fontFamily = FontFamily.Serif)
                Text(text = "Age: 38", fontWeight = FontWeight.Bold, fontFamily = FontFamily.Serif, color = Color.Gray)
            }
        }
        Row (modifier = Modifier
            .height(120.dp)
            .padding(10.dp)
            .background(color = Color.White),

            ){

            Column(modifier = Modifier) {
                Image(
                    painter = painterResource(id = R.drawable.deadpool),
                    contentDescription = null,
                    modifier = Modifier
                        .height(110.dp)
                        .padding(10.dp)
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 15.dp)

                ) {
                Text(text = "Deadpool", fontSize = 26.sp, fontWeight = FontWeight.Bold, fontFamily = FontFamily.Serif)
                Text(text = "Age: 25", fontWeight = FontWeight.Bold, fontFamily = FontFamily.Serif, color = Color.Gray)
            }
        }
        Row (modifier = Modifier
            .height(120.dp)
            .padding(10.dp)
            .background(color = Color.White),

            ){

            Column(modifier = Modifier) {
                Image(
                    painter = painterResource(id = R.drawable.wolverien),
                    contentDescription = null,
                    modifier = Modifier
                        .height(110.dp)
                        .padding(10.dp)
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 15.dp)

                ) {
                Text(text = "Wolverine", fontSize = 26.sp, fontWeight = FontWeight.Bold, fontFamily = FontFamily.Serif)
                Text(text = "Age: 48", fontWeight = FontWeight.Bold, fontFamily = FontFamily.Serif, color = Color.Gray)
            }
        }
        Row (modifier = Modifier
            .height(120.dp)
            .padding(10.dp)
            .background(color = Color.White),

            ){

            Column(modifier = Modifier) {
                Image(
                    painter = painterResource(id = R.drawable.blackwidow),
                    contentDescription = null,
                    modifier = Modifier
                        .height(110.dp)
                        .padding(10.dp)
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 15.dp)

                ) {
                Text(text = "Black Widow", fontSize = 26.sp, fontWeight = FontWeight.Bold, fontFamily = FontFamily.Serif)
                Text(text = "Age: 30", fontWeight = FontWeight.Bold, fontFamily = FontFamily.Serif, color = Color.Gray)
            }
        }
        Row (modifier = Modifier
            .height(120.dp)
            .padding(10.dp)
            .background(color = Color.White),

            ){

            Column(modifier = Modifier) {
                Image(
                    painter = painterResource(id = R.drawable.thor),
                    contentDescription = null,
                    modifier = Modifier
                        .height(110.dp)
                        .padding(10.dp)
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 15.dp)

                ) {
                Text(text = "Thor", fontSize = 26.sp, fontWeight = FontWeight.Bold, fontFamily = FontFamily.Serif)
                Text(text = "Age: 35", fontWeight = FontWeight.Bold, fontFamily = FontFamily.Serif, color = Color.Gray)
            }
        }

    }

}



@Preview(showBackground = true)
@Composable
fun ViewPreview() {
    Lab2Task3Theme {
        View()
    }
}