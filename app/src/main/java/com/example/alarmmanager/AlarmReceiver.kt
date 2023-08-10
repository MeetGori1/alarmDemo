package com.example.alarmmanager

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.AudioAttributes
import android.media.RingtoneManager
import android.net.Uri
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class AlarmReceiver : BroadcastReceiver() {
    private var message="water"
    var uniqueId = 123
    private var CHANNEL_ID1 = "id"
    private var CHANNEL_NAME1 = "name"

    override fun onReceive(context: Context?, intent: Intent?) {
         message = intent?.getStringExtra("EXTRA_MESSAGE") ?: return

        println(message)
        if (context != null) {
            createDefaultChannel(context.applicationContext)
            sendNotification(context.applicationContext)
        }

    }

    @SuppressLint("MissingPermission")
    private fun sendNotification(context: Context) {
        val builder1 = NotificationCompat.Builder(context,CHANNEL_ID1).setStyle(
            NotificationCompat.BigTextStyle().setBigContentTitle(message)
                .bigText(message)
        ).setContentTitle(message)
            .setOnlyAlertOnce(true)
            .setContentText(message)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setAutoCancel(true)
        NotificationManagerCompat.from(context).notify(uniqueId, builder1.build())
    }

    private fun createDefaultChannel(context: Context) {

        val sound: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)

        val attributes: AudioAttributes = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_NOTIFICATION)
            .build()

        val channel = NotificationChannel(
            CHANNEL_ID1,
            CHANNEL_NAME1,
            NotificationManager.IMPORTANCE_HIGH
        )
        channel.setSound(sound, attributes)
        NotificationManagerCompat.from(context).createNotificationChannel(channel)
    }
}