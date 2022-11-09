package com.stickware.jani5.gui.snav.plan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.stickware.jani5.databinding.SnavPlanMainFragBinding;

public class PlanMainFrag extends Fragment {

    private SnavPlanMainFragBinding mBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        mBinding = SnavPlanMainFragBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }
}
