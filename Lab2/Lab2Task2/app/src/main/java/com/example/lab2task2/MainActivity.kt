package com.example.lab2task2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab2task2.ui.theme.Lab2Task2Theme
import kotlin.math.round

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab2Task2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LayoutPrc()
                }
            }
        }
    }
}

@Composable
fun LayoutPrc() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(2.dp),
        verticalArrangement = Arrangement.Center

    ) {
        Row (modifier = Modifier
            .height(120.dp)
            .border(2.dp, Color.Red, shape = RoundedCornerShape(10.dp))
            .padding(10.dp),

            ){


            Column(modifier = Modifier) {
                Image(
                    painter = painterResource(id = R.drawable.me),
                    contentDescription = null,
                    modifier = Modifier
                        .border(2.dp, Color.DarkGray, shape = RoundedCornerShape(10.dp))
                        .padding(2.dp)
                        .fillMaxHeight()



                )

            }

            Spacer(modifier = Modifier.width(4.dp))

            Column(
                modifier = Modifier
                    .border(2.dp, Color.DarkGray, shape = RoundedCornerShape(10.dp))
                    .fillMaxSize().padding(4.dp),
                verticalArrangement = Arrangement.Center,

            ) {
                Column (modifier = Modifier)
                {
                    BasicTextField(
                        value = " Zubair",
                        onValueChange = { var text = it },
                        textStyle = TextStyle(fontSize = 20.sp, textAlign = TextAlign.Center),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(30.dp)
                            .border(2.dp, Color.Magenta, shape = RoundedCornerShape(50.dp))


                    )
                }
                Spacer(modifier = Modifier.height(10.dp))

                Column (modifier = Modifier){

                    BasicTextField(
                        value = " 03123456789",
                        onValueChange = { var text = it },
                        textStyle = TextStyle(fontSize = 20.sp, textAlign = TextAlign.Center),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(30.dp)
                            .border(2.dp, Color.Magenta, shape = RoundedCornerShape(50.dp))
                    )

                }


            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LayoutPrcPreview() {
    Lab2Task2Theme {
        LayoutPrc()
    }
}