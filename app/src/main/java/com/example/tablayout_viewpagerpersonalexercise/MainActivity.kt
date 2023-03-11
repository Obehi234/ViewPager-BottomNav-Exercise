package com.example.tablayout_viewpagerpersonalexercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.tablayout_viewpagerpersonalexercise.navFragments.ProfileFragment
import com.example.tablayout_viewpagerpersonalexercise.navFragments.RecommendFragment
import com.example.tablayout_viewpagerpersonalexercise.navFragments.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    val navView : BottomNavigationView = findViewById(R.id.bottom_nav)
        navView.setOnItemSelectedListener  (navListener )
        loadFragments(BlueFragment())
    }

    private val navListener = NavigationBarView.OnItemSelectedListener { item ->
        val fragment: Fragment = when (item.itemId) {
            R.id.home -> BlueFragment()
            R.id.profile -> ProfileFragment()
            R.id.settings -> SettingsFragment()
            R.id.recommend -> RecommendFragment()
            else -> BlueFragment()

        }
        loadFragments(fragment)
        true
    }

    private fun loadFragments(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_host, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}