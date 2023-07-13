package com.leanback.leanbackshowcase.app.tabs

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

/**
 * Created by zhangxinmin on 2023/7/13.
 */

class LeanbackTabAdapter(
    fm: FragmentManager,
    private val tabList: MutableList<String>,
    private val fragments: MutableList<Fragment>
) :
    FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return tabList[position]
    }
}