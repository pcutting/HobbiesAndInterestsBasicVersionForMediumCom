package com.philipcutting.hobbiesandinterestsbasic

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.philipcutting.hobbiesandinterestsbasic.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigationMenu.setOnNavigationItemSelectedListener {
            handleBottomNavigation(
                it.itemId
            )
        }
        binding.bottomNavigationMenu.selectedItemId = R.id.menu_bio

    }

    private fun handleBottomNavigation(
        menuItemId: Int
     ): Boolean = when (menuItemId) {
         R.id.menu_bio ->  {
             swapFragments(BioFragment())
             true
         }

        R.id.menu_family -> {
            swapFragments(FamilyFragment())
            true
        }

        R.id.menu_hobbies -> {
            swapFragments(HobbiesFragment())
            true
        }
        else -> false
     }

    private fun swapFragments(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_fragment_container, fragment)
            .commit()
    }
}