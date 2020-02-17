package com.example.databutton

import android.app.Application
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager

// ViewModle
class SwitchScheduler(application: Application) {
    private val workManager: WorkManager = WorkManager.getInstance(application)

    internal fun applyDataSwitch(on: Boolean) {
        workManager.enqueue(OneTimeWorkRequest.from(SwitchWorker::class.java))
    }
}