package com.example.dailyquotewidget

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import kotlin.random.Random

class QuoteWidget : AppWidgetProvider() {
    companion object {
        private const val WIDGET_CLICK =
            "com.example.dailyquotewidget.WIDGET_CLICK" // Fixed package name

        private val QUOTES = listOf(
            "Believe in yourself!" to "Anonymous",
            "Success is not final, failure is not fatal." to "Winston Churchill",
            "Do what you can, with what you have." to "Theodore Roosevelt",
            "Act as if what you do makes a difference." to "William James",
            "Dream big and dare to fail." to "Norman Vaughan",
            "You are enough just as you are." to "Meghan Markle",
            "The best way to predict the future is to create it." to "Peter Drucker",
            "Turn your wounds into wisdom." to "Oprah Winfrey",
            "Do what you love and love what you do." to "Ray Bradbury",
            "Opportunities don't happen, you create them." to "Chris Grosser"
        )

        fun updateWidget(context: Context, appWidgetManager: AppWidgetManager, appWidgetId: Int) {
            val views = RemoteViews(context.packageName, R.layout.widget_layout)

            // Pick a random quote
            val (quote, author) = QUOTES.random()
            views.setTextViewText(R.id.quote_text, quote)
            views.setTextViewText(R.id.quote_author, "- $author")

            // Set up click event to refresh quote
            // Ensure click refreshes the widget instead of opening an activity
            val intent = Intent(context, QuoteWidget::class.java).apply { action = WIDGET_CLICK }
            val pendingIntent = PendingIntent.getBroadcast(
                context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_MUTABLE
            )
            views.setOnClickPendingIntent(R.id.widget_container, pendingIntent)

            views.setOnClickPendingIntent(
                R.id.widget_container,
                pendingIntent
            ) // Ensure tapping anywhere updates quote

            // Update widget
            appWidgetManager.updateAppWidget(appWidgetId, views)
        }
    }

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        for (appWidgetId in appWidgetIds) {
            updateWidget(context, appWidgetManager, appWidgetId)
        }
    }


    override fun onReceive(context: Context, intent: Intent) {
        super.onReceive(context, intent)
        if (intent.action == WIDGET_CLICK) {
            val appWidgetManager = AppWidgetManager.getInstance(context)
            val appWidgetIds = appWidgetManager.getAppWidgetIds(
                ComponentName(context, QuoteWidget::class.java)
            )
            for (appWidgetId in appWidgetIds) {
                updateWidget(context, appWidgetManager, appWidgetId) // Update on tap
            }
        }
    }
}
