package kr.ac.hallym.prac08

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.tabs.TabLayout
import kr.ac.hallym.prac08.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main3)
        val binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().add(R.id.tabContent, OneFragment()).commit()

        val tabLayout = binding.tabs

//        val tab1: TabLayout.Tab = tabLayout.newTab()
//        tab1.text = "Tab1"
//        tabLayout.addTab(tab1)
//
//        val tab2: TabLayout.Tab = tabLayout.newTab()
//        tab2.text = "Tab2"
//        tabLayout.addTab(tab2)
//
//        val tab3: TabLayout.Tab = tabLayout.newTab()
//        tab3.text = "Tab3"
//        tabLayout.addTab(tab3)

        tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val transaction = supportFragmentManager.beginTransaction()
                when(tab?.text){
                    "Tab1" -> transaction.replace(R.id.tabContent, OneFragment())
                    "Tab2" -> transaction.replace(R.id.tabContent, TwoFragment())
                    "Tab3" -> transaction.replace(R.id.tabContent, TreeFragment())
                }
                transaction.commit()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Log.d("kkang", "onTabUnselected...")
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                Log.d("kkang", "onTabUnselected...")
            }
        })


    }
}