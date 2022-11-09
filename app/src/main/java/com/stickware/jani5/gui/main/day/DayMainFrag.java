package com.stickware.jani5.gui.main.day;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.stickware.jani5.databinding.MainDayMainFragBinding;

public class DayMainFrag extends Fragment {

    private MainDayMainFragBinding mBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        mBinding = MainDayMainFragBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }
}
