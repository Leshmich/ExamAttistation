package com.michael.examattistation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
private const val Last_Selected_Item="item"
private val About_fragment=AboutFragment().javaClass.name
private val Toss_coin_fragment=TossCoinFragment().javaClass.name
class MainActivity : AppCompatActivity() {
    lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnItemReselectedListener { item ->
            var fragment: Fragment? = null
            when (item.itemId) {

                R.id.About -> {
                    fragment = AboutFragment()
                }
                R.id.car -> {
                    fragment = CarFragment()
                }

                R.id.coin_roll -> {
                    fragment = TossCoinFragment()
                }
            }
            replaceFragment(fragment!!)
        }
bottomNavigationView.selectedItemId=if (savedInstanceState!=null) savedInstanceState.getInt(
    Last_Selected_Item) else R.id.coin_roll
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(Last_Selected_Item, bottomNavigationView.selectedItemId)

        val currencyFragment=supportFragmentManager.fragments.last()
        supportFragmentManager.putFragment(outState, currencyFragment.javaClass.name,currencyFragment)
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}