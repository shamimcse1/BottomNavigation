package com.codercamp.bottomnavigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentHome = HomeFragment()
        val fragmentMessage = MessageFragment()
        val fragmentProfile = ProfileFragment()

        setCurrentFragment(fragmentHome)
        bottomNavigationView = findViewById(R.id.bottomNavView)
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    setCurrentFragment(fragmentHome)
                }
                R.id.message -> {
                    setCurrentFragment(fragmentMessage)
                }
                R.id.profile -> {
                    setCurrentFragment(fragmentProfile)
                }
            }
            true
        }



    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainer, fragment)
            commit()
        }
}