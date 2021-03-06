package com.example.databutton

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.hardware.display.DisplayManager
import android.os.Build
import android.os.PowerManager
import android.view.Display
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat


/**
 * Create a Notification that is shown as a heads-up notification if possible.
 *
 * For this codelab, this is used to show a notification so that you know when different steps
 * of the background work chain are starting
 *
 * @param message Message shown on the notification
 * @param context Context needed to create Toast
 */
fun makeStatusNotification(title: CharSequence, message: String, context: Context) {

    // Make a channel if necessaryb
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        val name = VERBOSE_NOTIFICATION_CHANNEL_NAME
        val description = VERBOSE_NOTIFICATION_CHANNEL_DESCRIPTION
        //val importance = NotificationManager.IMPORTANCE_HIGH
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel(CHANNEL_ID, name, importance)
        channel.description = description

        // Add the channel
        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager?

        notificationManager?.createNotificationChannel(channel)
    }

    // Create the notification
    val builder = NotificationCompat.Builder(context, CHANNEL_ID)
        .setSmallIcon(R.drawable.ic_notification)
        .setContentTitle(title)
        .setContentText(message)
        .setPriority(NotificationCompat.PRIORITY_HIGH)
        .setVibrate(LongArray(0))

    // Show the notification
    NotificationManagerCompat.from(context).notify(NOTIFICATION_ID, builder.build())
}

//https://stackoverflow.com/questions/60216558/detect-always-on-display-when-trying-to-determine-if-the-screen-is-off/60218008#60218008
fun isScreenOn(appContext: Context): Boolean {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
        val dm =
            appContext.getSystemService(Context.DISPLAY_SERVICE) as DisplayManager?
        for (display in dm!!.displays) {
            if (display.state == Display.STATE_ON) {
                return true
            }
        }
        false
    } else {
        val pm =
            appContext.getSystemService(Context.POWER_SERVICE) as PowerManager?
        pm!!.isInteractive
    }
}