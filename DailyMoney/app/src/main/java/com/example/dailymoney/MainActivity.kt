package com.example.dailymoney

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_spend_list.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigation: BottomNavigationView = findViewById(R.id.navigationView)
//        val categoryInput: ArrayList<String> = ArrayList()

        supportFragmentManager.beginTransaction().replace(R.id.frameLayout, home()).commit()

        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.home -> {
                    supportFragmentManager.beginTransaction().replace(R.id.frameLayout, home()).commit()
                }
                R.id.list -> {
                    supportFragmentManager.beginTransaction().replace(R.id.frameLayout, spendList()).commit()
                }
                R.id.user -> {
                    supportFragmentManager.beginTransaction().replace(R.id.frameLayout, user()).commit()
                }
            }

            true
        }

    }

}
