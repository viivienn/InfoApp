package com.example.myapplication

import android.app.Activity
import android.content.ClipData
import android.content.Context
import android.content.res.Configuration
import android.graphics.drawable.DrawableContainer
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.ActionBarContainer
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.myapplication.data.AppDatabase
import com.example.myapplication.data.ChapterDao
import com.example.myapplication.data.ChapterRepository
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.utilities.InjectorUtils
import kotlinx.android.synthetic.*
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
//
        NavigationUI.setupWithNavController(binding.navView, navController)
//        val navView: BottomNavigationView = findViewById(R.id.nav_view)
//        val navController = this.findNavController(R.id.nav_host_fragment)
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
//        val appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_settings, R.id.language_item
//            )
//        )
//
//
//        setupActionBarWithNavController(navController, appBarConfiguration)
//        navView.setupWithNavController(navController)

//        navView.setOnNavigationItemSelectedListener {item ->
//                    item.isChecked = true
//                    when(item.itemId){
//                        R.id.language_item -> showChangeLang()
//
//                    }
//            true
//                }

    }


    public fun showChangeLang() {
        var option =  languageState.getOption()
//        var option = -1
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
        languageState.setLang(Locale.getDefault().getLanguage())
        if (language != null) {
            setLocate(language)
        }
    }

}