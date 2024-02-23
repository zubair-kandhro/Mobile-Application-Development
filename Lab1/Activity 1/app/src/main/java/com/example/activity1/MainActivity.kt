package com.example.activity1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private var numToGuess = Random.nextInt(1000)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val guessButton = findViewById<Button>(R.id.Button)
        guessButton.setOnClickListener {
            validate()
        }
    }

    fun validate() {
        var inputField = findViewById<EditText>(R.id.EditText)
        var textLabel = findViewById<TextView>(R.id.TextView)
        val number = Integer.parseInt(inputField.text.toString())

        if(number > numToGuess)
            textLabel.text = "Your guess is Too High"
        else if (number < numToGuess)
            textLabel.text = "Your guess is Too Low"
        else
            textLabel.text = "Hoorah!! ... You guessed it correctly"


    }
}
