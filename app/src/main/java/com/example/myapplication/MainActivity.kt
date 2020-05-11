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
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.myapplication.databinding.ActivityMainBinding
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
//        NavigationUI.setupActionBarWithNavController(this, navController)

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
//        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);

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

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when (item.getItemId()) {
//            android.R.id.home -> {
//                finish()
//                return true
//            }
//        }
//        return super.onOptionsItemSelected(item)
//    }
//
//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        return true
//    }

    override fun onSupportNavigateUp(): Boolean {
        findNavController(R.id.nav_host_fragment).navigateUp()
        return true
    }
}