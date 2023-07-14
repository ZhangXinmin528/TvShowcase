package com.leanback.leanbackshowcase.app.tabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.leanback.leanbackshowcase.app.tabs.adapter.LeanbackTabAdapter
import com.leanback.leanbackshowcase.app.tabs.tabitem.LeanbackTabsFragment
import com.leanback.leanbackshowcase.databinding.FragmentNavigationExampleBinding

/**
 * Created by zhangxinmin on 2023/7/13.
 */

class LeanbackNavigationFragment : Fragment() {

    private lateinit var tabsBinding: FragmentNavigationExampleBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        tabsBinding = FragmentNavigationExampleBinding.inflate(inflater, container, false)
        return tabsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tabsList = arrayListOf<String>("电视剧", "电影", "综艺", "少儿")
        val fragmentList: MutableList<Fragment> = ArrayList()
        tabsList.forEach {
            fragmentList.add(LeanbackTabsFragment.newInstance())
        }
        val adapter = LeanbackTabAdapter(
            fm = childFragmentManager, tabList = tabsList, fragments = fragmentList
        )
        tabsBinding.viewpager.setTouchEnabled(true)
        tabsBinding.viewpager.adapter = adapter

        tabsBinding.tablayout.setupWithViewPager(tabsBinding.viewpager)

        tabsBinding.tablayout.setOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
//                val tabView = layoutInflater.inflate(R.layout.layout_tab_item, null)
//                tabView.findViewById<TextView>(R.id.tv_tab_name).text = tab?.text ?: ""
//                tab?.customView = tabView
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })
    }


    companion object {
        fun newInstance(): LeanbackNavigationFragment {
            return LeanbackNavigationFragment()
        }
    }
}