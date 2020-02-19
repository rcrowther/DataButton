package com.example.databutton

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import timber.log.Timber


class SwitchBroadcastReciever () : BroadcastReceiver() {
    val SLEEP_DELAY_TIME_MILLIS = 500L

    override fun onReceive(appContext: Context, intent: Intent?) {
        makeStatusNotification("Reciever Messgae", "doWork-sleep", appContext)

        try {
            Thread.sleep(SLEEP_DELAY_TIME_MILLIS, 0)
        } catch (e: InterruptedException) {
            Timber.e(e)
        }

        makeStatusNotification("Reciever Messgae", "doWork-unsleep", appContext)
    }
}