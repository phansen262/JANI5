package com.stickware.jani5.gui.snav.support_library;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.stickware.jani5.databinding.SnavSlEquipmentTabFragBinding;

public class EquipmentTabFrag extends Fragment {

    private SnavSlEquipmentTabFragBinding mBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        mBinding = SnavSlEquipmentTabFragBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }
}
