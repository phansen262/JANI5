package com.stickware.jani5.gui.main.timeline;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.stickware.jani5.databinding.MainTimelineMainFragBinding;

public class TimelineMainFrag extends Fragment {

    private MainTimelineMainFragBinding mBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        mBinding = MainTimelineMainFragBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }
}
