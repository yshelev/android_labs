package com.example.second_lab

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class VPAdapter(fm: Fragment) : FragmentStateAdapter(fm)  {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TaskListFragment.newInstance(showOnlyMyActivities = true)
            1 -> TaskListFragment.newInstance(showOnlyMyActivities = false)
            else -> throw IllegalArgumentException("Invalid position")
        }
    }
}