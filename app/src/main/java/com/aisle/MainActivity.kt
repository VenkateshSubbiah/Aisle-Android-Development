package com.aisle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.NavHostFragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.aisle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        binding.viewpager.isUserInputEnabled = false    // Disable swiping left/right.
        binding.viewpager.adapter = CustomViewPagerAdapter(supportFragmentManager, lifecycle)
        binding.navView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_discover -> binding.viewpager.setCurrentItem(0, false)
                R.id.nav_notes -> binding.viewpager.setCurrentItem(1, false)
                R.id.nav_matches -> binding.viewpager.setCurrentItem(2, false)
                R.id.nav_profile -> binding.viewpager.setCurrentItem(3, false)
            }
            true
        }
        binding.navView.selectedItemId = R.id.nav_notes
    }

    private class CustomViewPagerAdapter(fm: FragmentManager, lifeCycle: Lifecycle) :
        FragmentStateAdapter(fm, lifeCycle) {
        companion object {
            const val NUM_PAGES = 4
        }

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> NavHostFragment.create(R.navigation.discover_nav)
                1 -> NavHostFragment.create(R.navigation.notes_nav)
                2 -> NavHostFragment.create(R.navigation.matches_nav)
                3 -> NavHostFragment.create(R.navigation.profile_nav)
                else -> NavHostFragment.create(R.navigation.discover_nav)
            }
        }

        override fun getItemCount(): Int {
            return NUM_PAGES
        }
    }
}