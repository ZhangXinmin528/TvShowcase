/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.leanback.leanbackshowcase.app.room.di.androidinject;

import com.leanback.leanbackshowcase.app.room.di.adapter.AdapterModule;
import com.leanback.leanbackshowcase.app.room.di.listener.ListenerModule;
import com.leanback.leanbackshowcase.app.room.di.presenter.PresenterModule;
import com.leanback.leanbackshowcase.app.room.di.row.RowModule;

import dagger.Module;

@Module(includes = {AdapterModule.class, RowModule.class, ListenerModule.class, PresenterModule.class})
public class SearchFragmentUIModule {

}
