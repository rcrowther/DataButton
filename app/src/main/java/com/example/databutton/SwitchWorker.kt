package com.example.databutton

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import timber.log.Timber

class SwitchWorker(ctx: Context, params: WorkerParameters)
    : Worker(ctx, params) {

    override fun doWork(): Result {
        val appContext = applicationContext
        val DELAY_TIME_MILLIS = 500L

        makeStatusNotification("Worker Messgae", "doWork-sleep", appContext)

        try {
            Thread.sleep(DELAY_TIME_MILLIS, 0)
        } catch (e: InterruptedException) {
            Timber.e(e)
        }

        makeStatusNotification("Worker Messgae", "doWork-unsleep", appContext)

        return Result.success()
        //Timber.e(throwable)
        //return Result.failure()
    }
}