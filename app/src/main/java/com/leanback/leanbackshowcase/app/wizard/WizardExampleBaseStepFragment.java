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

package com.leanback.leanbackshowcase.app.wizard;

import android.os.Bundle;
import androidx.leanback.app.GuidedStepFragment;

import com.leanback.leanbackshowcase.R;
import com.leanback.leanbackshowcase.models.Movie;

/**
 * A base class which provides all it's implementations with a method #getWizardActivity(). It also
 * makes sure that the wizard is using the correct theme.
 */
public abstract class WizardExampleBaseStepFragment extends GuidedStepFragment {

    protected Movie mMovie;

    @Override
    public int onProvideTheme() {
        return R.style.Theme_Example_LeanbackWizard;
    }

    WizardExampleActivity getWizardActivity() {
        if (!(getActivity() instanceof WizardExampleActivity)) {
            throw new IllegalStateException(WizardExampleActivity.class.getName() + " expected.");
        }
        return (WizardExampleActivity) getActivity();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        mMovie = (Movie) getArguments().getSerializable("movie");
        super.onCreate(savedInstanceState);
    }
}
