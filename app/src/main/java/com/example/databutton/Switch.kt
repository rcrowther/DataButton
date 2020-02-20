//package com.android.settings.network.telephony
package com.example.databutton

//import com.android.settings.core.TogglePreferenceController
import android.content.Context
import android.content.SharedPreferences
import android.telephony.TelephonyManager
import android.widget.Toast
import androidx.preference.PreferenceManager
//import com.android.settingslib.net.DataUsageController


class Switch() {
    //: PreferenceFragmentCompat() {
//TogglePreferenceController, Configuration.Provider{
//override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
//    setPreferencesFromResource(R.xml.preferences, rootKey)
//}
    //val du = DataUsageController.setMobileDataEnabled(boolean enabled)

    fun setData(appContext: Context, v: Boolean) {
        //val appContext: Context = applicationContext
       // val prefs: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(appContext)
        //val v = prefs.setBoolean("mobile_data_enable", v)
       // val ctx = applicationContext
       // val ed = prefs.edit()
       // ed.putBoolean("mobile_data_enable", v)
       // ed.commit()



        val tm: TelephonyManager = appContext.getSystemService(
            Context.TELEPHONY_SERVICE
        ) as TelephonyManager
        //TelephonyManager::class)
        val isRoaming = tm.isNetworkRoaming
        // Cant be enabled
        tm.setDataEnabled(false)
        //val text = "Roaming: $isRoaming"
        //val duration = Toast.LENGTH_SHORT
        //val toast = Toast.makeText(appContext, text, duration)
        //toast.show()
        makeStatusNotification("Switch Messgae", "setData isRoaming:$isRoaming", appContext)

    }
}