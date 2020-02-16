package com.example.databutton


import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.widget.Toast
import androidx.preference.PreferenceFragmentCompat
import androidx.work.*
private const val TAG = "MyBroadcastReceiver"


class UploadWorker(appContext: Context, workerParams: WorkerParameters)
    : Worker(appContext, workerParams) {

    override fun doWork(): Result {
        // Do the work here--in this case, upload the images.

        //uploadImages()

        // Indicate whether the task finished successfully with the Result
        return Result.success()
    }
}

class MyBroadcastReceiver : BroadcastReceiver() {


    override fun onReceive(context: Context, intent: Intent) {
        StringBuilder().apply {
            append("Action: ${intent.action}\n")
            append("URI: ${intent.toUri(Intent.URI_INTENT_SCHEME)}\n")
            toString().also { log ->
                Log.d(TAG, log)
                Toast.makeText(context, log, Toast.LENGTH_LONG).show()
            }
        }
    }
}

//https://code.luasoftware.com/tutorials/android/android-settings-preference-using-preferencefragmentcompat/
class MainActivity : AppCompatActivity() {

    //class EnableMobileData() {}

    //val enableMobileDataIntent = Intent(this, EnableMobileData::class.java).apply {
       // data = true
    //}
    //startService(downloadIntent)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //        setSupportActionBar(toolbar)
        val appContext = applicationContext

        makeStatusNotification("Databutton status","Databutton On", appContext)

        //val uploadWorkRequest = OneTimeWorkRequest.Builder<UploadWorker>()
        //    .build()
//LOOOK for notification in the downloaded test file
        //val uploadWorkRequest = OneTimeWorkRequest.Builder(UploadWorker.class)

       // WorkManager.getInstance(this).enqueue(uploadWorkRequest)

        //with(NotificationManagerCompat.from(this)) {
            // notificationId is a unique int for each notification that you must define
         //   notify(4, builder.build())
        //}

        //https://developer.android.com/reference/androidx/preference/PreferenceFragmentCompat

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_content, DataButtonFragment())
            .commit()

    }

    class DataButtonFragment : PreferenceFragmentCompat() {
        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.data_button, rootKey)
        }
    }
}
