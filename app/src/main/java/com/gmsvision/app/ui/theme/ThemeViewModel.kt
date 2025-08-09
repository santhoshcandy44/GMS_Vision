package com.gmsvision.app.ui.theme

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.widget.Toast
import androidx.core.content.edit
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.application
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed class ThemeMode {
    data object SystemDefault : ThemeMode()
    data object Dark : ThemeMode()
    data object Light : ThemeMode()
}

class ThemeViewModel(application: Application) : AndroidViewModel(application) {

    private val sharedPreferences =
        application.applicationContext.getSharedPreferences("theme_prefs", Context.MODE_PRIVATE)

    private val _themeFlow = MutableStateFlow(getThemeMode())
    val themeFlow = _themeFlow.asStateFlow()

    private val prefListener = SharedPreferences.OnSharedPreferenceChangeListener { prefs, key ->
        if (key == "theme_mode") {
            _themeFlow.value = prefs.getInt("theme_mode", -1)
        }
    }

    init {
        sharedPreferences.registerOnSharedPreferenceChangeListener(prefListener)
    }

    fun getThemeMode(): Int {
        return sharedPreferences.getInt("theme_mode", -1)
    }

    fun setThemeMode(mode: ThemeMode) {
        val modeInt = when (mode) {
            is ThemeMode.Dark -> 1
            is ThemeMode.Light -> 0
            is ThemeMode.SystemDefault -> -1
        }
        sharedPreferences.edit { putInt("theme_mode", modeInt) }
    }

    override fun onCleared() {
        super.onCleared()
        sharedPreferences.unregisterOnSharedPreferenceChangeListener(prefListener)
    }
}

