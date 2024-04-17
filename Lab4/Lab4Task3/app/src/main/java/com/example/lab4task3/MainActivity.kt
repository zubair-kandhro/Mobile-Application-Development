import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.runtime.mutableStateListOf

import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab4task3.ui.theme.Lab4Task3Theme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab4Task3Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NoteApp()
                }
            }
        }
    }
}

@Composable
fun NoteApp() {
    var newNote by remember { mutableStateOf("") }
    val savedNotes = remember { mutableStateListOf<String>() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Input field for adding new notes
        TextField(
            value = newNote,
            onValueChange = { newNote = it },
            label = { Text("Enter new note") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Button to save new note
        Button(
            onClick = {
                saveNote(newNote, savedNotes)
                newNote = ""
            }
        ) {
            Text("Save Note")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Display list of saved notes
        savedNotes.forEach { note ->
            Text(text = note)
        }

        // Load saved notes on app start
        LaunchedEffect(true) {
            savedNotes.addAll(loadSavedNotes())
        }
    }
}

// Function to save a new note to internal storage
fun saveNote(note: String, savedNotes: MutableStateList<String>) {
    val file = File(getAppContext().filesDir, "notes.txt")
    file.appendText("$note\n")
    savedNotes.add(note)
}

// Function to load all saved notes from internal storage
suspend fun loadSavedNotes(): List<String> {
    return withContext(Dispatchers.IO) {
        val file = File(getAppContext().filesDir, "notes.txt")
        if (file.exists()) {
            file.readLines()
        } else {
            emptyList()
        }
    }
}

// Utility function to get the application context
fun getAppContext(): Context {
    return AppContextProvider.appContext!!
}

object AppContextProvider {
    var appContext: Context? = null
}

@Preview(showBackground = true)
@Composable
fun PreviewNoteApp() {
    Lab4Task3Theme {
        NoteApp()
    }
}
