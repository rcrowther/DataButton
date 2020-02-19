package com.example.databutton



//import android.provider.Settings

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceFragmentCompat
import androidx.work.Configuration


private const val TAG = "MyBroadcastReceiver"


/*
class MyBroadcastReceiver : BroadcastReceiver() {
    b
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
*/

//https://code.luasoftware.com/tutorials/android/android-settings-preference-using-preferencefragmentcompat/
class MainActivity : AppCompatActivity(), Configuration.Provider {

    fun appContext(): Context {
        return applicationContext
    }

    //class EnableMobileData() {}

    //val enableMobileDataIntent = Intent(this, EnableMobileData::class.java).apply {
       // data = true
    //}
    //startService(downloadIntent)


    override fun getWorkManagerConfiguration() =
    Configuration.Builder()
    .setMinimumLoggingLevel(android.util.Log.DEBUG)
    .build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //        setSupportActionBar(toolbar)
        //val switchScheduler = SwitchScheduler(this.getApplication())



        //makeStatusNotification("Databutton status","Databutton Create call", appContext)
        Log.i(LOG_TAG, "Databutton onCreate call")

        //switchScheduler.applyDataSwitch(true)

       val alarm =  TryAlarmSwitch(appContext())
       alarm.setSwitch(true)

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
