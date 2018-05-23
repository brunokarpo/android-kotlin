package com.example.bruno.mychatapp.adapters

import android.support.v4.app.FragmentManager
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import com.example.bruno.mychatapp.fragments.ChatsFragment
import com.example.bruno.mychatapp.fragments.UsersFragment

class SectionPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        when( position ) {
            0 -> {
                return UsersFragment()
            }
            1 -> {
                return ChatsFragment()
            }
            else -> {
                return null!!
            }
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> return "Users"
            1 -> return "Chats"
            else -> return null!!
        }
    }

}