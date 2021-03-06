package org.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import org.example.todolist.adapter.TodoAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabs = findViewById<TabLayout>(R.id.tabs)
        val viewPager = findViewById<ViewPager2>(R.id.viewpager)
        val pagerAdapter = PagerAdapter(this)

        val tabName = listOf("시작 전", "진행 중", "완료")

        viewPager.adapter = pagerAdapter
        TabLayoutMediator(tabs, viewPager) { tab, position ->
            tab.text = "${(tabName[position])}"
        }.attach()
    }

    private inner class PagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int = 3
        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> BeforeFragment()
                1 -> MiddleFragment()
                else -> AfterFragment()
            }
        }
    }
}