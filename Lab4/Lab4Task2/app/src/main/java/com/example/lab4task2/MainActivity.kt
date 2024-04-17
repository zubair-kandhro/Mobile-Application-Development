import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.createDataStore
import com.example.lab4task2.ui.theme.Lab4Task2Theme
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab4Task2Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CounterScreen()
                }
            }
        }
    }
}

val COUNTER_KEY = preferencesKey<Int>("counter")

fun readCounter(dataStore: DataStore<Preferences>): Flow<Int> {
    return dataStore.data
        .map { preferences ->
            preferences[COUNTER_KEY] ?: 0
        }
}

suspend fun incrementCounter(dataStore: DataStore<Preferences>) {
    dataStore.edit { preferences ->
        val currentCounter = preferences[COUNTER_KEY] ?: 0
        preferences[COUNTER_KEY] = currentCounter + 1
    }
}

@Composable
fun CounterScreen() {
    val dataStore = remember { createDataStore(name = "counter_preferences") }

    val counter by readCounter(dataStore).collectAsState(initial = 0)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Counter value is: $counter",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                runBlocking {
                    incrementCounter(dataStore)
                }
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Increment Counter")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCounterScreen() {
    Lab4Task2Theme {
        CounterScreen()
    }
}
