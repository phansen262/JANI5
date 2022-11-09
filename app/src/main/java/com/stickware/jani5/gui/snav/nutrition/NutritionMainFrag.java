package com.stickware.jani5.gui.snav.nutrition;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.stickware.jani5.databinding.SnavNutritionMainFragBinding;

public class NutritionMainFrag extends Fragment {

    private SnavNutritionMainFragBinding mBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        mBinding = SnavNutritionMainFragBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }
}
