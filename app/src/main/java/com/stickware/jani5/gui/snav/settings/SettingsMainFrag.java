package com.stickware.jani5.gui.snav.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.stickware.jani5.databinding.SnavSettingsMainFragBinding;

public class SettingsMainFrag extends Fragment {

    private SnavSettingsMainFragBinding mBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        mBinding = SnavSettingsMainFragBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }
}
