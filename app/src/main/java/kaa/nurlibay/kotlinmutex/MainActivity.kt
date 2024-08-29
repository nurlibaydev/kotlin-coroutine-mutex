package kaa.nurlibay.kotlinmutex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import kaa.nurlibay.kotlinmutex.ui.theme.KotlinMutexTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinMutexTheme {
                MainScreen()
            }
        }
    }
}