package kaa.nurlibay.kotlinmutex

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex

@Composable
fun MainScreen() {

    val mutex = remember { Mutex() }
    var counter by remember { mutableIntStateOf(0) }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        LaunchedEffect(key1 = Unit) {
            Log.d("natiyje", "LaunchedEffect")
            repeat(times = 10){
                launch {
                    mutex.lock()
                    try {
                        Log.d("natiyje: launch", "launch: $it")
                        delay(timeMillis = 1000)
                        counter++
                    } catch (e: Exception) {
                        mutex.unlock()
                    }
                }
            }
        }

        Text(
            text = "$counter",
            fontSize = MaterialTheme.typography.displaySmall.fontSize,
            fontWeight = FontWeight.Bold
        )
    }
}