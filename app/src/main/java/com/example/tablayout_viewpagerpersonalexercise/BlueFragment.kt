package com.example.tablayout_viewpagerpersonalexercise

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout

class BlueFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blue, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Viewpager
        val tabView: TabLayout = view.findViewById(R.id.tabLayout)
        tabView.addTab(tabView.newTab().setText("Add Blue"))
        tabView.addTab(tabView.newTab().setText("Add Red"))

        val viewP: ViewPager2 = view.findViewById(R.id.viewpager)
        val adapter = MyFragmentAdapter(parentFragmentManager, lifecycle)
        viewP.adapter = adapter

        tabView.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewP.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabReselected(tab: TabLayout.Tab?) {}

        })

        viewP.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                tabView.selectTab(tabView.getTabAt(position))
            }

        })
    }
}
