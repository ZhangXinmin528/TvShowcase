/*
 * Copyright (C) 2014 The Android Open Source Project
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

package com.leanback.leanbackshowcase.app.room.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.leanback.leanbackshowcase.app.room.db.dao.CategoryDao;
import com.leanback.leanbackshowcase.app.room.db.dao.VideoDao;
import com.leanback.leanbackshowcase.app.room.db.entity.CategoryEntity;
import com.leanback.leanbackshowcase.app.room.db.entity.VideoEntity;


@Database(entities = {VideoEntity.class, CategoryEntity.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase{
    public static final String DATABASE_NAME = "leanback_showcase.db";

    public abstract VideoDao videoDao();

    public abstract CategoryDao categoryDao();
}
