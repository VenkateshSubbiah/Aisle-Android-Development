package com.aisle.helpers

import android.content.Context
import android.content.SharedPreferences
import com.aisle.Constants

object SharedPrefHelper {
    fun fetchToken(context: Context): String? {
        val sharedPref: SharedPreferences = context.getSharedPreferences(
            Constants.SHARED_PREF,
            Context.MODE_PRIVATE
        )
        return sharedPref.getString(Constants.PREF_KEY_TOKEN, null)
    }

    fun saveToken(context: Context, token: String?) {
        val sharedPref: SharedPreferences = context.getSharedPreferences(
            Constants.SHARED_PREF,
            Context.MODE_PRIVATE
        ) // TODO: Encrypt this.
        val editor = sharedPref.edit()
        editor.putString(Constants.PREF_KEY_TOKEN, token)
        editor.apply()
    }
}