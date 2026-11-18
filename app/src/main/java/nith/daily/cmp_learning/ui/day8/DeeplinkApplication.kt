package nith.daily.cmp_learning.ui.day8

import android.R.attr.data
import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.TaskStackBuilder
import androidx.core.content.getSystemService
import androidx.core.net.toUri
import nith.daily.cmp_learning.MainActivity
import nith.daily.cmp_learning.R

class DeeplinkApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
        showNotification()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel(){
        val channel = NotificationChannel("channel_id",
            "channel_name",
            NotificationManager.IMPORTANCE_DEFAULT
            )

        val notificationManager = getSystemService<NotificationManager>()!!
        notificationManager.createNotificationChannel(channel)
    }

    private fun showNotification(){
        val activityIntent = Intent(this, MainActivity::class.java).apply {
            data = "https://pl-coding.com/50".toUri()
        }
        val paddingIntent = TaskStackBuilder.create(this).run {
            addNextIntentWithParentStack(activityIntent)
            getPendingIntent(0, PendingIntent.FLAG_IMMUTABLE)
        }
        val notificationMessage = NotificationCompat.Builder(this, "channel_id")
            .setSmallIcon(R.drawable.drafts_icon)
            .setContentTitle("App Launched!")
            .setContentText("Tap to open the app")
            .setPriority(NotificationCompat.PRIORITY_MAX)
            .setAutoCancel(true)
            .setContentIntent(paddingIntent)
            .build()
        val notificationManager = getSystemService<NotificationManager>()!!
        notificationManager.notify(1, notificationMessage)
    }
}