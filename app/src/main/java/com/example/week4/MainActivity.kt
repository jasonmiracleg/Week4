package com.example.week4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.week4.ui.theme.Week4Theme
import com.example.week4.ui.view.PreviewSoal1
import com.example.week4.ui.view.PreviewSoal2
import com.example.week4.ui.view.PreviewSoal3
import com.example.week4.ui.view.PreviewSoal4

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Week4Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PreviewSoal4()
                }
            }
        }
    }
}