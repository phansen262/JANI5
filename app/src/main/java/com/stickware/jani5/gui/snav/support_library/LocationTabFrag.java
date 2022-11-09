package com.stickware.jani5.gui.snav.support_library;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.stickware.jani5.databinding.SnavSlLocationTabFragBinding;

public class LocationTabFrag extends Fragment {

    private SnavSlLocationTabFragBinding mBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        mBinding = SnavSlLocationTabFragBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }
}
