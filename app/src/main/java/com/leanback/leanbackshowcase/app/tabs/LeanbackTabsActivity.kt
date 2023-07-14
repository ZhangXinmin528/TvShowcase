package com.leanback.leanbackshowcase.app.tabs

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.leanback.leanbackshowcase.R

/**
 * Created by zhangxinmin on 2023/7/13.
 */

class LeanbackTabsActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabs_example)

        supportFragmentManager.beginTransaction()
            .replace(R.id.tabs_container, LeanbackNavigationFragment.newInstance()).commit()
    }
}