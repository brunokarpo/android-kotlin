package com.example.bruno.devportfolio.controller

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.bruno.devportfolio.R
import com.example.bruno.devportfolio.view.AboutFragment
import com.example.bruno.devportfolio.view.ContactFragment
import com.example.bruno.devportfolio.view.SkillsFragment
import com.example.bruno.devportfolio.view.WorkFragment

class DevPagerAdapter(
        var context: Context,
        fragmentManager: FragmentManager
    ): FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment? {
        var fragment: Fragment? = null
        when(position) {
            0 -> fragment = AboutFragment()
            1 -> fragment = WorkFragment()
            2 -> fragment = SkillsFragment()
            3 -> fragment = ContactFragment()
        }
        return fragment
    }

    override fun getCount(): Int {
        return 4
    }

    override fun getPageTitle(position: Int): CharSequence? {
        var fragmentName: String? = null
        when(position) {
            0 -> fragmentName = context.getString(R.string.about)
            1 -> fragmentName = context.getString(R.string.work)
            2 -> fragmentName = context.getString(R.string.skills)
            3 -> fragmentName = context.getString(R.string.contact)
        }
        return fragmentName
    }

}