package com.example.databutton

//import androidx.core.app.AlarmManagerCompat.setAndAllowWhileIdle

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.util.Log

class TryAlarmSwitch (ctx: Context) {
    //val alarmManager = AlarmManager
    val DELAY_TIME_MILLIS = 500L
    val intent: Intent = Intent(ctx, SwitchBroadcastReciever::class.java)
    val alarmManager : AlarmManager = ctx.getSystemService(
        Context.ALARM_SERVICE
    ) as AlarmManager

    private val pendingIntent = PendingIntent.getBroadcast(
        ctx.getApplicationContext(),
        234324243,
        intent, 0
    )

    fun setSwitch(on: Boolean)   {
        Log.i(LOG_TAG, "Databutton setSwitch call")

        alarmManager.setAndAllowWhileIdle(
            AlarmManager.ELAPSED_REALTIME_WAKEUP,
            //System.currentTimeMillis()
            DELAY_TIME_MILLIS,
            pendingIntent
        )
    }


}