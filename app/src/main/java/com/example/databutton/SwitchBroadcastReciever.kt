package com.example.databutton

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import timber.log.Timber


class SwitchBroadcastReciever () : BroadcastReceiver() {
    //val SLEEP_DELAY_TIME_MILLIS = 500L
    val SLEEP_DELAY_TIME_MILLIS = 20000L

    override fun onReceive(appContext: Context, intent: Intent?) {
        //makeStatusNotification("Reciever Messgae", "onReceive-sleep", appContext)

        val s = Switch()
        s.setData(appContext, true)

        try {
            Thread.sleep(SLEEP_DELAY_TIME_MILLIS, 0)
        } catch (e: InterruptedException) {
            Timber.e(e)
        }

        val isScrrenOn = isScreenOn(appContext)

        //makeStatusNotification("Reciever Messgae", "onReceive-unsleep \n screen on: $isScrrenOn", appContext)
    }
}