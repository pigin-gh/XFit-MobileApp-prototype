package com.pigin.xfitmobileapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView
import com.pigin.xfitmobileapp.fragments.*
import kotlinx.android.synthetic.main.activity_home_screen.*

class HomeScreen : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)
        setSupportActionBar(findViewById(R.id.toolbar))
        init()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.help_option -> finish()
            R.id.call_option -> finish()
            R.id.exit_option -> finish()
        }
        return true
    }


    private fun init() {
        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navigationView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_the_club ->{
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_place, AboutClubFr.newInstance())
                    .commit()
            }

            R.id.rates ->{
                Toast.makeText(this, "Rates", Toast.LENGTH_LONG).show()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_place, RatesFr.newInstance())
                    .commit()
            }

            R.id.media ->{
                Toast.makeText(this, "Media", Toast.LENGTH_LONG).show()
                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_place, MediaFr.newInstance())
                        .commit()
            }

            R.id.contacts ->{
                Toast.makeText(this, "Contacts", Toast.LENGTH_LONG).show()
                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_place, ContactsFr.newInstance())
                        .commit()
            }

            R.id.fitness_counters ->{
                Toast.makeText(this, "Fitness counters", Toast.LENGTH_LONG).show()
                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_place, FitnessCountersFr.newInstance())
                        .commit()
            }

            R.id.my_profile ->{
                Toast.makeText(this, "My profile", Toast.LENGTH_LONG).show()
                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_place, MyProfileFr.newInstance())
                        .commit()
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}