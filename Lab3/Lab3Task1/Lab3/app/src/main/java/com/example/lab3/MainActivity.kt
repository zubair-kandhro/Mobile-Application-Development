package com.example.lab3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab3.ui.theme.Lab3Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Task1()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Task1() {

    Scaffold(


        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.run {
                    largeTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        titleContentColor = MaterialTheme.colorScheme.primary,
                    )
                },
                title = {
                    Text("Lab2Ex2 Activity Experiment", style = TextStyle(color = Color.White, fontWeight = FontWeight.Bold, fontSize = 22.sp));

                }
            )
        }

    ) {
            innerPadding -> Column(
        modifier = Modifier
            .padding(innerPadding).offset(x=10.dp, y = 10.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Text(
            modifier = Modifier.padding(8.dp),
            text = "1. what callbacks are  called when an app is first launched?");
        Text(
            modifier = Modifier.padding(8.dp),
            text = "2. what callbacks occur when Home is pressed ?");
        Text(
            modifier = Modifier.padding(8.dp),
            text = "3. what callbacks are occur when an app is restarted from the launcher ?");
        Text(
            modifier = Modifier.padding(8.dp),
            text = "4. what callbacks are occur when the device is rotated?");

    }
    }

}

@Preview(showBackground = true)
@Composable
fun Task1Preview() {
    Lab3Theme {
        Task1()
    }
}