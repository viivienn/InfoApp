package com.example.myapplication

import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.myapplication.databinding.ActivityMainBinding
import hotchemi.android.rate.AppRate
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var container : ConstraintLayout
    private lateinit var languageState: LanguageState
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        languageState = LanguageState.instance
        loadLocate()
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        container = binding.container
        val navController = this.findNavController(R.id.nav_host_fragment)
//        NavigationUI.setupActionBarWithNavController(this, navController)
        NavigationUI.setupWithNavController(binding.navView, navController)
//        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);

        AppRate.with(this)
            .setInstallDays(5)
            .setLaunchTimes(3)
            .setRemindInterval(2)
            .monitor();

        AppRate.showRateDialogIfMeetsConditions(this)
    }

    fun showChangeLang() {
        var option =  languageState.getOption()
        val listItmes = arrayOf("English", "Francais")
        val mBuilder = AlertDialog.Builder(this@MainActivity)
        mBuilder.setTitle("Choose Language")
        mBuilder.setSingleChoiceItems(listItmes, option) { dialog, which ->
            if (which == 1) {
                setLocate("fr")
                languageState.setLang("fr")
                recreate()
            } else if (which == 0) {
                setLocate("en")
                languageState.setLang("en")
                recreate()
            }
            dialog.dismiss()
        }
        val mDialog = mBuilder.create()
        mDialog.show()
    }

    private fun setLocate(Lang: String) {
        val locale = Locale(Lang)
        Locale.setDefault(locale)
        val config = Configuration()
        config.locale = locale
        baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)
        val editor = getSharedPreferences("Settings", Context.MODE_PRIVATE).edit()
        editor.putString("My_Lang", Lang)
        editor.apply()
    }

    private fun loadLocate() {
        val sharedPreferences = getSharedPreferences("Settings", Activity.MODE_PRIVATE)
        val language = sharedPreferences.getString("My_Lang", "")

        if (language != null) {
            setLocate(language)
            languageState.setLang(language)
        }
        else{
            languageState.setLang(Locale.getDefault().getLanguage())
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        findNavController(R.id.nav_host_fragment).navigateUp()
        return true
    }
}