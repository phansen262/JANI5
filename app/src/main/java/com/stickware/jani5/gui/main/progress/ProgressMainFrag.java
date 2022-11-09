package com.stickware.jani5.gui.main.progress;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.stickware.jani5.databinding.MainProgressMainFragBinding;

public class ProgressMainFrag extends Fragment {

    private MainProgressMainFragBinding mBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        mBinding = MainProgressMainFragBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }
}
