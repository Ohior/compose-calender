package com.example.composecalendar

import android.os.Bundle
import android.widget.CalendarView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composecalendar.model.AppBody
import com.example.composecalendar.model.AppWindow
import com.example.composecalendar.ui.theme.ComposeCalendarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCalendarTheme {
                AppWindow(context = this) { paddingValues ->
                    AppBody(paddingValues = paddingValues)
                }
            }
        }
    }
}