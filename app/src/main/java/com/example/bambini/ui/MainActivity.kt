package com.example.bambinifashion.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.bambini.R
import com.example.bambini.databinding.ActivityMainBinding
import com.example.bambini.home.HomeFragment

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val homeFragment = HomeFragment()
        val bagFragment = BagFragment()
        val designersFragment = DesignersFragment()
        val menuFragment = MenuFragment()
        val searchFragment = SearchFragment()

        val bottomNavigationView = binding.bottomNav
        replaceFragment(menuFragment)

        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.homeFragment -> replaceFragment(homeFragment)
                R.id.menuFragment -> replaceFragment(menuFragment)
                R.id.bagFragment -> replaceFragment(bagFragment)
                R.id.designerFragment -> replaceFragment(designersFragment)
                R.id.searchFragment -> replaceFragment(searchFragment)
            }
            true
        }
        bottomNavigationView.selectedItemId = R.id.homeFragment
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }
}