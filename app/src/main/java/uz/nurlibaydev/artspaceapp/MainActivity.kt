package uz.nurlibaydev.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import uz.nurlibaydev.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    ArtSpaceScreen()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceScreen() {

    val dataState by remember { mutableStateOf(PicturesData()) }
    var count by remember { mutableStateOf(0) }

    Column(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = dataState.name),
            contentDescription = dataState.description)
        Text(text = dataState.description,
            fontSize = 24.sp,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally))

        Row(modifier = Modifier.fillMaxWidth()) {
            Button(onClick = { if (count != 0) count = count-- }) {
                Text(text = "Previous")
            }
            Button(onClick = { if (count < 3) count = count++ }) {
                Text(text = "Next")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceAppTheme {
        ArtSpaceScreen()
    }
}