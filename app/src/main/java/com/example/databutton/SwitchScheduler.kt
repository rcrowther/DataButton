package com.example.databutton

import android.app.Application
import android.util.Log
import androidx.work.Constraints
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager

// ViewModle
// https://stackoverflow.com/questions/50307553/android-jobscheduler-setrequiresdeviceidle-job-not-firing

class SwitchScheduler(application: Application) {
    private val workManager: WorkManager = WorkManager.getInstance(application)

    private val constraints = Constraints.Builder()
        .setRequiresDeviceIdle(true)
        //.setRequirementsEnforced(true)
        .build()

    internal fun applyDataSwitch(on: Boolean) {
        val switchWork = OneTimeWorkRequest.Builder(SwitchWorker::class.java)
            .setConstraints(constraints)
            .build()
        val switchWork2 = OneTimeWorkRequest.from(SwitchWorker::class.java)
        Log.i(LOG_TAG, "Databutton SwitchScheduler call")

        //workManager.enqueueUniqueWork("SwitchWorker", ExistingWorkPolicy.KEEP, switchWork)
        workManager.enqueue(switchWork)

        //workManager.enqueue(OneTimeWorkRequest.from(SwitchWorker::class.java))
    }
}