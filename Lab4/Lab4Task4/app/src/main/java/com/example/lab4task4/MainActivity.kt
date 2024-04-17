package com.example.lab4task4

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat.requestPermissions
import com.example.lab4task4.ui.theme.Lab4Task4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab4Task4Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ImageList()
                }
            }
        }
    }
}

@Composable
fun ImageList() {
    val context = LocalContext.current
    val images = getImagesFromExternalStorage(context)

    Column {
        images.forEach { imageUri ->
            Image(
                painter = BitmapPainter(LocalContext.current.contentResolver.loadThumbnail(imageUri, null)),
                contentDescription = null
            )
        }
    }
}

fun getImagesFromExternalStorage(context: android.content.Context): List<android.net.Uri> {
    val images = mutableListOf<android.net.Uri>()
    val projection = arrayOf(MediaStore.Images.Media._ID)
    val selection = "${MediaStore.Images.Media.DATA} like ?"
    val selectionArgs = arrayOf("%YOUR_DIRECTORY_PATH%") // Replace with your directory path
    val sortOrder = "${MediaStore.Images.Media.DATE_MODIFIED} DESC"

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M &&
        context.checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
        // Request permission if not granted
        requestPermissions(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), PERMISSION_REQUEST_CODE)
    } else {
        // Fetch images if permission granted
        context.contentResolver.query(
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
            projection,
            selection,
            selectionArgs,
            sortOrder
        )?.use { cursor ->
            val idColumn = cursor.getColumnIndexOrThrow(MediaStore.Images.Media._ID)
            while (cursor.moveToNext()) {
                val id = cursor.getLong(idColumn)
                val uri = android.net.Uri.withAppendedPath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, id.toString())
                images.add(uri)
            }
        }
    }

    return images
}

@Preview(showBackground = true)
@Composable
fun ImageListPreview() {
    Lab4Task4Theme {
        ImageList()
    }
}
