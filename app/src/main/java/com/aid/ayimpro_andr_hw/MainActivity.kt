package com.aid.ayimpro_andr_hw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.navigation.NavigationView
import java.lang.Exception


class MainActivity : AppCompatActivity() {
    lateinit var drawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawer: DrawerLayout = findViewById(R.id.drawer_layout)
        val navDrawer: NavigationView = findViewById(R.id.nav_view)
        drawerToggle =
            ActionBarDrawerToggle(this, drawer, R.string.nav_open, R.string.nav_close)
        drawer.addDrawerListener(drawerToggle)
        drawerToggle.syncState()


        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navDrawer.setNavigationItemSelectedListener{

            when (it.itemId) {
                R.id.nav_account -> supportFragmentManager.beginTransaction()
                    .replace(R.id.frg_cont, AccountFragment())
                    .commit()

                R.id.nav_company -> supportFragmentManager.beginTransaction()
                    .replace(R.id.frg_cont, CompanyFragment())
                    .commit()

                R.id.nav_settings -> supportFragmentManager.beginTransaction()
                    .replace(R.id.frg_cont, SettingsFragment())
                    .commit()

                R.id.nav_logout -> supportFragmentManager.beginTransaction()
                    .replace(R.id.frg_cont, LogoutFragment())
                    .commit()
            }
            drawerToggle.syncState()
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
