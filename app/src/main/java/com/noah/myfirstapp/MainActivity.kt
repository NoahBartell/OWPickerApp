package com.noah.myfirstapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.SharedPreferences.OnSharedPreferenceChangeListener
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.myfirstapp.R
import com.example.myfirstapp.databinding.ActivityMainBinding
import com.noah.stuff.Classes.*
import com.noah.stuff.Classes.CharList

class MainActivity : AppCompatActivity(), OnSharedPreferenceChangeListener {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    //var sharedPreferences = getSharedPreferences( "Settings", Context.MODE_PRIVATE)
    lateinit var sharedPreferences: SharedPreferences

    companion object{
        var MyCharList: CharList = CharList()
    }

    //val keepHeroes = sharedPreferences.getBoolean("keep_heroes", false)

    //val balancedTeam = sharedPreferences.getBoolean("balance_team", false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Gets and sets preferences
        sharedPreferences = getSharedPreferences( "settings", Context.MODE_PRIVATE)
        sharedPreferences.registerOnSharedPreferenceChangeListener(this)
        MyCharList.setBalanced(sharedPreferences.getBoolean("balance_team", false))
        MyCharList.times = getNum(sharedPreferences.getString("player_num", ""))
        MyCharList.setKeepHeroes(sharedPreferences.getBoolean("keep_heroes", false))
        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

//        val fragmentTransaction = supportFragmentManager.beginTransaction()
//        fragmentTransaction.replace(R.id.FirstFragment, )
//        fragmentTransaction.commit()
        //binding.fab.setOnClickListener { view ->
         //   Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
         //           .setAction("Action", null).show()
        //}
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return when (item.itemId) {
            R.id.action_settings -> {
                val intent = Intent(this, SettingsActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

//    fun OnSharedPreferenceChangeListener(SP: SharedPreferences, key: String){
//        if(key == "balanced_team") {
//            MyCharList.setBalanced(SP.getBoolean(key, false))
//        }
//        if(key == "keep_heroes") {
//            MyCharList.setKeepHeroes(SP.getBoolean(key, false))
//        }
//    }

    override fun onSharedPreferenceChanged(p0: SharedPreferences?, p1: String?) {
        if(p1 == "balanced_team") {
            if (p0 != null) {
                MyCharList.setBalanced(p0.getBoolean(p1, false))
            }
        }
        if(p1 == "keep_heroes") {
            if (p0 != null) {
                MyCharList.setKeepHeroes(p0.getBoolean(p1, false))
            }
        }

        if(p1 == "player_num") {
            if (p0 != null) {
                MyCharList.times = getNum(p0.getString(p1, ""))
            }
        }
    }

    private fun getNum(a: String?): Int{
        return when (a){
            "1" -> 1
            "2" -> 2
            "3" -> 3
            "4" -> 4
            "5" -> 5
            else -> 0
        }
    }


}