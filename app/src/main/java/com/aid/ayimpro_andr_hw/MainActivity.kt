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
    var drawer: DrawerLayout? = null
    var navDrawer: NavigationView? = null
    var drawerToggle: ActionBarDrawerToggle? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawer = findViewById(R.id.drawer_layout)
        navDrawer = findViewById(R.id.nav_view)
        setupDrawerContent(navDrawer)

        drawerToggle =
            ActionBarDrawerToggle(this, drawer, R.string.nav_open, R.string.nav_close)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                drawer!!.openDrawer(GravityCompat.START)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupDrawerContent(navDrawer: NavigationView) {
        navDrawer.setNavigationItemSelectedListener { menuItem ->
            selectDrawerItem(menuItem)
            true
        }
    }

    private fun selectDrawerItem(menuItem: MenuItem) {
        var fragment: Fragment? = null
        val fragmentClass: Class<*> =
            when (menuItem.itemId) {
                R.id.nav_account -> AccountFragment::class.java
                R.id.nav_company -> CompanyFragment::class.java
                R.id.nav_settings -> SettingsFragment::class.java
                R.id.nav_logout -> LogoutFragment::class.java
                else -> AccountFragment::class.java
            }
        try {
            fragment = fragmentClass.newInstance() as Fragment
        } catch (e: Exception) {
            e.printStackTrace()
        }
        val fragmentManager: FragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().replace(R.id.frg_cont, fragment).commit()

        menuItem.setChecked(true)
        setTitle(menuItem.getTitle())
        drawer!!.closeDrawers()
    }
}
