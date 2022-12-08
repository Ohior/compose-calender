package com.example.composecalendar.widget

import android.appwidget.AppWidgetHostView
import android.widget.CalendarView
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import androidx.glance.text.Text

class CalendarWidget : GlanceAppWidget() {

    @Composable
    override fun Content() {
    }

}

class CalendarWidgetReceiver :
    GlanceAppWidgetReceiver() {
    override val glanceAppWidget: GlanceAppWidget
        get() = CalendarWidget()
}
