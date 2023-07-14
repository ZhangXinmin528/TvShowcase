package com.leanback.leanbackshowcase.app.tabs.tabitem

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.leanback.leanbackshowcase.app.tabs.adapter.LeanbackTabAdapter
import com.leanback.leanbackshowcase.databinding.FragmentSubTabItemBinding

/**
 * Created by zhangxinmin on 2023/7/14.
 */

class LeanbackTabsFragment : Fragment() {

    private lateinit var itemBinding: FragmentSubTabItemBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        itemBinding = FragmentSubTabItemBinding.inflate(inflater, container, false)
        return itemBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tabsList = arrayListOf<String>("热门推荐", "年度好剧", "5.1尊享")
        val fragmentList: MutableList<Fragment> = ArrayList()
        tabsList.forEach {
            fragmentList.add(LeanbackTabItemFragment.newInstance(it))
        }
        val adapter = LeanbackTabAdapter(
            fm = childFragmentManager, tabList = tabsList, fragments = fragmentList
        )
        itemBinding.viewpagerSub.setTouchEnabled(true)
        itemBinding.viewpagerSub.adapter = adapter

        itemBinding.tablayoutSub.setupWithViewPager(itemBinding.viewpagerSub)
    }

    companion object {
        fun newInstance(): LeanbackTabsFragment {
            return LeanbackTabsFragment()
        }
    }
}