package com.android.settings.network.telephony

import android.content.SharedPreferences
import android.content.res.Configuration
import androidx.preference.PreferenceManager
import android.content.Context
import androidx.preference.PreferenceFragmentCompat
//import com.android.settings.core.TogglePreferenceController



class Switch() {
    //: PreferenceFragmentCompat() {
//TogglePreferenceController, Configuration.Provider{
//override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
//    setPreferencesFromResource(R.xml.preferences, rootKey)
//}

    fun setData(appContext: Context, v: Boolean) {
        //val appContext: Context = applicationContext
        val prefs: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(appContext)
        //val v = prefs.setBoolean("mobile_data_enable", v)

        val ed = prefs.edit()
        ed.putBoolean("mobile_data_enable", v)
        ed.commit()
    }
}