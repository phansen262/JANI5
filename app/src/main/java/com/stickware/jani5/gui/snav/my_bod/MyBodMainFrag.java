package com.stickware.jani5.gui.snav.my_bod;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.stickware.jani5.databinding.SnavMybodMainFragBinding;

public class MyBodMainFrag extends Fragment {

    private SnavMybodMainFragBinding mBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        mBinding = SnavMybodMainFragBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }
}
