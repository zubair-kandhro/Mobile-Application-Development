package com.example.lab4task1

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab4task1.ui.theme.Lab4Task1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab4Task1Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FavoriteColorScreen()
                }
            }
        }
    }
}

@Composable
fun FavoriteColorScreen() {
    var favoriteColor by remember { mutableStateOf("") }
    val sharedPreferences = LocalContext.current.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = favoriteColor,
            onValueChange = { favoriteColor = it },
            label = { Text("Enter your favorite color") },
        )


        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                sharedPreferences.edit().putString("favorite_color", favoriteColor).apply()
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Save")
        }

        Spacer(modifier = Modifier.height(16.dp))

        val storedColor = sharedPreferences.getString("favorite_color", "")
        Text(
            text = "Your favorite color is: $storedColor",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFavoriteColorScreen() {
    Lab4Task1Theme {
        FavoriteColorScreen()
    }
}
