package com.example.myfirstapp

import android.content.Context
import android.os.Bundle
import androidx.preference.*

class SettingsFragment : PreferenceFragmentCompat() {
    //val KHPreference: SwitchPreferenceCompat? = findPreference("keep_heroes")

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences, rootKey)
        val KHPreference = findPreference<SwitchPreferenceCompat>("keep_heroes")
        val BTPreference = findPreference<SwitchPreferenceCompat>("balance_team")
        val PNPreference = findPreference<ListPreference>("player_num")

        KHPreference?.onPreferenceChangeListener =
            Preference.OnPreferenceChangeListener { preference, newValue: Any -> // Set the shared preference when the preference is changed
                //val sharedPreferences = preferenceManager.sharedPreferences
                val sharedPreferences = context?.getSharedPreferences( "settings", Context.MODE_PRIVATE)
                val editor = sharedPreferences?.edit()
                if (editor != null) {
                    editor.putBoolean(preference.key, newValue as Boolean)
                    editor.apply()
                }
                true
            }

        BTPreference?.onPreferenceChangeListener =
            Preference.OnPreferenceChangeListener { preference, newValue -> // Set the shared preference when the preference is changed
                val sharedPreferences = context?.getSharedPreferences( "settings", Context.MODE_PRIVATE)
                val editor = sharedPreferences?.edit()
                if (editor != null) {
                    editor.putBoolean(preference.key, newValue as Boolean)
                    editor.apply()
                }
                true
            }

        PNPreference?.onPreferenceChangeListener =
            Preference.OnPreferenceChangeListener { preference, newValue -> // Set the shared preference when the preference is changed
                val sharedPreferences = context?.getSharedPreferences( "settings", Context.MODE_PRIVATE)
                val editor = sharedPreferences?.edit()
                if (editor != null) {
                    editor.putString(preference.key, newValue as String)
                    editor.apply()
                }
                true
            }
    }



}