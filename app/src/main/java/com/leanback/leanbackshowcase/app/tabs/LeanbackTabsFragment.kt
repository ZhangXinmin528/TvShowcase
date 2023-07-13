package com.leanback.leanbackshowcase.app.tabs

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.leanback.leanbackshowcase.databinding.FragmentTabsExampleBinding

/**
 * Created by zhangxinmin on 2023/7/13.
 */

class LeanbackTabsFragment : Fragment() {

    private lateinit var tabsBinding: FragmentTabsExampleBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tabsBinding = FragmentTabsExampleBinding.inflate(inflater, container, false)
        return tabsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tabsList = arrayListOf<String>("我的", "电视剧", "电影", "综艺")
        val fragmentList: MutableList<Fragment> = ArrayList()
        tabsList.forEach {
            fragmentList.add(LeanbackTabItemFragment.newInstance(it))
        }
        val adapter =
            LeanbackTabAdapter(
                fm = childFragmentManager,
                tabList = tabsList,
                fragments = fragmentList
            )

        tabsBinding.viewpager.adapter = adapter

        tabsBinding.tablayout.setupWithViewPager(tabsBinding.viewpager)
    }


}