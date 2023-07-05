/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.leanback.leanbackshowcase.app

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityOptionsCompat
import androidx.leanback.app.BrowseSupportFragment
import com.leanback.leanbackshowcase.app.cards.CardExampleActivity
import com.leanback.leanbackshowcase.app.details.DetailViewExampleActivity
import com.leanback.leanbackshowcase.app.details.DetailViewExampleWithVideoBackgroundActivity
import com.leanback.leanbackshowcase.app.dialog.DialogExampleActivity
import com.leanback.leanbackshowcase.app.grid.GridExampleActivity
import com.leanback.leanbackshowcase.app.grid.VideoGridExampleActivity
import com.leanback.leanbackshowcase.app.media.MusicExampleActivity
import com.leanback.leanbackshowcase.app.media.VideoExampleActivity
import com.leanback.leanbackshowcase.app.media.VideoExampleWithExoPlayerActivity
import com.leanback.leanbackshowcase.app.page.PageAndListRowActivity
import com.leanback.leanbackshowcase.app.room.controller.overview.LiveDataRowsActivity
import com.leanback.leanbackshowcase.app.rows.DynamicVideoRowsActivity
import com.leanback.leanbackshowcase.app.settings.SettingsExampleActivity
import com.leanback.leanbackshowcase.app.wizard.WizardExampleActivity
import com.leanback.leanbackshowcase.cards.presenters.CardPresenterSelector
import com.leanback.leanbackshowcase.models.Card
import com.leanback.leanbackshowcase.models.CardRow
import com.leanback.leanbackshowcase.models.Movie
import com.leanback.leanbackshowcase.utils.Utils
import androidx.leanback.widget.ArrayObjectAdapter
import androidx.leanback.widget.ListRow
import androidx.leanback.widget.ListRowPresenter
import androidx.leanback.widget.OnItemViewClickedListener
import androidx.leanback.widget.OnItemViewSelectedListener
import androidx.leanback.widget.Presenter
import androidx.leanback.widget.PresenterSelector
import androidx.leanback.widget.Row
import androidx.leanback.widget.RowPresenter
import com.google.gson.Gson
import com.leanback.leanbackshowcase.R

class MainFragment : BrowseSupportFragment() {
    private var mRowsAdapter: ArrayObjectAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupUIElements()
        setupRowAdapter()
        setupEventListeners()
    }

    private fun setupRowAdapter() {
        mRowsAdapter = ArrayObjectAdapter(ListRowPresenter())
        createRows()
        adapter = mRowsAdapter
    }

    private fun createRows() {
        val json = Utils.inputStreamToString(resources.openRawResource(R.raw.launcher_cards))
        val rows = Gson().fromJson(json, Array<CardRow>::class.java)
        for (row in rows) {
            mRowsAdapter!!.add(createCardRow(row))
        }
    }

    private fun createCardRow(cardRow: CardRow): ListRow {
        val presenterSelector: PresenterSelector = CardPresenterSelector(activity)
        val listRowAdapter = ArrayObjectAdapter(presenterSelector)
        for (card in cardRow.cards) {
            listRowAdapter.add(card)
        }
        return ListRow(listRowAdapter)
    }

    private fun setupUIElements() {
        //设置标题
        title = getString(R.string.browse_title)
        //设置标题图片
        badgeDrawable = resources.getDrawable(R.drawable.title_android_tv, null)
        headersState = HEADERS_DISABLED //header显示状态
        isHeadersTransitionOnBackEnabled = false
        //设置标志色
        brandColor = resources.getColor(R.color.fastlane_background)
    }

    private fun setupEventListeners() {
        //点击事件
        onItemViewClickedListener = ItemViewClickedListener()
        //选中事件
        onItemViewSelectedListener = SimpleItemViewSelectedListener()
    }

    /**
     * 当存在header并且header显示的时候，双击展示项目会出现选中和展示的不是一个的情况。
     */
    private inner class ItemViewClickedListener : OnItemViewClickedListener {
        override fun onItemClicked(
            itemViewHolder: Presenter.ViewHolder?,
            item: Any?,
            rowViewHolder: RowPresenter.ViewHolder?,
            row: Row?
        ) {

            var intent: Intent? = null
            val card = item as Card?
            Log.d("zxm==", "onItemClicked()..item:${item?.title}")
            when (card?.id) {
                0 -> {
                    intent = Intent(
                        activity!!.baseContext, CardExampleActivity::class.java
                    )
                }

                1 -> intent = Intent(
                    activity!!.baseContext, PageAndListRowActivity::class.java
                )

                2 -> {
                    intent = Intent(
                        activity!!.baseContext, GridExampleActivity::class.java
                    )
                }

                3 -> {
                    intent = Intent(
                        activity!!.baseContext, VideoGridExampleActivity::class.java
                    )
                }

                4 -> {
                    intent = Intent(
                        activity!!.baseContext, DetailViewExampleActivity::class.java
                    )
                }

                5 -> {
                    intent = Intent(
                        activity!!.baseContext,
                        DetailViewExampleWithVideoBackgroundActivity::class.java
                    )
                }

                6 -> {
                    intent = Intent(
                        activity!!.baseContext, VideoExampleActivity::class.java
                    )
                }

                7 -> {
                    intent = Intent(
                        activity!!.baseContext, VideoExampleWithExoPlayerActivity::class.java
                    )
                }

                8 -> {
                    intent = Intent(
                        activity!!.baseContext, MusicExampleActivity::class.java
                    )
                }

                9 -> {

                    // Let's create a new Wizard for a given Movie. The movie can come from any sort
                    // of data source. To simplify this example we decode it from a JSON source
                    // which might be loaded from a server in a real world example.
                    intent = Intent(
                        activity!!.baseContext, WizardExampleActivity::class.java
                    )

                    // Prepare extras which contains the Movie and will be passed to the Activity
                    // which is started through the Intent/.
                    val extras = Bundle()
                    val json = Utils.inputStreamToString(
                        resources.openRawResource(R.raw.wizard_example)
                    )
                    val movie = Gson().fromJson(json, Movie::class.java)
                    extras.putSerializable("movie", movie)
                    intent.putExtras(extras)
                }

                10 -> {
                    intent = Intent(
                        activity!!.baseContext, SettingsExampleActivity::class.java
                    )
                    startActivity(intent)
                    return
                }

                11 -> {
                    intent = Intent(
                        activity!!.baseContext, DialogExampleActivity::class.java
                    )
                }

                12 -> {
                    intent = Intent(
                        activity!!.baseContext, DynamicVideoRowsActivity::class.java
                    )
                    startActivity(intent)
                    return
                }

                13 -> {
                    intent = Intent(
                        activity!!.baseContext, LiveDataRowsActivity::class.java
                    )
                    startActivity(intent)
                    return
                }

                else -> {}
            }
            if (intent != null) {
                val bundle =
                    ActivityOptionsCompat.makeSceneTransitionAnimation(activity!!).toBundle()
                startActivity(intent, bundle)
            }
        }

    }

    private inner class SimpleItemViewSelectedListener : OnItemViewSelectedListener {
        override fun onItemSelected(
            itemViewHolder: Presenter.ViewHolder?,
            item: Any?,
            rowViewHolder: RowPresenter.ViewHolder?,
            row: Row?
        ) {
            Log.d("zxm==", "onItemSelected()..item:${(item as Card?)?.title}")
        }

    }

}