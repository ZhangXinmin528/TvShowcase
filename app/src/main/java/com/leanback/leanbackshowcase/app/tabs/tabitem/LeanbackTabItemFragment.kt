package com.leanback.leanbackshowcase.app.tabs.tabitem

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.leanback.leanbackshowcase.databinding.FragmentTabItemExampleBinding

/**
 * Created by zhangxinmin on 2023/7/13.
 */

class LeanbackTabItemFragment : Fragment() {
    private lateinit var tabItemBinding: FragmentTabItemExampleBinding
    private var mTitle: String? = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tabItemBinding = FragmentTabItemExampleBinding.inflate(inflater, container, false)
        return tabItemBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initParams()
    }

    private fun initParams() {
        mTitle = arguments?.getString(PARAMS_TITLE, "")
        mTitle?.let {
            tabItemBinding.tvTitle.text = it
        }
    }

    companion object {
        private const val PARAMS_TITLE = "params_title"

        fun newInstance(title: String): LeanbackTabItemFragment {
            val fragment = LeanbackTabItemFragment()
            val args = Bundle()
            args.putString(PARAMS_TITLE, title)
            fragment.arguments = args
            return fragment
        }
    }
}